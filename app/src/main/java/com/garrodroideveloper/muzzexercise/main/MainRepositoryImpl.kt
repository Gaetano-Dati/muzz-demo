package com.garrodroideveloper.muzzexercise.main

import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.entities.User
import javax.inject.Inject

class MainRepositoryImpl
    @Inject
    constructor(
        val userDao: UserDao,
    ) : MainRepository {
        override suspend fun populateDatabase() {
            val usersList = userDao.getAllUsers()
            if (usersList.isEmpty()) {
                userDao.insertUser(User(firstName = "User"))
                userDao.insertUser(User(firstName = "Sarah"))
            }
        }
    }
