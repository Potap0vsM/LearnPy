package com.example.pythonapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pythonapp.bottom_navigation.MainScreen
import com.example.pythonapp.database.DatabaseAlles
import com.example.pythonapp.database.roomdb_achievements.Achievement
import com.example.pythonapp.database.roomdb_question.Question
import com.example.pythonapp.database.roomdb_user.User
import com.example.pythonapp.database.roomdb_userachievment.UserAchievement
import com.example.pythonapp.database.roomdb_userquest.UserQuest
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

        val newUser = User(id = 1, name = "Test")

        val newQuestion1 = Question(1, "First Question", "First right answer", "First topic")
        val newQuestion2 = Question(2, "Second Question", "Second right answer", "Second topic")
        val newQuestion3 = Question(3, "Third Question", "Third right answer", "Third topic")
        val newQuestion4 = Question(4, "Fourth Question", "Fourth right answer", "Fourth topic")
        val newQuestion5 = Question(5, "Fifth Question", "Fifth right answer", "Fifth topic")

        val newUserQuestionConnection1 = UserQuest(1, 1, 1, false)
        val newUserQuestionConnection2 = UserQuest(2, 1, 2, false)
        val newUserQuestionConnection3 = UserQuest(3, 1, 3, false)
        val newUserQuestionConnection4 = UserQuest(4, 1, 4, false)
        val newUserQuestionConnection5 = UserQuest(5, 1, 5, false)

        val newAchievement1 = Achievement(1, "First achievement", R.drawable.learn_icon, false)
        val newAchievement2 = Achievement(2, "Second achievement", R.drawable.account_icon, false)



        val newUserAchievement1 = UserAchievement(1, 1, 1)
        val newUserAchievement2 = UserAchievement(2, 1, 2)

        val newUser2 = User(id = 2, name = "Test")

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

        Log.d("RepoCheck", repositoryAchievement.achievementList.value.toString())
    }
}

