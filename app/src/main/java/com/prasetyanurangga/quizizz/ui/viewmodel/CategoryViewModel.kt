package com.prasetyanurangga.quizizz.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.prasetyanurangga.quizizz.data.model.CategoryModel
import com.prasetyanurangga.quizizz.data.repository.CategoryRepository

class CategoryViewModel (private var categoryRepository: CategoryRepository): ViewModel(){
    var getCategories: LiveData<List<CategoryModel>> = categoryRepository.getCategories()

    fun getCategoriesById(id: Int): LiveData<List<CategoryModel>>{
        return categoryRepository.getCategoriesById(id);
    }
    
    fun saveCategory(categoryModel: CategoryModel): LiveData<List<CategoryModel>>{
        categoryRepository.addCategory(categoryModel)
        return categoryRepository.getCategories();
    }

    fun deleteCategory(categoryModel: CategoryModel): LiveData<List<CategoryModel>>{
        categoryRepository.deleteCategory(categoryModel)
        return categoryRepository.getCategories();
    }

    fun updateCategory(categoryModel: CategoryModel): LiveData<List<CategoryModel>>{
        categoryRepository.updateCategory(categoryModel)
        return categoryRepository.getCategories();
    }
}