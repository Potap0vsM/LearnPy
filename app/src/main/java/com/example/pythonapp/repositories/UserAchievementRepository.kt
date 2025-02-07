package com.example.pythonapp.repositories

import androidx.lifecycle.LiveData
import com.example.pythonapp.database.roomdb_achievements.Achievement
import com.example.pythonapp.database.roomdb_userachievment.UserAchievement
import com.example.pythonapp.database.roomdb_userachievment.UserAchievementDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserAchievementRepository(private val userAchievementDao: UserAchievementDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val userAchievementList: LiveData<List<UserAchievement>> = userAchievementDao.getAll()

    fun addUserAchievement(achieuserAchievement: UserAchievement){
        coroutineScope.launch(Dispatchers.IO){
            userAchievementDao.insert(achieuserAchievement)
        }
    }

    fun deleteUserAchievement(userAchievementName: String){
        coroutineScope.launch(Dispatchers.IO){
            userAchievementDao.deleteUsAchie(userAchievementName)
        }
    }
}