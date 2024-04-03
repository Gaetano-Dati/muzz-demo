package com.garrodroideveloper.muzzexercise.shared.inject

import android.app.Application
import androidx.room.Room
import com.garrodroideveloper.muzzexercise.storage.dao.MessageDao
import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

/**
 * Hilt class for injecting various classes
 * The purpose will be to inject both Users and Messages
 * */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @ApplicationScope
    fun provideApplicationCoroutineScope(): CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    @Singleton
    @Provides
    fun provideRoomDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "room_database",
        ).build()

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()

    @Singleton
    @Provides
    fun provideMessageDao(appDatabase: AppDatabase): MessageDao = appDatabase.messageDao()
}
