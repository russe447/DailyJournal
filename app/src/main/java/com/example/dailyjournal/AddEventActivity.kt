package com.example.dailyjournal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {

    private var eventSaveBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_form)

        eventSaveBtn = findViewById<Button>(R.id.eventSave)

        eventSaveBtn!!.setOnClickListener {
            //TODO: Link to calendar activity and firebase
            val name = findViewById(R.id.name) as EditText
            val location = findViewById(R.id.location) as EditText
            val date = findViewById(R.id.date) as EditText
            val start = findViewById(R.id.start_time) as EditText
            val end = findViewById(R.id.end_time) as EditText

            Toast.makeText(this, name.toString(), Toast.LENGTH_LONG).show()

            val eventIntent = Intent(this@AddEventActivity, HomeScreenActivity::class.java)
            startActivity(eventIntent)
        }
    }
}