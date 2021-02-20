package com.prasetyanurangga.quizizz.ui.view

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fondesa.kpermissions.extension.permissionsBuilder
import com.prasetyanurangga.quizizz.QuizizzApplication
import com.prasetyanurangga.quizizz.R
import com.prasetyanurangga.quizizz.data.di.factory.CategoryViewModelFactory
import com.prasetyanurangga.quizizz.ui.adapter.CategoryViewAdapter
import com.prasetyanurangga.quizizz.ui.viewmodel.CategoryViewModel
import javax.inject.Inject

class CategoryActivity : AppCompatActivity() {
    lateinit var categoryRecycleView: RecyclerView
    private lateinit var categoryViewModel: CategoryViewModel

    @Inject
    lateinit var categoryViewModelFactory: CategoryViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        initComponent()
        methodWithPermissions()
        injectDagger()
        createViewModel()
        setUpCategory()
    }

    fun methodWithPermissions() {
        val request = permissionsBuilder(Manifest.permission.READ_EXTERNAL_STORAGE).build()
        request.send()
    }

    private fun initComponent() {
        categoryRecycleView = findViewById(R.id.recyclerview_category)
    }

    private fun createViewModel() {
        categoryViewModel = ViewModelProvider(this, categoryViewModelFactory).get(CategoryViewModel::class.java)
    }

    private fun injectDagger() {
        QuizizzApplication.instance.appComponent.inject(this)
    }

    private fun setUpCategory() {
        categoryViewModel.getCategories.observe(this, Observer {
            val adapters = CategoryViewAdapter(this, it)
            categoryRecycleView.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = adapters
            }
        })
    }

    override fun onBackPressed() {
        // Nothing Todo
    }
}