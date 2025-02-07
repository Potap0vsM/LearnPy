package com.example.pythonapp.database.roomdb_userquest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.pythonapp.database.roomdb_question.Question
import com.example.pythonapp.database.roomdb_user.User

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["id_user"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Question::class,
            parentColumns = ["id"],
            childColumns = ["id_q"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class UserQuest(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "id_user") val userId: Int,
    @ColumnInfo(name = "id_q") val questId: Int,
    val isAns: Boolean
)
