package com.example.dailyjournal

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val anim = AnimationUtils.loadAnimation(this, R.anim.fadein)

        var cal = Calendar.getInstance()
        var time = cal.get(Calendar.HOUR_OF_DAY)

        val text = findViewById<TextView>(R.id.welcome)
        val name: TextView = findViewById(R.id.name)

        if (time in 0..12) {
            text.text = "Good Morning"
        }
        else if (time in 12..17) {
            text.text = "Good Afternoon"
        }
        else {
            text.text = "Good Evening"
        }
        text.startAnimation(anim)
        name.startAnimation(anim)
    }
}
