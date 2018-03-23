package com.globant.newsapp.di.module

import dagger.Module
import dagger.Provides
import com.globant.newsapp.MainContract.MainView
import com.globant.newsapp.MainActivity
import com.globant.newsapp.MainPresenter


/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */
@Module
class MainActivityModule {

    @Provides
    fun provideMainView(mainActivity: MainActivity): MainView {
        return mainActivity
    }

    @Provides
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }
}
