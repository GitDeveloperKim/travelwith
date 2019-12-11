package com.chicken.toyproject.travelwith.core.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// TODO : DeveloperKim make server connector

public interface RemoteService {

    @GET("/api/v1/travels")
    fun listTravels() : Call<JsonObject>    // Call<ApiResponse<Travel>>

    @GET("/api/v1/schedules")
    fun listSchedules() : Call<JsonObject>  // Call<ApiResponse<Schedule>>

    @GET("/api/v1/schedules/{id}")
    fun listSchedules(@Path("id") id: Int) : Call<JsonObject>   // Call<ApiResponse<ScheduleDTO>>, mismatch data
}