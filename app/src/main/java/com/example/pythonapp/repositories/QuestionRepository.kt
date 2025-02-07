package com.example.pythonapp.repositories

import android.adservices.topics.Topic
import androidx.lifecycle.LiveData
import com.example.pythonapp.database.roomdb_question.Question
import com.example.pythonapp.database.roomdb_question.QuestionDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionRepository(private val questionDao: QuestionDao) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val questionList: LiveData<List<Question>> = questionDao.getQuestions()

    fun addQuestion(question: Question){
        coroutineScope.launch(Dispatchers.IO){
            questionDao.insert(question)
        }
    }

    fun editQuestion(id: Int, text: String, answer: String, topic: String){
        coroutineScope.launch(Dispatchers.IO) {
            questionDao.update(id, text, answer, topic)
        }
    }

}