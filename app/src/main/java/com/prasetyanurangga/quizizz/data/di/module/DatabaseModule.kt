package com.prasetyanurangga.quizizz.data.di.module

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.prasetyanurangga.kamar.util.Constanta
import com.prasetyanurangga.quizizz.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
class DatabaseModule() {

    lateinit var appDatabase: AppDatabase

    @Singleton
    @Provides
    fun appDatabase(application: Application): AppDatabase {
        appDatabase = Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            Constanta.Database.DB_NAME
        )
                .fallbackToDestructiveMigration()
                .createFromAsset("database/quizizz.db")
                .build()
        return appDatabase
    }


    @Singleton
    @Provides
    fun providesCategoryDAO(appDatabase: AppDatabase) = appDatabase.categoryDao()

    @Singleton
    @Provides
    fun providesQuestionDAO(appDatabase: AppDatabase) = appDatabase.questionDao()

}