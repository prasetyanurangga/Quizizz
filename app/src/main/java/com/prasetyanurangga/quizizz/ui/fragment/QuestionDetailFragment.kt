package com.prasetyanurangga.quizizz.ui.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.squareup.picasso.Picasso

class QuestionDetailFragment(
        private val questionModel : QuestionModel,
        val onCheckChange:(List<String>, Int) -> Unit,
        val position: Int
    ) : Fragment() {

    lateinit var answerAQuestion: Chip
    lateinit var  answerBQuestion: Chip
    lateinit var  answerCQuestion: Chip
    lateinit var  answerDQuestion: Chip
    lateinit var imageQuestion: ImageView
    lateinit var contentQUestion: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_question, container, false)
        imageQuestion = root.findViewById(R.id.imagevie_question_questionimage)
        contentQUestion= root.findViewById(R.id.textview_question_questiontext)
        answerAQuestion= root.findViewById(R.id.chip_question_answera)
        answerBQuestion= root.findViewById(R.id.chip_question_answerb)
        answerCQuestion= root.findViewById(R.id.chip_question_answerc)
        answerDQuestion= root.findViewById(R.id.chip_question_answerd)
        contentQUestion.text = questionModel.questionText
        answerAQuestion.text = questionModel.answerA
        answerBQuestion.text = questionModel.answerB
        answerCQuestion.text = questionModel.answerC
        answerDQuestion.text = questionModel.answerD

        if(!questionModel.isImageQuestion!!){
            imageQuestion.visibility = View.GONE
        }
        else{
            if (questionModel.questionImage.isNullOrEmpty()) {
                imageQuestion.setImageResource(R.drawable.ic_launcher_background);
            } else{
                Picasso.get()
                        .load(questionModel.questionImage)
                        .error(R.drawable.ic_launcher_background)
                        .into(imageQuestion)
            }
        }

        contentQUestion.text = questionModel.questionText

        answerAQuestion.setOnCheckedChangeListener { _, _ ->
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