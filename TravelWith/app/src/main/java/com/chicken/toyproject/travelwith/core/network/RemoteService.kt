package com.chicken.toyproject.travelwith.core.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

// TODO : DeveloperKim make server connector

interface RemoteService {

    @GET("/api/v1/travels")
    fun listTravels() : Call<JsonObject>    // Call<ApiResponse<Travel>>

    @GET("/api/v1/schedules")
    fun listSchedules() : Call<JsonObject>  // Call<ApiResponse<Schedule>>

    @GET("/api/v1/schedules/{id}")
    fun listSchedules(@Path("id") id: Int) : Call<JsonObject>   // Call<ApiResponse<ScheduleDTO>>, mismatch data

    @POST("/api/v1/user/signin")
    @FormUrlEncoded
    fun logIn(@Field("id") id : String, @Field("token") token : String, @Field("type") type : String) :  Call<Void>
}