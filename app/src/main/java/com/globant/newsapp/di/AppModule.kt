package com.globant.newsapp.di

import android.app.Application
import android.content.Context
import com.globant.newsapp.di.component.MainActivityComponent
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */
@Module(subcomponents = [MainActivityComponent::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}