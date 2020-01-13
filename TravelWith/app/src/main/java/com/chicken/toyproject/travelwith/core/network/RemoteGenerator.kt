package com.chicken.toyproject.travelwith.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//singleton
object RemoteGenerator {

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://localhost:8080")  // developerKim: swagger 에 적힌  baseurl 바꿔야 동작, 끝에 / 없음
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun getService () : RemoteService = retrofit.create(RemoteService::class.java)
}