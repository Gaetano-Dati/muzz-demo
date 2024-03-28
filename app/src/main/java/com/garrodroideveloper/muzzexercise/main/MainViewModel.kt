package com.garrodroideveloper.muzzexercise.main

import androidx.lifecycle.ViewModel
import com.garrodroideveloper.muzzexercise.message.repository.MessageRepository
import com.garrodroideveloper.muzzexercise.shared.inject.ApplicationScope
import com.garrodroideveloper.muzzexercise.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        @ApplicationScope private val scope: CoroutineScope,
        private val userRepository: UserRepository,
        private val messageRepository: MessageRepository,
    ) : ViewModel() {
        fun populateUserDatabase() =
            scope.launch {
                userRepository.getUsers()
                messageRepository.getMessages()
            }
    }
