package com.example.pythonapp.repositories

import androidx.lifecycle.LiveData
import com.example.pythonapp.database.roomdb_userquest.UserQuest
import com.example.pythonapp.database.roomdb_userquest.UserQuestDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserQuestRepository(private val userQuestDao: UserQuestDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val userQuestList: LiveData<List<UserQuest>> = userQuestDao.getUserQuests()

    fun addUserQuest(userQuest: UserQuest){
        coroutineScope.launch(Dispatchers.IO){
            userQuestDao.insert(userQuest)
        }
    }

    fun deleteUserQuest(userQuestName: String){
        coroutineScope.launch(Dispatchers.IO){
            userQuestDao.deleteUserQuest(userQuestName)
        }
    }
}
