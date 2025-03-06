package com.example.pythonapp.database.roomdb_question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey val id: Int,
    val text: String,
    val answer: String,
    val topic: String
)