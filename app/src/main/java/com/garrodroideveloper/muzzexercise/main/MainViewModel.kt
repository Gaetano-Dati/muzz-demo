package com.garrodroideveloper.muzzexercise.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.entities.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        private val userDao: UserDao,
    ) : ViewModel() {
        fun populateUserDatabase() =
            viewModelScope.launch {
                val users = userDao.getAllUsers()
                if (users.isEmpty()) {
                    val userList =
                        listOf(
                            User(firstName = "User"),
                            User(firstName = "Sarah"),
                        )
                    userDao.insertUsers(userList)
                }
            }
    }
