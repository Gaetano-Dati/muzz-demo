package com.garrodroideveloper.muzzexercise.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.garrodroideveloper.muzzexercise.storage.entities.Message
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Query("SELECT * from Message")
    fun getAllMessages(): Flow<List<Message>>

    @Insert
    suspend fun insertMessage(message: Message)

    @Query("UPDATE message SET has_been_seen = :hasBeenSeen WHERE sender_id = :senderId")
    suspend fun updateMessages(
        hasBeenSeen: Boolean,
        senderId: Long,
    )
}
