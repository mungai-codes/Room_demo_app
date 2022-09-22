package com.mungaicodes.roomdemoapp.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mungaicodes.roomdemoapp.model.User

@androidx.room.Database(entities = [User::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: Database? = null

        fun getDatabase(context: Context): Database {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}