package com.example.pythonapp.database.roomdb_achievements

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Achievement(
    @PrimaryKey val id: Int,
    val name: String,
    val src: Int,
    val active: Boolean
)
