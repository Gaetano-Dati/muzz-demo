package com.garrodroideveloper.muzzexercise.shared.inject

import android.app.Application
import androidx.room.Room
import com.garrodroideveloper.muzzexercise.message.MessageRepositoryImpl
import com.garrodroideveloper.muzzexercise.message.repository.MessageRepository
import com.garrodroideveloper.muzzexercise.storage.dao.MessageDao
import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.database.AppDatabase
import com.garrodroideveloper.muzzexercise.user.UserRepository
import com.garrodroideveloper.muzzexercise.user.UserRepositoryImpl
import dagger.Binds
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
abstract class AppModule {
    companion object {
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

    @Binds
    @Singleton
    abstract fun UserRepositoryImpl.provideUserRepository(): UserRepository

    @Binds
    @Singleton
    abstract fun MessageRepositoryImpl.provideMessageRepository(): MessageRepository
}
