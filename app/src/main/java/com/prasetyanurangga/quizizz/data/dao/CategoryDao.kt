package com.prasetyanurangga.quizizz.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prasetyanurangga.quizizz.data.model.CategoryModel

@Dao
interface CategoryDao {

    @Query( "SELECT * FROM category" )
    fun getAll(): LiveData<List<CategoryModel>>

    @Query( "SELECT * FROM category WHERE ID = :id" )
    fun getById(id: Int): LiveData<List<CategoryModel>>

    @Insert
    fun saveCategory(vararg categoryModel: CategoryModel)

    @Update
    fun updateCategory(vararg categoryModel: CategoryModel)

    @Delete
    fun deleteCategory(vararg categoryModel: CategoryModel)



}