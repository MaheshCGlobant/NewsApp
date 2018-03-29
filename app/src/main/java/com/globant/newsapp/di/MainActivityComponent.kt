package com.globant.newsapp.di

import com.globant.newsapp.feature.news.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder:AndroidInjector.Builder<MainActivity>()
}