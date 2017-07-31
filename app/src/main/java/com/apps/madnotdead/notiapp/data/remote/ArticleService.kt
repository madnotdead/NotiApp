package com.apps.madnotdead.notiapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by madnotdead on 7/29/17.
 */
object ArticleService {

    val articleApi: ArticleApi

    init {

        val client = OkHttpClient.Builder()


        setupApiKeyInterceptor(client)
        setupLoggingInterceptor(client)



        val retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        articleApi = retrofit.create(ArticleApi::class.java)
    }

    private fun setupApiKeyInterceptor(httpClient: OkHttpClient.Builder) {
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apiKey", "79778526d2c94bbc8010337504d18402")
                    .build()

            val requestBuilder = original.newBuilder()
                    .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    private fun setupLoggingInterceptor(httpClient: OkHttpClient.Builder) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)
    }

}