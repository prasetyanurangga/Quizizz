package com.prasetyanurangga.quizizz.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.quizizz.QuestionDetailActivity
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.CategoryModel

class CategoryViewAdapter(
    val context: Context,
    private var bunchOfCategory: List<CategoryModel>
): RecyclerView.Adapter<CategoryViewAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
    }

    override fun getItemCount(): Int {
        return bunchOfCategory.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindItem(bunchOfCategory[position], context);

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, QuestionDetailActivity::class.java))
        }
    }

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private  val contentCategory: TextView = view.findViewById(R.id.content_category)

        fun bindItem(items: CategoryModel, context: Context){
            contentCategory.text = items.name
        }
    }

}




