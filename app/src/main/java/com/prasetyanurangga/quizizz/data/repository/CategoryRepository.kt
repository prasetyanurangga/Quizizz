package com.prasetyanurangga.quizizz.data.repository

import androidx.lifecycle.LiveData
import com.prasetyanurangga.quizizz.data.dao.CategoryDao
import com.prasetyanurangga.quizizz.data.database.AppDatabase
import com.prasetyanurangga.quizizz.data.model.CategoryModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryRepository(appDatabase: AppDatabase) {

    private var categoryDao:CategoryDao = appDatabase.categoryDao()

    fun getCategories(): LiveData<List<CategoryModel>>{
        return categoryDao.getAll()
    }

    fun getCategoriesById(id: Int): LiveData<List<CategoryModel>>{
        return categoryDao.getById(id)
    }

    fun addCategory(categoryModel: CategoryModel){
        CoroutineScope(Dispatchers.IO).launch {
            categoryDao.saveCategory(categoryModel)
        }
    }

    fun deleteCategory(categoryModel: CategoryModel){
        CoroutineScope(Dispatchers.IO).launch {
            categoryDao.deleteCategory(categoryModel)
        }
    }

    fun updateCategory(categoryModel: CategoryModel){
        CoroutineScope(Dispatchers.IO).launch {
            categoryDao.updateCategory(categoryModel)
        }
    }

}