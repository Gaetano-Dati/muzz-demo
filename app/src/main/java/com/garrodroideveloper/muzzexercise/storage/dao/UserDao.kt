package com.garrodroideveloper.muzzexercise.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.garrodroideveloper.muzzexercise.storage.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    // Obviously this is not right (because you shouldn't insert any ) but it's for speed development purposes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)
}
