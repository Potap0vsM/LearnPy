package com.example.pythonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pythonapp.bottom_navigation.MainScreen
import com.example.pythonapp.database.DatabaseAlles
import com.example.pythonapp.repositories.AchievementRepository
import com.example.pythonapp.repositories.QuestionRepository
import com.example.pythonapp.repositories.UserAchievementRepository
import com.example.pythonapp.repositories.UserQuestRepository
import com.example.pythonapp.repositories.UserRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
        val database = DatabaseAlles.getInstance(application)
        val repositoryAchievement = AchievementRepository(achievementDao = database.achievementDao())
        val repositoryUser = UserRepository(userDao = database.userDao())
        val repositoryQuestion = QuestionRepository(questionDao = database.questionDao())
        val repositoryUserQuest = UserQuestRepository(userQuestDao = database.userQuestDao())
        val repositoryUserAchievement = UserAchievementRepository(userAchievementDao = database.userAchievementDao())

        repositoryQuestion.editQuestion(1, "What function will help you output information?", "print()", "Hello, World!")
        repositoryQuestion.editQuestion(2, "What would be type of this character sequence: '81928'", "String", "Variables and Types")
        repositoryQuestion.editQuestion(3, "What function you will use to add something to a existing list?", "append()", "Lists")
        repositoryQuestion.editQuestion(4, "Which operator returns the integer remainder of the division.", "%", "Basic Operators")
        repositoryQuestion.editQuestion(5, "Which operator would you use to know if your name is in a list of random names?", "in", "Conditions")

        repositoryUser.editUser(1, "Default")
        repositoryAchievement.editAchievement(1, "Started learning", R.drawable.learn_icon, 0)
        repositoryAchievement.editAchievement(2, "Finished all lessons!", R.drawable.account_icon, 0)

        repositoryAchievement.achievementList
        repositoryUser.userList
        repositoryQuestion.questionList
        repositoryUserQuest.userQuestList
        repositoryUserAchievement.userAchievementList
    }
}

