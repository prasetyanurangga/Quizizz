package com.prasetyanurangga.quizizz.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.quizizz.ui.view.QuestionActivity
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.CategoryModel
import com.prasetyanurangga.quizizz.data.model.QuestionModel

class ResultViewAdapter(
    val context: Context,
    private var bunchOfResult: List<QuestionModel>,
    private var bunchOfAnswer: HashMap<Int, List<String>>
): RecyclerView.Adapter<ResultViewAdapter.QuestionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_result, parent, false))
    }

    override fun getItemCount(): Int {
        return bunchOfResult.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bindItem(bunchOfResult[position], bunchOfAnswer[position] ?: listOf(), context, position);

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, QuestionActivity::class.java))
        }
    }

    class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val listItemQuestion: TextView = view.findViewById(R.id.list_item_question)
        private val listItemIcon: ImageView = view.findViewById(R.id.list_item_icon)
        private val listItemRightAnswer: TextView = view.findViewById(R.id.list_item_right_answer)
        private val listItemYourAnswer: TextView = view.findViewById(R.id.list_item_your_answer)

        fun bindItem(items: QuestionModel,answers: List<String>, context: Context, position: Int){
            listItemQuestion.text = "Soal Nomor ${position + 1}"
            val answer = if(answers.isNotEmpty()) answers.joinToString(",") else "-"
            val isAnswerRight = items.isAnswerRight ?: false
            val iconColorQuestion = if(isAnswerRight) R.color.green_400 else R.color.red_400
            listItemIcon.setImageResource(if(isAnswerRight) R.drawable.ic_check else R.drawable.ic_baseline)
            listItemIcon.setColorFilter(ContextCompat.getColor(context, iconColorQuestion), android.graphics.PorterDuff.Mode.SRC_IN);
            listItemYourAnswer.text = "Jawaban Anda adalah $answer"
            listItemRightAnswer.text = "Jawaban yang Benar adalah ${items.correctAnswer}"
        }
    }

}




