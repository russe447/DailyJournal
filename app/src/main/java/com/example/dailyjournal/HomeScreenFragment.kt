package com.example.dailyjournal

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.*

class HomeScreenFragment : Fragment() {

    private lateinit var viewOfLayout : View
    private var addTextButton: Button? = null
    private var addImageButton: Button? = null
    private var addEventButton: Button? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater.inflate(R.layout.home_screen, container, false)
        // addTextButton = viewOfLayout.findViewById<Button>(R.id.addText)
        addImageButton = viewOfLayout.findViewById<Button>(R.id.addImage)
        addEventButton = viewOfLayout.findViewById<Button>(R.id.addEvent)

        addTextButton!!.setOnClickListener {
            val intent = Intent(activity, AddTextEntryActivity::class.java)
            startActivity(intent)
        }

        addImageButton!!.setOnClickListener {
            val imgIntent = Intent(activity, AddImageActivity::class.java)
            startActivity(imgIntent)
        }

        addEventButton!!.setOnClickListener {
            val calIntent = Intent(activity, AddEventActivity::class.java)
            startActivity(calIntent)
        }

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