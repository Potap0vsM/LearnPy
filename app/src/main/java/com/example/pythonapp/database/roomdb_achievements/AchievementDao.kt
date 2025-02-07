package com.example.pythonapp.database.roomdb_achievements

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AchievementDao {
    @Insert
    fun addAchievement(achievement: Achievement)

    @Query("SELECT * FROM achievement")
    fun getAchievements(): LiveData<List<Achievement>>

    @Query("SELECT * FROM achievement WHERE id = :id")
    fun getAchievement(id: Int): LiveData<Achievement>

    @Query("UPDATE achievement SET name = :name, src = :src, active = :active WHERE id = :id")
    fun update(id: Int, name: String, src: Int, active:Int)

    @Query("DELETE FROM achievement WHERE name = :name")
    fun deleteAchievement(name: String)
}