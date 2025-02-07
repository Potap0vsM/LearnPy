package com.example.pythonapp.repositories

import androidx.lifecycle.LiveData
import com.example.pythonapp.database.roomdb_achievements.Achievement
import com.example.pythonapp.database.roomdb_achievements.AchievementDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AchievementRepository(private val achievementDao: AchievementDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val achievementList: LiveData<List<Achievement>> = achievementDao.getAchievements()

    fun addAchievement(achievement: Achievement){
        coroutineScope.launch(Dispatchers.IO){
            achievementDao.addAchievement(achievement)
        }
    }

    fun editAchievement(id: Int, name: String, src: Int, active:Int){
        coroutineScope.launch(Dispatchers.IO){
            achievementDao.update(id, name, src, active)
        }
    }

    fun deleteAchievement(achievementName: String){
        coroutineScope.launch(Dispatchers.IO){
            achievementDao.deleteAchievement(achievementName)
        }
    }
}