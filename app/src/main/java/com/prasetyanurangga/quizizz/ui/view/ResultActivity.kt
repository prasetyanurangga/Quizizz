package com.prasetyanurangga.quizizz.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.kamar.util.Constanta
import com.prasetyanurangga.quizizz.QuizizzApplication
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.di.factory.QuestionViewModelFactory
import com.prasetyanurangga.quizizz.ui.adapter.ResultViewAdapter
import com.prasetyanurangga.quizizz.ui.viewmodel.QuestionViewModel
import javax.inject.Inject

class ResultActivity : AppCompatActivity() {
    lateinit var resultQuiz: HashMap<Int, List<String>>

    @Inject
    lateinit var questionViewModelFactory: QuestionViewModelFactory
    private lateinit var questionViewModel: QuestionViewModel

    private lateinit var countQuestion: TextView
    private lateinit var countScore: TextView
    private lateinit var countRightAnswer: TextView
    private lateinit var countWrongAnswer: TextView
    private lateinit var categoryRecycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        injectDagger()
        createViewModel()
        initComponent()
        setUpResult()

        findViewById<Button>(R.id.button_result_tohome).setOnClickListener {
            startActivity(Intent(this@ResultActivity, CategoryActivity::class.java))
        }

    }

    private fun<T> isEqual(first: List<T>, second: List<T>): Boolean {

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

    private fun injectDagger() {
        QuizizzApplication.instance.appComponent.inject(this)
    }

    private fun createViewModel() {
        questionViewModel = ViewModelProvider(this, questionViewModelFactory).get(QuestionViewModel::class.java)
    }

    private fun setUpResult() {
        questionViewModel.getQuestionsByCategoryId(intent.getIntExtra("category_id", 0)).observe(this, Observer { it ->

            resultQuiz = intent.getSerializableExtra("result_quiz") as HashMap<Int, List<String>>

            it.mapIndexed { index, questionModel ->
                val resultItem = resultQuiz[index] ?: listOf()
                questionModel.isAnswerRight = isEqual(resultItem, questionModel.correctAnswer.split(","))
            }

            val countRightQuestion = it.count {
                it.isAnswerRight == true
            }

            val countWrongQuestion = it.count {
                it.isAnswerRight == false
            }

            countRightAnswer.text = countRightQuestion.toString()
            countWrongAnswer.text = countWrongQuestion.toString()
            countScore.text = (countRightQuestion * Constanta.Question.SCORE_PER_QUESTION).toString()


            val adapters = ResultViewAdapter(this, it, resultQuiz)
            categoryRecycleView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = adapters
            }
        })
    }

    override fun onBackPressed() {
        // Nothing Todo
    }
}