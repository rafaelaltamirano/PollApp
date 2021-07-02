package com.example.pollapp.ui.app

import android.app.Application
import androidx.room.Room
import com.example.pollapp.ui.PollDB

class PollApp : Application() {
    val room = Room.databaseBuilder(applicationContext,PollDB::class.java,"pollAppDB")
        .build()
}