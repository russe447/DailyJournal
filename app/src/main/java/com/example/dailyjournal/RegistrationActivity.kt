package com.example.dailyjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {

   // private var username:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Need to add part for person to input their name for the app to call them

        val email = findViewById<EditText>(R.id.email)
        val pass = findViewById<EditText>(R.id.password)

        val button = findViewById<Button>(R.id.register_button)

        button.setOnClickListener {

            // Also check if email is valid email
            if (email.text.isEmpty() || pass.text.isEmpty()) {
                Toast.makeText(applicationContext, "Enter Valid Email/Password", Toast.LENGTH_SHORT).show()
            }
            else {
                // Store credentials in firebase

            }
        }
    }
}
