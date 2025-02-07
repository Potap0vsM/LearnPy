package com.example.pythonapp.database.roomdb_userachievment

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserAchievementDao {
    @Insert
    fun insert(userAchievement: UserAchievement)

    @Query("SELECT * FROM UserAchievement")
    fun getAll(): LiveData<List<UserAchievement>>

    @Query("DELETE FROM achievement WHERE name = :name")
    fun deleteUsAchie(name: String)
}
