package com.prasetyanurangga.quizizz.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.QuestionModel

/**
 * A placeholder fragment containing a simple view.
 */
class QuestionDetailFragment(private val questionModel : QuestionModel) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_question_detail, container, false)
        val questionTextQuestion: TextView = root.findViewById(R.id.question_text_question)
        val answerAQuestion: TextView = root.findViewById(R.id.answer_a_question)
        val answerBQuestion: TextView = root.findViewById(R.id.answer_b_question)
        val answerCQuestion: TextView = root.findViewById(R.id.answer_c_question)
        val answerDQuestion: TextView = root.findViewById(R.id.answer_d_question)
        questionTextQuestion.text = questionModel.questionText
        answerAQuestion.text = questionModel.answerA
        answerBQuestion.text = questionModel.answerB
        answerCQuestion.text = questionModel.answerC
        answerDQuestion.text = questionModel.answerD
        return root
    }
}