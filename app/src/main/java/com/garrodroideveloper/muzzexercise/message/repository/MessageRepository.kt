package com.garrodroideveloper.muzzexercise.message.repository

import com.garrodroideveloper.muzzexercise.storage.entities.Message
import kotlinx.coroutines.flow.SharedFlow

interface MessageRepository {
    val messages: SharedFlow<List<Message>>

    /**
     * This updates the messages SharedFlow
     * */
    suspend fun getMessages()

    suspend fun updateMessages(
        hasBeenSeen: Boolean,
        senderId: Long,
    )

    suspend fun insertMessage(message: Message)
}
