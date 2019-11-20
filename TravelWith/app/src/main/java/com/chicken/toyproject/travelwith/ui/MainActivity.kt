package com.chicken.toyproject.travelwith.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.chicken.toyproject.travelwith.R
import com.chicken.toyproject.travelwith.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    //TODO : need to use enum?
    private val FRAGMENT_HOME = 0
    private val FRAGMENT_MY_SCHEDULE = 1
    private val FRAGMENT_COMPANION = 2
    private val FRAGMENT_CHAT = 3
    private val FRAGMENT_AD = 4

    //TODO : need to rename
    private lateinit var fm: FragmentManager
    private lateinit var tran: FragmentTransaction

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
        fm = supportFragmentManager
        tran = fm.beginTransaction()

        when (fragType) {
            // TODO : 시작 화면 home fragment 로 ...
            FRAGMENT_HOME -> tran.replace(
                R.id.main_fragment,
                HomeFragment()
            ).addToBackStack(null).commit()
            FRAGMENT_MY_SCHEDULE -> tran.replace(
                R.id.main_fragment,
                MyScheduleFragment()
            ).addToBackStack(null).commit()
            FRAGMENT_COMPANION -> tran.replace(
                R.id.main_fragment,
                TravelFragment()
            ).addToBackStack(null).commit()
            FRAGMENT_CHAT -> tran.replace(
                R.id.main_fragment,
                ChatFragment()
            ).addToBackStack(null).commit()
            FRAGMENT_AD -> tran.replace(
                R.id.main_fragment,
                AdvFragment()
            ).addToBackStack(null).commit()
        }

    }
}
