package com.prasetyanurangga.quizizz.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prasetyanurangga.quizizz.data.dao.CategoryDao
import com.prasetyanurangga.quizizz.data.dao.QuestionDao
import com.prasetyanurangga.quizizz.data.model.CategoryModel
import com.prasetyanurangga.quizizz.data.model.QuestionModel

@Database(
    entities = [
        CategoryModel::class,
        QuestionModel::class
    ],
    version = 1,
    exportSchema = false
)


abstract class AppDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun questionDao(): QuestionDao

}