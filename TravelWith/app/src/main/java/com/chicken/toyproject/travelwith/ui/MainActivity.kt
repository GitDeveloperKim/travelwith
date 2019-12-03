package com.chicken.toyproject.travelwith.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.chicken.toyproject.travelwith.R
import com.chicken.toyproject.travelwith.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

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
