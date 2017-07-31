package com.apps.madnotdead.notiapp.data.remote

import com.apps.madnotdead.notiapp.data.remote.response.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by madnotdead on 7/29/17.
 */
interface ArticleApi {

    @GET("/v1/articles")
    fun getArticles(@Query("source") source: String, @Query("sortBy") sortBy: String = "latest" ) : Call<ArticleResponse>
}