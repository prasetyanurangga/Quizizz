package com.prasetyanurangga.quizizz.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.prasetyanurangga.quizizz.ui.adapter.ResultViewAdapter

class ResultActivity : AppCompatActivity() {
    lateinit var resultQuiz: HashMap<Int, List<String>>
    val bunchOfQuestion: List<QuestionModel> = listOf(
        QuestionModel(ID = 1, questionText = "Hello2", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello3", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello4", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello5", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello6", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1)
    )

    lateinit var countQuestion: TextView
    lateinit var countScore: TextView
    lateinit var countRightAnswer: TextView
    lateinit var countWrongAnswer: TextView

    lateinit var categoryRecycleView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initComponent()

        val intent= getIntent()

        resultQuiz = intent.getSerializableExtra("result_quiz") as HashMap<Int, List<String>>

        Log.e("setelah di check", resultQuiz.toString())
        bunchOfQuestion.mapIndexed { index, questionModel ->
            val resultItem = resultQuiz[index] ?: listOf()
            val f = isEqual(resultItem, questionModel.correctAnswer.split(","))
            Log.e("inibung $index", f.toString())
            questionModel.isAnswerRight = isEqual(resultItem, questionModel.correctAnswer.split(","))
        }

        val countRightQuestion = bunchOfQuestion.count {
            it.isAnswerRight == true
        }

        val countWrongQuestion = bunchOfQuestion.count {
            it.isAnswerRight == false
        }

        countRightAnswer.text = countRightQuestion.toString()
        countWrongAnswer.text = countWrongQuestion.toString()
        countScore.text = (countRightQuestion*10).toString()

        Log.e("setelah di check", bunchOfQuestion.toString())

        val adapters = ResultViewAdapter(this, bunchOfQuestion, resultQuiz)
        categoryRecycleView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapters
        }

    }

    fun<T> isEqual(first: List<T>, second: List<T>): Boolean {

        if (first.size != second.size) {
            return false
        }

        return first.zip(second).all { (x, y) -> x == y }
    }

    private fun initComponent() {
        categoryRecycleView = findViewById(R.id.recyclerview_result)
        countScore = findViewById(R.id.textview_result_countscore)
        countRightAnswer = findViewById(R.id.textview_result_rightanswer)
        countWrongAnswer = findViewById(R.id.textview_result_wronganswer)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}