package com.mungaicodes.roomdemoapp.repo

import androidx.lifecycle.LiveData
import com.mungaicodes.roomdemoapp.data.UserDao
import com.mungaicodes.roomdemoapp.model.User

class Repository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

}