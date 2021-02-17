package com.prasetyanurangga.quizizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prasetyanurangga.quizizz.data.model.CategoryModel
import com.prasetyanurangga.quizizz.data.model.QuestionModel
import com.prasetyanurangga.quizizz.ui.adapter.CategoryViewAdapter

class MainActivity : AppCompatActivity() {
    lateinit var categoryRecycleView: RecyclerView
    val bunchOfQuestion: List<CategoryModel> = listOf(
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
        CategoryModel(ID = 1, name = "IPS", image = "dddd"),
        CategoryModel(ID = 1, name = "IPS", image = "dddd")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        val adapters = CategoryViewAdapter(this, bunchOfQuestion)
        categoryRecycleView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = adapters
        }
    }

    private fun initComponent() {
        categoryRecycleView = findViewById(R.id.category_recyleview)
    }
}