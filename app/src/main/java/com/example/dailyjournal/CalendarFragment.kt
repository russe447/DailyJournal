package com.example.dailyjournal

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_calendar.*
import java.time.LocalDateTime

class CalendarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Sets Up Journal Entry Preview for Current Day
        dayEntry?.text = LocalDateTime.now().toString()
        //Changes Journal Entry Preview for Selected Day
        calendarView?.setOnDateChangeListener {view, year, month, dayOfMonth ->
            textView2?.text = String.format("On %d/%d/%d", month, dayOfMonth, year)
            dayEntry?.text = "This is where the journal entry would be placed"
        }
    }
}