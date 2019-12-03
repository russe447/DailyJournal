package com.example.dailyjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    internal var registerBtn:Button? = null
    internal var loginBtn:Button? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var email: EditText? = null
    private var password: EditText? = null
    private var mAuth: FirebaseAuth? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("User Information")
        mAuth = FirebaseAuth.getInstance()

        progressBar = findViewById(R.id.progressBar)

        registerBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }

        //Temporary Access to Home Screen
        loginBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeScreenActivity::class.java)
            startActivity(intent) }
        //loginBtn!!.setOnClickListener { accountLogin() }
    }

    private fun accountLogin() {
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        progressBar!!.visibility = View.VISIBLE
        if(TextUtils.isEmpty(email?.text.toString())) {
            Toast.makeText(applicationContext, "Enter email address", Toast.LENGTH_LONG).show()
            progressBar!!.visibility = View.GONE
            return
        }

        if(TextUtils.isEmpty(password?.text.toString())) {
            Toast.makeText(applicationContext, "Enter password", Toast.LENGTH_LONG).show()
            progressBar!!.visibility = View.GONE
            return
        }

        mAuth!!.signInWithEmailAndPassword(email?.text.toString(), password?.text.toString())
            .addOnCompleteListener {task ->
                if(task.isSuccessful) {
                    Toast.makeText(applicationContext, "Successful!", Toast.LENGTH_LONG).show()
                    progressBar!!.visibility = View.GONE
                    val newIntent = Intent(this, SplashScreen::class.java)
                    //newIntent.putExtra(, mAuth?.)
                    startActivity(newIntent)

                } else {
                    Toast.makeText(applicationContext, "Failure", Toast.LENGTH_LONG).show()
                    progressBar!!.visibility = View.GONE
                }
            }
    }

    private fun initializeViews() {
        registerBtn = findViewById(R.id.register_button)
        loginBtn = findViewById(R.id.login_button)
    }
}
