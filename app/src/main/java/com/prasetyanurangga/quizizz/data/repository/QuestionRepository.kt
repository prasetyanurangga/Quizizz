package com.prasetyanurangga.quizizz.data.repository

import androidx.lifecycle.LiveData
import com.prasetyanurangga.quizizz.data.dao.QuestionDao
import com.prasetyanurangga.quizizz.data.database.AppDatabase
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionRepository(appDatabase: AppDatabase) {

    private var questionDao: QuestionDao = appDatabase.questionDao()

    fun getQuestions(): LiveData<List<QuestionModel>>{
        return questionDao.getAll()
    }

    fun getQuestionsById(id: Int): LiveData<List<QuestionModel>>{
        return questionDao.getById(id)
    }

    fun getQuestionsByCategoryId(id: Int): LiveData<List<QuestionModel>>{
        return questionDao.getByCategoryId(id)
    }

    fun addQuestion(questionModel: QuestionModel){
        CoroutineScope(Dispatchers.IO).launch {
            questionDao.saveQuestion(questionModel)
        }
    }

    fun deleteQuestion(questionModel: QuestionModel){
        CoroutineScope(Dispatchers.IO).launch {
            questionDao.deleteQuestion(questionModel)
        }
    }

    fun updateQuestion(questionModel: QuestionModel){
        CoroutineScope(Dispatchers.IO).launch {
            questionDao.updateQuestion(questionModel)
        }
    }

}