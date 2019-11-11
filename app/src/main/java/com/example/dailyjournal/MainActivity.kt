package com.example.dailyjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    internal var registerBtn:Button? = null
    internal var loginBtn:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()

        registerBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }

        loginBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, SplashScreen::class.java)
            startActivity(intent)
        }
    }

    private fun initializeViews() {
        registerBtn = findViewById(R.id.register_button)
        loginBtn = findViewById(R.id.login_button)
    }
}
