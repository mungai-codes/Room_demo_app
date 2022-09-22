package com.mungaicodes.roomdemoapp.data

import androidx.lifecycle.LiveData

class Repository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

}