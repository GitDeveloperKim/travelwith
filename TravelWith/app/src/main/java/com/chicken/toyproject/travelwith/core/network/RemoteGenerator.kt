package com.chicken.toyproject.travelwith.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//singleton
object RemoteGenerator {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://localhost:8080")  // developerKim: swagger 에 적힌  baseurl 바꿔야 동작, 끝에 / 없음
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun getService () : RemoteService = retrofit.create(RemoteService::class.java)
}