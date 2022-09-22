package com.mungaicodes.roomdemoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mungaicodes.roomdemoapp.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("delete from user_table")
    suspend fun deleteAll()

    @Update
    suspend fun updateUser(user: User)

    @Query("select * from user_table order by id asc")
    fun readAllData(): LiveData<List<User>>
}