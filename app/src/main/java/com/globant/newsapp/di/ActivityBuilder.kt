package com.globant.newsapp.di

import android.app.Activity
import com.globant.newsapp.feature.news.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivity(builder: MainActivityComponent.Builder):AndroidInjector.Factory<out Activity>
}
