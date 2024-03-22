package com.garrodroideveloper.muzzexercise.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "created_at") val createdAt: Long,
    @ColumnInfo(name = "has_been_seen") val hasBeenSeen: Boolean,
    @ColumnInfo(name = "message") val message: String,
    @ColumnInfo(name = "sent_by") val username: String
)
