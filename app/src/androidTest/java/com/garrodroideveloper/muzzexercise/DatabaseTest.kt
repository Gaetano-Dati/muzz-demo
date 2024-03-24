package com.garrodroideveloper.muzzexercise

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.garrodroideveloper.muzzexercise.storage.dao.MessageDao
import com.garrodroideveloper.muzzexercise.storage.dao.UserDao
import com.garrodroideveloper.muzzexercise.storage.database.AppDatabase
import com.garrodroideveloper.muzzexercise.storage.entities.Message
import com.garrodroideveloper.muzzexercise.storage.entities.User
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao
    private lateinit var messageDao: MessageDao

    @Before
    fun setup() {
        database =
            Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                AppDatabase::class.java,
            ).allowMainThreadQueries().build()

        userDao = database.userDao()
        messageDao = database.messageDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun initializeUsers_addOneUser_verifyItsContainedInRoom() =
        runBlocking {
            val user = User(uid = "0", firstName = "User")
            userDao.insertUser(user)

            val users = userDao.getAllUsers()

            assertEquals(user, users.first())
        }

    @Test
    fun initializeUsers_insertUser_verifyCorrectlyUpdated() =
        runBlocking {
            val user = User(uid = "0", firstName = "User")
            userDao.insertUser(user)

            val users = userDao.getAllUsers()

            assertEquals(user, users.first())

            userDao.insertUser(user.copy(firstName = "Sophia"))

            val newUsers = userDao.getAllUsers()

            assertEquals(user.copy(firstName = "Sophia"), newUsers.first())
        }

    @Test
    fun emptyDatabase_verifyEmptyListReturned() =
        runBlocking {
            val emptyList = userDao.getAllUsers()
            assertEquals(listOf<User>(), emptyList)
        }

    @Test
    fun emptyMessages_verifyEmptyListReturned() =
        runBlocking {
            val emptyMessages = messageDao.getAllMessages()
            assertEquals(listOf<Message>(), emptyMessages)
        }

    @Test
    fun insertOneMessage_verifyCorrectlyInserted() =
        runBlocking {
            val message =
                Message(
                    createdAt = 0L,
                    hasBeenSeen = false,
                    message = "This is my message",
                    senderId = "senderId",
                )
            messageDao.insertMessage(message)

            val messages = messageDao.getAllMessages()

            assertEquals(message.message, messages.first().message)
        }

    @Test
    fun insertMessage_updateMessage_verifyItsUpdated() =
        runBlocking {
            val message =
                Message(
                    id = 100L,
                    createdAt = 0L,
                    hasBeenSeen = false,
                    message = "This is my message",
                    senderId = "senderId",
                )
            messageDao.insertMessage(message)

            val messages = messageDao.getAllMessages()

            assertEquals(message.hasBeenSeen, messages.first().hasBeenSeen)

            val updatedMessage = message.copy(hasBeenSeen = true)

            messageDao.updateMessage(true, 100L)

            val updatedMessages = messageDao.getAllMessages()

            assertEquals(updatedMessage.hasBeenSeen, updatedMessages.first().hasBeenSeen)
        }
}
