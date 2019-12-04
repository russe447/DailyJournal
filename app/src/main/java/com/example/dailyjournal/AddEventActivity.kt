package com.example.dailyjournal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {

    private var eventSaveBtn: Button? = null
    private var nameEntry: EditText? = null
    private var locationEntry: EditText? = null
    private var dateEntry: EditText? = null
    private var startEntry: EditText? = null
    private var endEntry: EditText? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_form)

        eventSaveBtn = findViewById<Button>(R.id.eventSave)
        nameEntry = findViewById<View>(R.id.name) as EditText
        locationEntry = findViewById<EditText>(R.id.location)
        dateEntry = findViewById<EditText>(R.id.date)
        startEntry = findViewById<EditText>(R.id.start_time)
        endEntry = findViewById<EditText>(R.id.end_time)


        eventSaveBtn!!.setOnClickListener {
            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show()
            val title = nameEntry!!.text.toString()
            val location = locationEntry!!.text.toString()
            val date = dateEntry!!.text.toString()
            val startEntry = startEntry!!.text.toString()
            val endEntry = endEntry!!.text.toString()

            val eventIntent = Intent(this@AddEventActivity, EventList::class.java)
            Event.packageIntent(eventIntent, title, location, startEntry, endEntry, date)
            startActivity(eventIntent)
        }
    }
}