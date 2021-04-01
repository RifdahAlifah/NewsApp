package com.rifdahalf.newsapp.network

import com.google.gson.GsonBuilder
import com.rifdahalf.newsapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetfrofitConfig {
    val interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    //memnyampaikan ke client
    val client = OkHttpClient.Builder().addInterceptor(interceptor)
        .retryOnConnectionFailure(true)
        .connectTimeout(30, TimeUnit.SECONDS).build()
    val gson = GsonBuilder().setLenient().create()
    val retrofit =  Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .client(client).addConverterFactory(GsonConverterFactory.create(gson))

}