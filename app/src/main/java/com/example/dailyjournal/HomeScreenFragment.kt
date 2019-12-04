package com.example.dailyjournal

import android.content.Intent
import android.content.Intent.getIntent
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.*

class HomeScreenFragment : Fragment() {

    private lateinit var viewOfLayout : View

    private var addImageButton: Button? = null
    private var addEventButton: Button? = null
    private var saveEntryButton: Button? = null
    private var writtenEntry: EditText? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater.inflate(R.layout.home_screen, container, false)
        saveEntryButton = viewOfLayout.findViewById<Button>(R.id.saveText)
        addImageButton = viewOfLayout.findViewById<Button>(R.id.addImage)
        addEventButton = viewOfLayout.findViewById<Button>(R.id.addEvent)
        writtenEntry = viewOfLayout.findViewById<EditText>(R.id.editText)


        addImageButton!!.setOnClickListener {
            val imgIntent = Intent(activity, AddImageActivity::class.java)
            startActivity(imgIntent)
        }

        addEventButton!!.setOnClickListener {
            val calIntent = Intent(activity, AddEventActivity::class.java)
            startActivityForResult(calIntent, 1)
            //var event = calIntent.getSerializableExtra("event") as Event

        }

        saveEntryButton!!.setOnClickListener {
            val entryIntent = Intent(activity, AddTextEntryActivity::class.java)
            entryIntent.putExtra("JOURNAL_ENTRY_TEXT", writtenEntry!!.text.toString())
            startActivity(entryIntent)
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
        view.text = finalDate
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Coming from the AddEventActivity
        if (requestCode == 1) {
            var event = data?.getSerializableExtra("event")
        }
    }
}