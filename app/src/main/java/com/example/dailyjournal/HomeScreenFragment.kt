package com.example.dailyjournal

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.*

class HomeScreenFragment : Fragment() {

    private lateinit var viewOfLayout : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater.inflate(R.layout.home_screen, container, false)
        return viewOfLayout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val date = viewOfLayout.findViewById<TextView>(R.id.date)
        setDate(date)
    }
    fun setDate(view: TextView) {

        val today = Calendar.getInstance().getTime()
        val formatter = SimpleDateFormat("MMM dd, yyyy")
        val finalDate = formatter.format(today)
        view.setText(finalDate)
    }
}