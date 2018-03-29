package com.globant.newsapp.feature

import com.globant.newsapp.ArticlesResponse
import com.globant.newsapp.NewsApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */
class NewsRepo @Inject constructor(retrofit: Retrofit) {

    val newsApi: NewsApi by lazy { retrofit.create(NewsApi::class.java) }

    fun getNews(country: String, category: String): Single<ArticlesResponse> {
        return newsApi.getNews(country, category, "79b785d859ef44d895de8c7228e92622")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}