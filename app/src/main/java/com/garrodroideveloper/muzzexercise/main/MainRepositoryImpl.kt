package com.garrodroideveloper.muzzexercise.main

import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.entities.User
import javax.inject.Inject

class MainRepositoryImpl
    @Inject
    constructor(
        private val userDao: UserDao,
    ) : MainRepository {
        override suspend fun populateDatabase() {
            val usersList = userDao.getAllUsers()
            if (usersList.isEmpty()) {
                userDao.insertUser(User(uid = 0, firstName = "User"))
                userDao.insertUser(User(uid = 1, firstName = "Sarah"))
            }
        }
    }
