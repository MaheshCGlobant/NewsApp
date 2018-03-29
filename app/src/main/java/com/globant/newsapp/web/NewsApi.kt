package com.globant.newsapp

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * Created by mahesh.chakkarwar on 26/03/18.
 */

interface NewsApi {

    @GET("/v2/top-headlines")
    fun getNews(@Query("country") country: String, @Query("category") category: String, @Query("apiKey") apiKey: String): Single<ArticlesResponse>
}
