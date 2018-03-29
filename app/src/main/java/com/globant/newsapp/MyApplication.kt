package com.globant.newsapp

import android.app.Activity
import android.app.Application

import com.globant.newsapp.di.DaggerAppComponent

import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import retrofit2.Retrofit
import javax.inject.Inject



/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */

class MyApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var  activityDispatchingAndroidInjector:DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> ?{
        return activityDispatchingAndroidInjector
    }
}
