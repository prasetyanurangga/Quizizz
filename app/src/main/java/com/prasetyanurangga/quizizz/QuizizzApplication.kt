package com.prasetyanurangga.quizizz

import android.app.Application
import com.prasetyanurangga.quizizz.data.di.component.AppComponent
import com.prasetyanurangga.quizizz.data.di.component.DaggerAppComponent
import com.prasetyanurangga.quizizz.data.di.module.DatabaseModule

class QuizizzApplication: Application() {

    companion object {
        lateinit var instance: QuizizzApplication
    }

    lateinit var appComponent: AppComponent

    override fun onCreate(){
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .databaseModule(DatabaseModule())
                .build()

    }

}