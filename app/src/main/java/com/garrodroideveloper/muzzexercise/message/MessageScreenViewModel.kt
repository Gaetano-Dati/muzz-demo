package com.garrodroideveloper.muzzexercise.message

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garrodroideveloper.muzzexercise.message.repository.MessageRepository
import com.garrodroideveloper.muzzexercise.storage.entities.Message
import com.garrodroideveloper.muzzexercise.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageScreenViewModel
    @Inject
    constructor(
        savedStateHandle: SavedStateHandle,
        userRepository: UserRepository,
        private val messageRepository: MessageRepository,
    ) : ViewModel() {
        private val username: String = savedStateHandle.get<String>("username").orEmpty()

        val userIds: SharedFlow<Pair<String, String>> =
            userRepository.users.map {
                val myId = it.firstOrNull { user -> user.firstName == username }?.uid.orEmpty()
                val otherId = it.firstOrNull { user -> user.firstName != username }?.uid.orEmpty()
                Pair(myId, otherId)
            }.shareIn(viewModelScope, SharingStarted.Lazily, 1)

        val messages: SharedFlow<List<Message>> =
            messageRepository.messages.combine(userIds) { messages, userIds ->
                if (userIds.second != username) {
                    updateAllMessages(userIds.second)
                }
                messages
            }.shareIn(viewModelScope, SharingStarted.Lazily, 1)

        init {
            viewModelScope.launch(Dispatchers.IO) {
                messageRepository.getMessages()
            }
        }

        fun addMessage(
            message: String,
            myUserId: String,
        ) {
            viewModelScope.launch(Dispatchers.IO) {
                val newMessage =
                    Message(
                        createdAt = System.currentTimeMillis(),
                        hasBeenSeen = false,
                        message = message,
                        senderId = myUserId,
                    )
                messageRepository.insertMessage(newMessage)
                messageRepository.getMessages()
            }
        }

        suspend fun updateAllMessages(senderId: String) {
            viewModelScope.launch(Dispatchers.IO) {
                messageRepository.updateMessages(true, senderId = senderId.toLong())
            }
        }
    }
