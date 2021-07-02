package com.example.pollapp.ui

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pollapp.ui.dao.PollDao
import com.example.pollapp.ui.data.model.Poll

@Database(
    entities = [Poll::class],
    version = 1
)
abstract class PollDB() : RoomDatabase() {
    abstract fun pollDao(): PollDao

    companion object {
        @Volatile
        private var INSTANCE: PollDB? = null
        fun getDatabase(context: Context): PollDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PollDB::class.java,
                    "PollAppDB"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}