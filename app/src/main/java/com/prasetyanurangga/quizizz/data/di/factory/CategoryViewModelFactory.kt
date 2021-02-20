package com.prasetyanurangga.quizizz.data.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prasetyanurangga.quizizz.data.repository.CategoryRepository
import com.prasetyanurangga.quizizz.ui.viewmodel.CategoryViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryViewModelFactory @Inject constructor(private var categoryRepository: CategoryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoryViewModel(categoryRepository) as T
    }
}