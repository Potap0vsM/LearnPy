package com.example.pythonapp.database.roomdb_userquest

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserQuestDao {
    @Insert
    fun insert(userQuest: UserQuest)

    @Query("SELECT * FROM UserQuest")
    fun getUserQuests(): LiveData<List<UserQuest>>

    @Query("DELETE FROM achievement WHERE name = :name")
    fun deleteUserQuest(name: String)
}