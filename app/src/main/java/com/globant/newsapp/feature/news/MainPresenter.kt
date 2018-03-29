package com.globant.newsapp.feature.news

import android.util.Log
import com.globant.newsapp.ArticlesResponse
import com.globant.newsapp.feature.NewsRepo
import com.globant.newsapp.feature.news.MainContract
import io.reactivex.functions.Consumer
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */

class MainPresenter @Inject constructor(): MainContract.MainPresenter {

    @Inject
   lateinit var mainView:MainContract.MainView

    @Inject
    lateinit var newsRepo: NewsRepo


    override fun getNewsList(country: String, category: String) {
            newsRepo.getNews(country, category).subscribe(Consumer {
                if(it.status.equals("ok")){
                    mainView.updateNews(it.articles, it.totalResults)
                }
            }, Consumer {
                it.stackTrace
            })

    }

    override fun getString() {
        mainView.setName("Mahesh")
    }

}
