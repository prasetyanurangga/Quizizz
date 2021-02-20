package com.prasetyanurangga.quizizz.data.di.module

import com.prasetyanurangga.quizizz.data.database.AppDatabase
import com.prasetyanurangga.quizizz.data.repository.CategoryRepository
import com.prasetyanurangga.quizizz.data.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QuizizzModule {

    @Singleton
    @Provides
    fun categoryRepository(appDatabase: AppDatabase): CategoryRepository{
        return CategoryRepository(appDatabase)
    }

    @Singleton
    @Provides
    fun questionRepository(appDatabase: AppDatabase): QuestionRepository{
        return QuestionRepository(appDatabase)
    }

}