package com.garrodroideveloper.muzzexercise.shared.inject

import com.garrodroideveloper.muzzexercise.message.MessageRepositoryImpl
import com.garrodroideveloper.muzzexercise.message.repository.MessageRepository
import com.garrodroideveloper.muzzexercise.user.UserRepository
import com.garrodroideveloper.muzzexercise.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun UserRepositoryImpl.provideUserRepository(): UserRepository

    @Binds
    @Singleton
    abstract fun MessageRepositoryImpl.provideMessageRepository(): MessageRepository
}
