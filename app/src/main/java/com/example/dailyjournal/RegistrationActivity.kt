package com.example.dailyjournal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import android.widget.ProgressBar
import android.view.View

class RegistrationActivity : AppCompatActivity() {

    private var passwordInput: EditText? = null
    private var emailInput: EditText? = null
    private var mAuth: FirebaseAuth? = null
    private var progressBar: ProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        mAuth = FirebaseAuth.getInstance()
        emailInput = findViewById<EditText>(R.id.email)
        passwordInput = findViewById<EditText>(R.id.password)
        progressBar = findViewById(R.id.progressBar)

        // Need to add part for person to input their name for the app to call them

        // val email = emailInput!!.text.toString()
        // val pass = passwordInput!!.text.toString()

        val button = findViewById<Button>(R.id.register_button)

        button.setOnClickListener {
            progressBar!!.visibility = View.VISIBLE
            Log.i("testing", "It breaks here")
            val email = emailInput!!.text.toString()
            val pass = passwordInput!!.text.toString()

            // Also check if email is valid email
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                Toast.makeText(applicationContext, "Enter Valid Email/Password", Toast.LENGTH_SHORT).show()
                progressBar!!.visibility = View.GONE
            }
            else {
                // Store credentials in firebase
                mAuth!!.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener {task ->
                        if(task.isSuccessful) {
                            Toast.makeText(applicationContext, "Success!", Toast.LENGTH_LONG).show()
                            progressBar!!.visibility = View.GONE
                            val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(applicationContext, "Failure!", Toast.LENGTH_LONG).show()
                            progressBar!!.visibility = View.GONE
                        }
                    }
            }
        }
    }
}
