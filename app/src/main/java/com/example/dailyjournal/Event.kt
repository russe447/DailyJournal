package com.example.dailyjournal

import android.content.Intent
import java.io.Serializable
import java.util.*

class Event {

    var title = String()
    var location = String()
    var date = String()
    var startTime = String()
    var endTime = String()

    internal constructor(title: String, location: String, date: String, startTime: String, endTime: String) {
        this.title = title
        this.location = location
        this.date = date
        this.startTime = startTime
        this.endTime = endTime
    }

    internal constructor(intent: Intent) {

        title = intent.getStringExtra(Event.TITLE)
        date = intent.getStringExtra(Event.DATE)
        location = intent.getStringExtra(Event.LOCATION)
        startTime = intent.getStringExtra(Event.START_TIME)
        endTime = intent.getStringExtra(Event.END_TIME)
    }

    companion object {
        val TITLE = "title"
        val LOCATION = "location"
        val DATE = "date"
        val START_TIME = "start time"
        val END_TIME = "end time"

        fun packageIntent(intent: Intent, title: String,
                          location: String, startTime: String, endTime: String, date: String) {

            intent.putExtra(Event.TITLE, title)
            intent.putExtra(Event.LOCATION, location)
            intent.putExtra(Event.DATE, date)
            intent.putExtra(Event.START_TIME, startTime)
            intent.putExtra(Event.END_TIME, endTime)

        }
    }

}