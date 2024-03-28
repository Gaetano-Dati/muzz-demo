package com.garrodroideveloper.muzzexercise.user

import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.entities.User
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class UserRepositoryImpl
    @Inject
    constructor(
        private val userDao: UserDao,
    ) : UserRepository {
        private val _users = MutableSharedFlow<List<User>>(replay = 1)
        override val users: SharedFlow<List<User>>
            get() = _users

        override suspend fun getUsers() {
            userDao.getAllUsers().collect {
                if (it.isEmpty() || it.size == 1) {
                    userDao.insertUser(User(uid = "0", firstName = "User"))
                    userDao.insertUser(User(uid = "1", firstName = "Sarah"))
                } else {
                    _users.emit(it)
                }
            }
        }
    }
