package com.globant.newsapp.di

import dagger.Module
import dagger.Provides
import com.globant.newsapp.feature.news.MainActivity
import com.globant.newsapp.feature.news.MainContract
import com.globant.newsapp.feature.news.MainPresenter


/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */
@Module
class MainActivityModule {

    @Provides
    fun provideMainView(mainActivity: MainActivity): MainContract.MainView {
        return mainActivity
    }

}
