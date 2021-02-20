package com.prasetyanurangga.quizizz.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "question"
)
data class QuestionModel(
    @PrimaryKey(
        autoGenerate = true
    )
    @ColumnInfo( name = "id" )
    val ID: Int,

    @ColumnInfo( name = "question_text" )
    val questionText: String,

    @ColumnInfo( name = "question_image" )
    val questionImage: String? = null,

    @ColumnInfo( name = "answer_a" )
    val answerA: String,

    @ColumnInfo( name = "answer_b" )
    val answerB: String,

    @ColumnInfo( name = "answer_c" )
    val answerC: String,

    @ColumnInfo( name = "answer_d" )
    val answerD: String,

    @ColumnInfo( name = "correct_answer" )
    val correctAnswer: String,

    @ColumnInfo( name = "is_image_question" )
    val isImageQuestion: Boolean? = false,

    @ColumnInfo( name = "category_id" )
    val categoryId: Int,

    @ColumnInfo( name = "is_answer_right" )
    var isAnswerRight: Boolean? = false
)