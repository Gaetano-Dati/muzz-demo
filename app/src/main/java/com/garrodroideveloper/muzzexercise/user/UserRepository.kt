package com.garrodroideveloper.muzzexercise.user

import com.garrodroideveloper.muzzexercise.storage.entities.User
import kotlinx.coroutines.flow.SharedFlow

interface UserRepository {
    val users: SharedFlow<List<User>>

    /**
     * This populates the SharedFlow
     * */
    suspend fun getUsers()
}
