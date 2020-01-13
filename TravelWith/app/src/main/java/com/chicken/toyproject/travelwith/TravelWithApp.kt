package com.chicken.toyproject.travelwith

import android.app.Application
import android.content.Context
import android.util.Log
import com.chicken.toyproject.travelwith.core.network.RemoteService
import com.chicken.toyproject.travelwith.core.network.newRetrofit

class TravelWithApp : Application() {

    init {
        instance = this
    }

    val apiClient by lazy {
        newRetrofit(this, "http://localhost:8080", RemoteService::class.java)
    }

    companion object {
        private var instance: TravelWithApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        fun apiClient(): RemoteService {
            return instance!!.apiClient
        }

    }

    override fun onCreate() {
        super.onCreate()

        Log.i("App start", "App initialization")
        // Do some other initializations
        val context: Context = TravelWithApp.applicationContext()
    }
}