package com.prasetyanurangga.quizizz

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.prasetyanurangga.quizizz.ui.main.SectionsPagerAdapter

class QuestionDetailActivity : AppCompatActivity() {
    val bunchOfQuestion: List<QuestionModel> = listOf(
        QuestionModel(ID = 1, questionText = "Hello2", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello3", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello4", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello5", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello6", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1)
    )

    lateinit var numOfQuestion: TextView
    lateinit var numOfScore: TextView
    lateinit var numOfRightAnswer: TextView
    lateinit var numOfWrongAnswer: TextView
    lateinit var timeLeft: TextView
    lateinit var tabs: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var completedButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_detail)
        initComponent()
        setUpTabLayout()

        numOfQuestion.setText("1/${bunchOfQuestion.size}")

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                numOfQuestion.setText("${tab.position + 1}/${bunchOfQuestion.size}")
                Log.e("sekaranggggggfff", tab.position.toString())
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        setUpTimer()


        completedButton.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initComponent() {
        numOfQuestion = findViewById(R.id.num_all_question)
        numOfScore = findViewById(R.id.num_score)
        numOfRightAnswer = findViewById(R.id.num_right_anwser)
        numOfWrongAnswer = findViewById(R.id.num_wrong_anwser)
        timeLeft = findViewById(R.id.time_left)
        tabs = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.view_pager)
        completedButton = findViewById(R.id.completed_button)
    }

    private fun setUpTabLayout() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager, bunchOfQuestion)
        viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }

    private fun setUpTimer() {
        val timer = object: CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondUntilFinished = millisUntilFinished/1000
                timeLeft.setText(secondUntilFinished.toString())
            }

            override fun onFinish() {

            }
        }
        timer.start()
    }
}