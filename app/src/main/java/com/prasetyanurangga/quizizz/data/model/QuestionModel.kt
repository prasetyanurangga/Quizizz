package com.prasetyanurangga.quizizz.data.model

data class QuestionModel(
    val ID: Int,
    val questionText: String,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val correctAnswer: String,
    val isImageQuery: Boolean,
    val categoryId: Int
)