package com.prasetyanurangga.quizizz.data.di.component

import android.app.Application
import com.prasetyanurangga.quizizz.data.di.module.DatabaseModule
import com.prasetyanurangga.quizizz.data.di.module.QuizizzModule
import com.prasetyanurangga.quizizz.ui.view.CategoryActivity
import com.prasetyanurangga.quizizz.ui.view.QuestionActivity
import com.prasetyanurangga.quizizz.ui.view.ResultActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        QuizizzModule::class
    ]
)
interface AppComponent {
    fun inject(categoryActivity: CategoryActivity)
    fun inject(questionActivity: QuestionActivity)
    fun inject(resultActivity: ResultActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun databaseModule(databaseModule: DatabaseModule): Builder

        fun build(): AppComponent
    }
}