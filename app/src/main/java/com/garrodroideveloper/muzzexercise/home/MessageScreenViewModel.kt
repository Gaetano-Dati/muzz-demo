package com.garrodroideveloper.muzzexercise.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garrodroideveloper.muzzexercise.storage.dao.MessageDao
import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.entities.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MessageScreenViewModel
    @Inject
    constructor(
        savedStateHandle: SavedStateHandle,
        private val userDao: UserDao,
        private val messageDao: MessageDao,
    ) : ViewModel() {
        private val username: String = savedStateHandle.get<String>("username").orEmpty()

        private val _userId: MutableStateFlow<String> = MutableStateFlow("")
        val userId: StateFlow<String> = _userId

        private val _messages: MutableStateFlow<List<Message>> = MutableStateFlow(listOf())
        val messages: StateFlow<List<Message>> = _messages

        init {
            Timber.d("Username -> $username")
            viewModelScope.launch {
                _userId.value =
                    userDao.getAllUsers().firstOrNull {
                        it.firstName == username
                    }?.uid.orEmpty()

                val messages = messageDao.getAllMessages()
                Timber.d("Messages -> $messages")
                val unseenMessages =
                    messages.filter {
                        !it.hasBeenSeen
                    }
                unseenMessages.forEach {
                    messageDao.updateMessage(true, it.id ?: 0)
                }
                val updatedMessages = messageDao.getAllMessages()
                _messages.value = updatedMessages
            }
        }

        fun addMessage(message: String) =
            viewModelScope.launch {
                val newMessage =
                    Message(
                        createdAt = System.currentTimeMillis(),
                        hasBeenSeen = false,
                        message = message,
                        senderId = _userId.value,
                    )
                messageDao.insertMessage(newMessage)
                val newMessages = messageDao.getAllMessages()
                _messages.value = newMessages
            }
    }
