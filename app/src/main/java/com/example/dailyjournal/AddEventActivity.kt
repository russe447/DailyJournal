package com.example.dailyjournal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {

    private var eventSaveBtn: Button? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null

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

            //Toast.makeText(this, name.text.toString(), Toast.LENGTH_LONG).show()
            val event = Event()
            event.title = name.text.toString()
            event.location = location.text.toString()
            event.date = date.text.toString()
            event.startTime = start.text.toString()
            event.endTime = end.text.toString()

           // mDatabase = FirebaseDatabase.getInstance()
           // mDatabaseReference = mDatabase!!.reference!!.child("User Information")

            val eventIntent = Intent()
            setResult(Activity.RESULT_OK, eventIntent)
            eventIntent.putExtra("Event", event)
            finish()
        }
    }
}