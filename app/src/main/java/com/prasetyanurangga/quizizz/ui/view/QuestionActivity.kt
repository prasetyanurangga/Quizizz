package com.prasetyanurangga.quizizz.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.prasetyanurangga.kamar.util.Constanta
import com.prasetyanurangga.quizizz.QuizizzApplication
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.di.factory.QuestionViewModelFactory
import com.prasetyanurangga.quizizz.ui.adapter.QuestionPagerAdapter
import com.prasetyanurangga.quizizz.ui.viewmodel.QuestionViewModel
import javax.inject.Inject

class QuestionActivity : AppCompatActivity() {
    @Inject
    lateinit var questionViewModelFactory: QuestionViewModelFactory
    private lateinit var questionViewModel: QuestionViewModel

    private var bunchOfCheck: HashMap<Int,List<String>> = hashMapOf()

    private lateinit var countQuestion: TextView
    private lateinit var timeLeft: TextView
    private lateinit var categoryName: TextView
    private lateinit var tabs: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var finishButton: FloatingActionButton
    var numQuestion:Int = 0
    private var categoryId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        categoryId = intent.getIntExtra("category_id", 0)

        injectDagger()
        createViewModel()
        initComponent()
        setUpQuestion(categoryId)

        categoryName.text = intent.getStringExtra("category_name")
        countQuestion.text = getString(R.string.count_question_text, numQuestion)

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                countQuestion.text = getString(R.string.count_question_text, numQuestion)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        finishButton.setOnClickListener {
            finishQuiz()
        }
    }

    private fun injectDagger() {
        QuizizzApplication.instance.appComponent.inject(this)
    }

    private fun createViewModel() {
        questionViewModel = ViewModelProvider(this, questionViewModelFactory).get(QuestionViewModel::class.java)
    }

    private fun setUpQuestion(category_id: Int) {
        questionViewModel.getQuestionsByCategoryId(category_id).observe(this, Observer {
            numQuestion = it.size
            if(numQuestion > 0){
                setUpTimer(numQuestion.toLong() * Constanta.Question.TIME_PER_QUESTION)
                val sectionsPagerAdapter = QuestionPagerAdapter(this, supportFragmentManager, it, onCheckChange = ::onCheck)
                viewPager.adapter = sectionsPagerAdapter
                tabs.setupWithViewPager(viewPager)
            }
            else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.warning_text))
                builder.setMessage(getString(R.string.question_not_found_text))
                builder.setPositiveButton(getString(R.string.ok_text)) { _, _ ->
                    super.onBackPressed()
                }
                builder.setCancelable(false)
                builder.show()
            }
        })
    }

    private fun getCorrectQuestion(): Int{
        return bunchOfCheck.count {
            it.value.isNotEmpty()
        }
    }

    private fun onCheck( item :List<String>, position: Int) {
        bunchOfCheck[position] = item
    }

    private fun finishQuiz() {
        if(getCorrectQuestion() == numQuestion){
            val intent = Intent(this@QuestionActivity, ResultActivity::class.java).apply {
                putExtra("result_quiz", bunchOfCheck)
                putExtra("category_id", categoryId)
            }
            startActivity(intent)
        }
        else{
            showAlertEndQuiz(false)
        }
    }

    private fun showAlertEndQuiz(isToHome: Boolean) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.warning_text))
        builder.setMessage(getString(R.string.warning_ends_quiz_text))
        builder.setPositiveButton(getString(R.string.yes_text)) { _, _ ->
            if (!isToHome) goToResultActivity() else super.onBackPressed()
        }
        builder.setNegativeButton(getString(R.string.no_text)) { dialog, _ ->
            dialog.dismiss()
        }
        builder.setCancelable(false)
        builder.show()
    }

    private fun initComponent() {
        countQuestion = findViewById(R.id.textview_question_countquestion)
        timeLeft = findViewById(R.id.textview_question_timeleft)
        categoryName = findViewById(R.id.textview_question_category)
        tabs = findViewById(R.id.tablayout_question)
        viewPager = findViewById(R.id.viewpager_question)
        finishButton = findViewById(R.id.fab_question_finish)
    }

    private fun setUpTimer(timeInMilis: Long) {
        val timer = object: CountDownTimer(timeInMilis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondUntilFinished = millisUntilFinished/1000
                timeLeft.text = secondUntilFinished.toString()
            }

            override fun onFinish() {
                showAlertTimeIsOut()
            }
        }
        timer.start()
    }

    fun showAlertTimeIsOut() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.warning_text))
        builder.setMessage(getString(R.string.time_out_text))
        builder.setPositiveButton(getString(R.string.ok_text)) { _, _ ->
            goToResultActivity()
        }
        builder.setCancelable(false)
        builder.show()

    }

    private fun goToResultActivity() {
        val intent = Intent(this@QuestionActivity, ResultActivity::class.java).apply {
            putExtra("result_quiz", bunchOfCheck)
            putExtra("category_id", categoryId)
        }
        startActivity(intent)
    }

    override fun onBackPressed() {
        showAlertEndQuiz(true)
    }
}