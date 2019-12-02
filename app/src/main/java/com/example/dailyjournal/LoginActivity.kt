package com.example.dailyjournal

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.content.Intent

class LoginActivity : AppCompatActivity() {

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var email: EditText? = null
    private var password: EditText? = null
    private var loginButton: Button? = null
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("User Information")
        mAuth = FirebaseAuth.getInstance()

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.login_button)

        loginButton!!.setOnClickListener { accountLogin() }
    }

    private fun accountLogin() {
        if(TextUtils.isEmpty(email?.text.toString())) {
            Toast.makeText(applicationContext, "Enter email address", Toast.LENGTH_LONG).show()
        }

        if(TextUtils.isEmpty(password?.text.toString())) {
            Toast.makeText(applicationContext, "Enter password", Toast.LENGTH_LONG).show()
        }

        mAuth!!.signInWithEmailAndPassword(email?.text.toString(), password?.text.toString())
            .addOnCompleteListener {task ->
                if(task.isSuccessful) {
                    Toast.makeText(applicationContext, "Successful!", Toast.LENGTH_LONG).show()
                    val newIntent = Intent(this, SplashScreen::class.java)
                    //newIntent.putExtra(, mAuth?.)
                    startActivity(newIntent)

                } else {
                    Toast.makeText(applicationContext, "Failure", Toast.LENGTH_LONG).show()
                }
            }
    }

}