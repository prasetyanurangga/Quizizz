package com.prasetyanurangga.quizizz.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.prasetyanurangga.quizizz.ui.fragment.QuestionDetailFragment

class QuestionPagerAdapter(private val context: Context, fm: FragmentManager, private val bunchOfQuestion: List<QuestionModel>, val onCheckChange:(List<String>, Int) -> Unit) :
    FragmentPagerAdapter(fm,  FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    lateinit var fragment: Fragment

    override fun getItem(position: Int): Fragment {
        return QuestionDetailFragment(questionModel = bunchOfQuestion[position],
            onCheckChange = onCheckChange,
            position = position
        )
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.getString(R.string.tab_title_text, position + 1)
    }

    override fun getCount(): Int {
        return bunchOfQuestion.size
    }
}