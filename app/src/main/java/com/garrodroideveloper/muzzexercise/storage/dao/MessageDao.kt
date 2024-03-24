package com.garrodroideveloper.muzzexercise.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.garrodroideveloper.muzzexercise.storage.entities.Message

@Dao
interface MessageDao {
    @Query("SELECT * from Message")
    suspend fun getAllMessages(): List<Message>

    @Insert
    suspend fun insertMessage(message: Message)
}
