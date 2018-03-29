package com.globant.newsapp


/**
 * Created by mahesh.chakkarwar on 23/03/18.
 */

data class Article(
        val author: String,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String
)
