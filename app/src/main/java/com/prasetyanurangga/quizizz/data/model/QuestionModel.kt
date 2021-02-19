package com.prasetyanurangga.quizizz.data.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuestionModel(
    val ID: Int,
    val questionText: String,
    val questionImage: String? = "ffff",
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val correctAnswer: String,
    val isImageQuery: Boolean,
    val categoryId: Int,
    var isAnswerRight: Boolean? = false
): Parcelable