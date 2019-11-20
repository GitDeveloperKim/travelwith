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
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var frag1: Fragment
    lateinit var frag2: Fragment
    lateinit var frag3: Fragment

    lateinit var fm: FragmentManager
    lateinit var tran: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)

        frag1 = Fragment()
        frag2 = Fragment()
        frag3 = Fragment()

        btn1.setOnClickListener {
            toast("setFrag0")
            setFrag(0)
        }
        btn2.setOnClickListener {
            toast("setFrag1")
            setFrag(1)
        }
        btn3.setOnClickListener {
            toast("setFrag2")
            setFrag(2)
        }
        btn4.setOnClickListener {
            toast("setFrag3")
            setFrag(3)
        }
        btn5.setOnClickListener {
            toast("setFrag4")
            setFrag(4)
        }

    }


    fun setFrag(n: Int) {
        fm = supportFragmentManager
        tran = fm.beginTransaction()

        when (n) {
            0 -> tran.replace(
                R.id.main_fragment,
                HomeFragment()
            ).commit()
            1 -> tran.replace(
                R.id.main_fragment,
                MyScheduleFragment()
            ).commit()
            2 -> tran.replace(
                R.id.main_fragment,
                TravelFragment()
            ).commit()
            3 -> tran.replace(
                R.id.main_fragment,
                ChatFragment()
            ).commit()
            4 -> tran.replace(
                R.id.main_fragment,
                AdvFragment()
            ).commit()
        }

    }
}
