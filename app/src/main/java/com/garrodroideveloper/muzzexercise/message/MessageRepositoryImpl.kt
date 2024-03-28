package com.garrodroideveloper.muzzexercise.message

import com.garrodroideveloper.muzzexercise.message.repository.MessageRepository
import com.garrodroideveloper.muzzexercise.storage.dao.MessageDao
import com.garrodroideveloper.muzzexercise.storage.entities.Message
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class MessageRepositoryImpl
    @Inject
    constructor(
        private val messageDao: MessageDao,
    ) : MessageRepository {
        private val _messages: MutableSharedFlow<List<Message>> = MutableSharedFlow(replay = 1)
        override val messages: SharedFlow<List<Message>>
            get() = _messages

        override suspend fun getMessages() {
            messageDao.getAllMessages().collectLatest {
                _messages.emit(it)
            }
        }

        override suspend fun insertMessage(message: Message) {
            messageDao.insertMessage(message = message)
        }

        override suspend fun updateMessages(
            hasBeenSeen: Boolean,
            senderId: Long,
        ) {
            messageDao.updateMessages(hasBeenSeen, senderId)
        }
    }
