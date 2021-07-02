package com.example.pollapp.ui.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Poll (
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val title:String = "",
    val creator:String=""
)
