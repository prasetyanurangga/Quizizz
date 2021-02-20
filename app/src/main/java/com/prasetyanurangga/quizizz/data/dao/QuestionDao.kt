package com.prasetyanurangga.quizizz.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prasetyanurangga.quizizz.data.model.QuestionModel

@Dao
interface QuestionDao {

    @Query( "SELECT * FROM question" )
    fun getAll(): LiveData<List<QuestionModel>>

    @Query( "SELECT * FROM question WHERE id = :id" )
    fun getById(id: Int): LiveData<List<QuestionModel>>

    @Query( "SELECT * FROM question WHERE category_id = :id" )
    fun getByCategoryId(id: Int): LiveData<List<QuestionModel>>

    @Insert
    fun saveQuestion(vararg questionModel: QuestionModel)

    @Update
    fun updateQuestion(vararg questionModel: QuestionModel)

    @Delete
    fun deleteQuestion(vararg questionModel: QuestionModel)



}