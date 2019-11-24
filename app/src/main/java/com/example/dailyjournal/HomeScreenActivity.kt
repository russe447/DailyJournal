package com.example.dailyjournal

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.*


class HomeScreenActivity : AppCompatActivity()  {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen_blank)

        // Starts the fragment for the home screen and places it in the fragment_container framelayout
        val frag = HomeScreenFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, frag).commit()

        bottomNav = findViewById(R.id.bottomNavigation)

        // Listener for the navigation bar, replaces the current fragment in the framelayout
        bottomNav.setOnNavigationItemSelectedListener { item ->

            val frag : Fragment

            when (item.itemId) {
                R.id.journal -> {
                    true
                }
                R.id.calendar -> {
                    frag = CalendarFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, frag).commit()

                }
                R.id.settings -> {
                    true
                }
                R.id.stats -> {
                    true
                }
            }
            false
        }
    }


}