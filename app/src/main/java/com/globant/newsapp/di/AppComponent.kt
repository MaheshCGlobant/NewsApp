package com.globant.newsapp.di

import android.app.Application
import com.globant.newsapp.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])

interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApplication: MyApplication)
}
