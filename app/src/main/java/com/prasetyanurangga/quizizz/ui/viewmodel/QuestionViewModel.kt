package com.prasetyanurangga.quizizz.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.prasetyanurangga.quizizz.data.repository.QuestionRepository


class QuestionViewModel (private var questionRepository: QuestionRepository): ViewModel(){
    var getQuestions: LiveData<List<QuestionModel>> = questionRepository.getQuestions()

    fun getQuestionsById(id: Int): LiveData<List<QuestionModel>>{
        return questionRepository.getQuestionsById(id);
    }

    fun getQuestionsByCategoryId(id: Int): LiveData<List<QuestionModel>>{
        return questionRepository.getQuestionsByCategoryId(id);
    }
    
    fun saveQuestion(questionModel: QuestionModel): LiveData<List<QuestionModel>>{
        questionRepository.addQuestion(questionModel)
        return questionRepository.getQuestions();
    }

    fun deleteCategory(questionModel: QuestionModel): LiveData<List<QuestionModel>>{
        questionRepository.deleteQuestion(questionModel)
        return questionRepository.getQuestions();
    }

    fun updateCategory(questionModel: QuestionModel): LiveData<List<QuestionModel>>{
        questionRepository.updateQuestion(questionModel)
        return questionRepository.getQuestions();
    }
}