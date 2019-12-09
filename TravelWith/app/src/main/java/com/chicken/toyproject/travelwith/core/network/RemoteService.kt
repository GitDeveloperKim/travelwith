package com.chicken.toyproject.travelwith.core.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

// TODO : DeveloperKim make server connector

public interface RemoteService {

    @GET("/api/v1/travels")
    fun listTravels() : Call<JsonObject>
}