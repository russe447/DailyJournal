package com.example.dailyjournal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {

    private var eventSaveBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_form)

        eventSaveBtn = findViewById<Button>(R.id.eventSave)

        eventSaveBtn!!.setOnClickListener {
            //TODO: Link to calendar activity and firebase
            val eventIntent = Intent(this@AddEventActivity, HomeScreenActivity::class.java)
            startActivity(eventIntent)
        }
    }
}