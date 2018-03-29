package com.globant.newsapp.feature.news

import com.globant.newsapp.Article

/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */

interface MainContract {

    interface MainView {
       fun setName(name:String)
       fun updateNews(list: List<Article>?, totalCount:Int)
       fun error(msg:String)
    }

    interface MainPresenter {
        fun getString()

        fun getNewsList(country:String, category: String)
    }
}
