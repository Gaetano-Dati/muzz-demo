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
    val userDao: UserDao,
    val messageDao: MessageDao,
) : ViewModel() {
    val username: String = savedStateHandle.get<String>("username").orEmpty()

    private val _messages: MutableStateFlow<List<Message>> = MutableStateFlow(listOf())
    val messages: StateFlow<List<Message>> = _messages

    init {
        Timber.d("Username -> $username")
        viewModelScope.launch {
            val userId =
                userDao.getAllUsers().firstOrNull {
                    it.firstName == username
                }?.uid

            val messages = messageDao.getAllMessages()
            Timber.d("Messages -> $messages")
        }
    }
}
