package com.mungaicodes.roomdemoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mungaicodes.roomdemoapp.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("select * from user_table order by id asc")
    fun readAllData(): LiveData<List<User>>
}