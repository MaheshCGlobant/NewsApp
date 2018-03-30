package com.globant.newsapp.di

import android.app.Application
import android.content.Context
import com.globant.newsapp.feature.NewsRepo
import com.squareup.picasso.OkHttpDownloader
import com.squareup.picasso.Picasso
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */
@Module(subcomponents = [MainActivityComponent::class])
class AppModule {

    companion object {
        val BASE_URL: String = "https://newsapi.org/"
//        val API_KEY: String = "79b785d859ef44d895de8c7228e92622"
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    internal fun providePicasso(context: Context): Picasso {
        return Picasso.Builder(context)
                .build()
    }

    @Provides
    @Singleton
    fun providesNewsRepo(retrofit: Retrofit): NewsRepo = NewsRepo(retrofit)
}

