package com.chicken.toyproject.travelwith.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.chicken.toyproject.travelwith.R
import com.chicken.toyproject.travelwith.ui.fragment.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val FRAGMENT_HOME = 0
    private val FRAGMENT_MY_SCHEDULE = 1
    private val FRAGMENT_COMPANION = 2
    private val FRAGMENT_CHAT = 3
    private val FRAGMENT_AD = 4

    private lateinit var homeTabBtn: Button
    private lateinit var myScheduleTabBtn: Button
    private lateinit var companionTabBtn: Button
    private lateinit var chatTabBtn: Button
    private lateinit var adTabBtn: Button
    private lateinit var frag1: Fragment
    private lateinit var frag2: Fragment
    private lateinit var frag3: Fragment

    //TODO : need to rename
    private lateinit var fm: FragmentManager
    private lateinit var tran: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeTabBtn = findViewById(R.id.btn_home)
        myScheduleTabBtn = findViewById(R.id.btn_my_schedule)
        companionTabBtn = findViewById(R.id.btn_companion)
        chatTabBtn = findViewById(R.id.btn_chat)
        adTabBtn = findViewById(R.id.btn_ad)

        //TODO : need to rename
        frag1 = Fragment()
        frag2 = Fragment()
        frag3 = Fragment()

        homeTabBtn.setOnClickListener {
            toast("setFrag Home")
            setFrag(FRAGMENT_HOME)
        }
        myScheduleTabBtn.setOnClickListener {
            toast("setFrag My schedule")
            setFrag(FRAGMENT_MY_SCHEDULE)
        }
        companionTabBtn.setOnClickListener {
            toast("setFrag Companion")
            setFrag(FRAGMENT_COMPANION)
        }
        chatTabBtn.setOnClickListener {
            toast("setFrag Chat")
            setFrag(FRAGMENT_CHAT)
        }
        adTabBtn.setOnClickListener {
            toast("setFrag AD")
            setFrag(FRAGMENT_AD)
        }

    }


    private fun setFrag(fragType: Int) {
        fm = supportFragmentManager
        tran = fm.beginTransaction()

        when (fragType) {
            FRAGMENT_HOME -> tran.replace(
                R.id.main_fragment,
                HomeFragment()
            ).commit()
            FRAGMENT_MY_SCHEDULE -> tran.replace(
                R.id.main_fragment,
                MyScheduleFragment()
            ).commit()
            FRAGMENT_COMPANION -> tran.replace(
                R.id.main_fragment,
                TravelFragment()
            ).commit()
            FRAGMENT_CHAT -> tran.replace(
                R.id.main_fragment,
                ChatFragment()
            ).commit()
            FRAGMENT_AD -> tran.replace(
                R.id.main_fragment,
                AdvFragment()
            ).commit()
        }

    }
}
