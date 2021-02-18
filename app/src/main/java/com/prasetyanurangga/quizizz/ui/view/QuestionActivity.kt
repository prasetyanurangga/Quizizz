package com.prasetyanurangga.quizizz.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.prasetyanurangga.quizizz.ui.adapter.QuestionPagerAdapter

class QuestionActivity : AppCompatActivity() {
    val bunchOfQuestion: List<QuestionModel> = listOf(
        QuestionModel(ID = 1, questionText = "Hello2", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello3", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello4", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello5", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1),
        QuestionModel(ID = 1, questionText = "Hello6", answerA = "pertama", answerB = "kedua", answerC = "ketiga", answerD = "keempat",isImageQuery = false, correctAnswer = "A", categoryId = 1)
    )

    var bunchOfCheck: HashMap<Int,List<String>> = hashMapOf()

    lateinit var countQuestion: TextView
    lateinit var timeLeft: TextView
    lateinit var tabs: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var finishButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        initComponent()
        setUpTabLayout()

        countQuestion.setText("1/${bunchOfQuestion.size}")

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                countQuestion.setText("${tab.position + 1}/${bunchOfQuestion.size}")
                Log.e("sekaranggggggfff", tab.position.toString())
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        setUpTimer()


        finishButton.setOnClickListener { view ->
            val correctCount = bunchOfCheck.count {
                it.value.isNotEmpty()
            }
            Log.e("julah", "$correctCount")

            if(correctCount == bunchOfCheck.size){
                val intent = Intent(this@QuestionActivity, ResultActivity::class.java).apply {
                    putExtra("result_quiz", bunchOfCheck)
                }
                startActivity(intent)
            }

        }
    }

    private fun onCheck( item :List<String>, position: Int) {
        bunchOfCheck[position] = item
        Log.e("check", bunchOfCheck.toString())
    }

    private fun finishQuiz() {

    }

    private fun initComponent() {
        countQuestion = findViewById(R.id.textview_question_countquestion)
        timeLeft = findViewById(R.id.textview_question_timeleft)
        tabs = findViewById(R.id.tablayout_question)
        viewPager = findViewById(R.id.viewpager_question)
        finishButton = findViewById(R.id.fab_question_finish)
    }

    private fun setUpTabLayout() {
        val sectionsPagerAdapter = QuestionPagerAdapter(this, supportFragmentManager, bunchOfQuestion, onCheckChange = ::onCheck)
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