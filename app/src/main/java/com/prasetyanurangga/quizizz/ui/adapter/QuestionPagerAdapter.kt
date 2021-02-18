package com.prasetyanurangga.quizizz.ui.adapter

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.prasetyanurangga.quizizz.ui.fragment.QuestionDetailFragment


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class QuestionPagerAdapter(private val context: Context, fm: FragmentManager, private val bunchOfQuestion: List<QuestionModel>, val onCheckChange:(List<String>, Int) -> Unit) :
    FragmentPagerAdapter(fm,  FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    lateinit var fragment: Fragment

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Log.e("dta", bunchOfQuestion[position].toString())
        return QuestionDetailFragment(questionModel = bunchOfQuestion[position],
            onCheckChange = onCheckChange,
            position = position
        )
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Soal ${position + 1}"
    }


    override fun getCount(): Int {
        // Show 2 total pages.
        return bunchOfQuestion.size
    }
}