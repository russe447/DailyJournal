package com.example.dailyjournal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class EventList: AppCompatActivity() {
    private var nameResult: TextView? = null
    private var locationResult: TextView? = null
    private var date: TextView? = null
    private var startTime: TextView? = null
    private var endTime: TextView? = null
    private var doneBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_list)

        nameResult = findViewById<TextView>(R.id.textViewNameResult)
        locationResult = findViewById<TextView>(R.id.textViewLocResult)
        date = findViewById<TextView>(R.id.textViewDateResult)
        startTime = findViewById<TextView>(R.id.textViewSTResult)
        endTime = findViewById<TextView>(R.id.textViewETResult)
        doneBtn = findViewById<Button>(R.id.buttonDone)


        nameResult!!.text = intent.getStringExtra("title")
        locationResult!!.text = intent.getStringExtra("location")
        date!!.text = intent.getStringExtra("date")
        startTime!!.text = intent.getStringExtra("start time")
        endTime!!.text = intent.getStringExtra("end time")

        doneBtn!!.setOnClickListener {
            val doneIntent = Intent(this@EventList, HomeScreenActivity::class.java)
            startActivity(doneIntent)
        }
    }
}