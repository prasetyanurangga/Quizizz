package com.prasetyanurangga.quizizz.data.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prasetyanurangga.quizizz.data.repository.QuestionRepository
import com.prasetyanurangga.quizizz.ui.viewmodel.QuestionViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionViewModelFactory @Inject constructor(private var questionRepository: QuestionRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuestionViewModel(questionRepository) as T
    }
}