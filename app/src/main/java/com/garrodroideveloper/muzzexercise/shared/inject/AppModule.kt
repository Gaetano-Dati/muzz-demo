package com.garrodroideveloper.muzzexercise.shared.inject

import android.content.Context
import androidx.room.Room
import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt class for injecting various classes
 * The purpose will be to inject both Users and Messages
 * */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase =
        Room.databaseBuilder(
            context = context,
            AppDatabase::class.java,
            "room_database",
        ).build()

    @Singleton
    @Provides
    fun provideUserDao(roomDatabase: AppDatabase): UserDao = roomDatabase.userDao()
}
