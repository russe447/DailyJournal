package com.example.dailyjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        val date = findViewById(R.id.date) as TextView
        setDate(date)
    }

    fun setDate(view: TextView) {

        val today = Calendar.getInstance().getTime()
        val formatter = SimpleDateFormat("MMM dd, yyyy")
        val finalDate = formatter.format(today)
        view.setText(finalDate)
    }
}