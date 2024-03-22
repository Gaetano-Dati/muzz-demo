package com.garrodroideveloper.muzzexercise.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.garrodroideveloper.muzzexercise.storage.dao.MessageDao
import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.entities.Message
import com.garrodroideveloper.muzzexercise.storage.entities.User

@Database(entities = [User::class, Message::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun messageDao(): MessageDao
}
