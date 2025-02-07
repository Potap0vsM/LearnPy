package com.example.pythonapp.database.roomdb_question

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionDao {
    @Insert
    fun insert(quest: Question)

    @Query("UPDATE question SET text = :text, answer = :answer, topic = :topic WHERE id = :id")
    fun update(id: Int, text: String, answer: String, topic: String)

    @Query("SELECT * FROM Question")
    fun getQuestions(): LiveData<List<Question>>
}