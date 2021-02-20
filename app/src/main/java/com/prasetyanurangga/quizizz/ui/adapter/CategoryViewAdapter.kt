package com.prasetyanurangga.quizizz.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.quizizz.ui.view.QuestionActivity
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.CategoryModel
import com.squareup.picasso.Picasso

class CategoryViewAdapter(
    val context: Context,
    private var bunchOfCategory: List<CategoryModel>
): RecyclerView.Adapter<CategoryViewAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_category, parent, false))
    }

    override fun getItemCount(): Int {
        return bunchOfCategory.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindItem(bunchOfCategory[position]);

        holder.itemView.setOnClickListener {
            val intent = Intent(context, QuestionActivity::class.java).apply {
                putExtra("category_id", bunchOfCategory[position].ID)
                putExtra("category_name", bunchOfCategory[position].name)
            }
            context.startActivity(intent)
        }
    }

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private  val listItemCategoryName: TextView = view.findViewById(R.id.textview_listitemcategory)
        private  val listItemCategoryImage: ImageView = view.findViewById(R.id.imageview_listitemcategory)

        fun bindItem(items: CategoryModel){
            listItemCategoryName.text = items.name
            if (items.image.isNullOrEmpty()) {
                listItemCategoryImage.setImageResource(R.drawable.ic_launcher_background);
            } else{
                Picasso.get()
                    .load(items.image)
                    .error(R.drawable.ic_launcher_background)
                    .into(listItemCategoryImage);
            }

        }
    }

}




