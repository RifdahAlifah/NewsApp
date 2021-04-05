package com.rifdahalf.newsapp.network

import com.google.gson.GsonBuilder
import com.rifdahalf.newsapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitConfig {
    //buat akses portnya
    val interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    //memnyampaikan ke client
    val client = OkHttpClient.Builder().addInterceptor(interceptor)
        .retryOnConnectionFailure(true)
         //ketika prosesnya lebih dari 30 detik, berarti datanya gagal, bisa karena gada koneksi internet
        .connectTimeout(30, TimeUnit.SECONDS).build()

    //untuk convert menjadi gson
    val gson = GsonBuilder().setLenient().create()

    //entry data
    //untuk ngatur URL mana yang mau di eksekusi
    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
         //buat nge convert kedalam gson
        .addConverterFactory(GsonConverterFactory.create(gson)).build()

    //function untuk menyambung endpoint dari class Api Service
    fun getInstance() : ApiService = retrofit.create(ApiService::class.java)

}