package com.example.pythonapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pythonapp.database.roomdb_achievements.Achievement
import com.example.pythonapp.database.roomdb_achievements.AchievementDao
import com.example.pythonapp.database.roomdb_question.Question
import com.example.pythonapp.database.roomdb_question.QuestionDao
import com.example.pythonapp.database.roomdb_user.User
import com.example.pythonapp.database.roomdb_user.UserDao
import com.example.pythonapp.database.roomdb_userachievment.UserAchievement
import com.example.pythonapp.database.roomdb_userachievment.UserAchievementDao
import com.example.pythonapp.database.roomdb_userquest.UserQuest
import com.example.pythonapp.database.roomdb_userquest.UserQuestDao


@Database(entities = [Achievement::class, User::class, Question::class, UserAchievement::class, UserQuest::class], version = 2)
abstract class DatabaseAlles : RoomDatabase() {
    abstract fun achievementDao(): AchievementDao
    abstract fun userDao(): UserDao
    abstract fun questionDao(): QuestionDao
    abstract fun userAchievementDao(): UserAchievementDao
    abstract fun userQuestDao(): UserQuestDao

    companion object {
        private var INSTANCE: DatabaseAlles? = null
        private val MIGRATION_1_2: Migration =
            object : Migration(1, 2) {
                override fun migrate(db: SupportSQLiteDatabase) {
                    db.execSQL(
                        "CREATE TABLE achievement_new (id INTEGER NOT NULL, name TEXT NOT NULL, src INTEGER NOT NULL, active INTEGER NOT NULL, PRIMARY KEY(id))"
                    )

                    db.execSQL(
                    "INSERT INTO achievement_new (id, name, src, active) SELECT id, name, src, active FROM Achievement"
                    )

                    db.execSQL(
                        "DROP TABLE Achievement"
                    )

                    db.execSQL(
                        "ALTER TABLE achievement_new RENAME TO Achievement"
                    )
                }
            }
        fun getInstance(context: Context): DatabaseAlles {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseAlles::class.java,
                        "Database_alles"

                    ).addMigrations(MIGRATION_1_2).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}