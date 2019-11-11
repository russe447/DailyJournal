package com.example.dailyjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import android.widget.TextView

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val anim = AnimationUtils.loadAnimation(this, R.anim.fadein)

        val text = findViewById(R.id.welcome) as TextView
        val name: TextView = findViewById(R.id.name)


        text.startAnimation(anim)
        name.startAnimation(anim)
    }
}
