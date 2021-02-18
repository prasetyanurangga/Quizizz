package com.prasetyanurangga.quizizz.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.model.CategoryModel
import com.prasetyanurangga.quizizz.ui.adapter.CategoryViewAdapter

class CategoryActivity : AppCompatActivity() {
    lateinit var categoryRecycleView: RecyclerView
    val bunchOfQuestion: List<CategoryModel> = listOf(
        CategoryModel(ID = 1, name = "Food and drink", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        initComponent()
        val adapters = CategoryViewAdapter(this, bunchOfQuestion)
        categoryRecycleView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = adapters
        }
    }

    private fun initComponent() {
        categoryRecycleView = findViewById(R.id.recyclerview_question)
    }
}