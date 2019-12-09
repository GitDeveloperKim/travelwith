package com.chicken.toyproject.travelwith.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.chicken.toyproject.travelwith.R
import com.chicken.toyproject.travelwith.core.network.RemoteGenerator
import com.chicken.toyproject.travelwith.ui.fragment.*
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG: String = "MainActivity"
        const val FRAGMENT_HOME: Int = 0
        const val FRAGMENT_MY_SCHEDULE: Int = 1
        const val FRAGMENT_COMPANION: Int = 2
        const val FRAGMENT_CHAT: Int = 3
        const val FRAGMENT_AD: Int = 4
    }

    private lateinit var fragManager: FragmentManager
    private lateinit var fragTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // developerkim : kotlin android extension
        btn_home.setOnClickListener {
            toast("setFrag Home")
            setFrag(FRAGMENT_HOME)
        }
        btn_my_schedule.setOnClickListener {
            toast("setFrag My schedule")
            setFrag(FRAGMENT_MY_SCHEDULE)
        }
        btn_companion.setOnClickListener {
            toast("setFrag Companion")
            setFrag(FRAGMENT_COMPANION)
        }
        btn_chat.setOnClickListener {
            toast("setFrag Chat")
            setFrag(FRAGMENT_CHAT)
        }
        btn_ad.setOnClickListener {
            toast("setFrag AD")
            setFrag(FRAGMENT_AD)
        }

        // developerkim : just test http request! to be deleted
        RemoteGenerator?.getService()?.listTravels()?.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message , Toast.LENGTH_LONG ).show()  // this@MainActivity 명시해주어야한
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                Toast.makeText(this@MainActivity,response.body().toString(), Toast.LENGTH_SHORT ).show()  // this@MainActivity 명시해주어야한
            }
        })
    }


    private fun setFrag(fragType: Int) {
        fragManager = supportFragmentManager
        fragTransaction = fragManager.beginTransaction()

        when (fragType) {
            // TODO : 시작 화면 home fragment 로 ...
            FRAGMENT_HOME -> fragTransaction.replace(
                R.id.main_fragment,
                HomeFragment()
            ).addToBackStack(null).commit()
            FRAGMENT_MY_SCHEDULE -> fragTransaction.replace(
                R.id.main_fragment,
                MyScheduleFragment()
            ).addToBackStack(null).commit()
            FRAGMENT_COMPANION -> fragTransaction.replace(
                R.id.main_fragment,
                TravelFragment()
            ).addToBackStack(null).commit()
            FRAGMENT_CHAT -> fragTransaction.replace(
                R.id.main_fragment,
                ChatFragment()
            ).addToBackStack(null).commit()
            FRAGMENT_AD -> fragTransaction.replace(
                R.id.main_fragment,
                AdvFragment()
            ).addToBackStack(null).commit()
        }
    }
}
