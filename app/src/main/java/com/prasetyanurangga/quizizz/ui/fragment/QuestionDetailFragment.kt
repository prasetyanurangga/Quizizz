package com.prasetyanurangga.quizizz.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.QuestionModel

/**
 * A placeholder fragment containing a simple view.
 */
class QuestionDetailFragment(private val questionModel : QuestionModel, val onCheckChange:(List<String>, Int) -> Unit, val position: Int) : Fragment() {
    lateinit var answerAQuestion: CheckBox
    lateinit var  answerBQuestion: CheckBox
    lateinit var  answerCQuestion: CheckBox
    lateinit var  answerDQuestion: CheckBox

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_question, container, false)
        val questionTextQuestion: TextView = root.findViewById(R.id.question_text_question)
        answerAQuestion= root.findViewById(R.id.answer_a_question)
        answerBQuestion= root.findViewById(R.id.answer_b_question)
        answerCQuestion= root.findViewById(R.id.answer_c_question)
        answerDQuestion= root.findViewById(R.id.answer_d_question)
        questionTextQuestion.text = questionModel.questionText
        answerAQuestion.text = questionModel.answerA
        answerBQuestion.text = questionModel.answerB
        answerCQuestion.text = questionModel.answerC
        answerDQuestion.text = questionModel.answerD


        answerAQuestion.setOnClickListener {
            onCheckChange(onCheckedAnswer(), position)
        }

        answerBQuestion.setOnClickListener {
            onCheckChange(onCheckedAnswer(), position)
        }

        answerCQuestion.setOnClickListener {
            onCheckChange(onCheckedAnswer(), position)
        }

        answerDQuestion.setOnClickListener {
            onCheckChange(onCheckedAnswer(), position)
        }

        return root
    }

    private fun onCheckedAnswer(): List<String> {
        val tempAnswer: MutableList<String> = mutableListOf()
        if ( answerAQuestion.isChecked) tempAnswer.add("A")
        if ( answerBQuestion.isChecked) tempAnswer.add("B")
        if ( answerCQuestion.isChecked) tempAnswer.add("C")
        if ( answerDQuestion.isChecked) tempAnswer.add("D")

        return tempAnswer
    }
}