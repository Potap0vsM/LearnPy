package com.example.pythonapp.database.roomdb_userachievment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.pythonapp.database.roomdb_achievements.Achievement
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
            entity = Achievement::class,
            parentColumns = ["id"],
            childColumns = ["id_ach"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class UserAchievement(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "id_user") val userId: Int,
    @ColumnInfo(name = "id_ach") val achievementId: Int
)