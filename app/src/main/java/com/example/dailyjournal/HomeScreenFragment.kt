package com.example.dailyjournal

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.home_screen.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.*
import java.io.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast


class HomeScreenFragment : Fragment() {

    private lateinit var viewOfLayout : View
    private var addImageButton: Button? = null
    private var addEventButton: Button? = null
    private var saveEntryButton: Button? = null
    private var fOut: FileOutputStream? = null
    private var myOutWriter: OutputStreamWriter? = null
    private var myFile: File? = null
    private val filename = "SampleFile.txt"
    private val filepath = "MyFileStorage"
    protected lateinit var myExternalFile: File




    private val isExternalStorageReadOnly: Boolean
        get() {
            val extStorageState = Environment.getExternalStorageState()
            return if (Environment.MEDIA_MOUNTED_READ_ONLY == extStorageState) {
                true
            } else false
        }

    private val isExternalStorageAvailable: Boolean
        get() {
            val extStorageState = Environment.getExternalStorageState()
            return if (Environment.MEDIA_MOUNTED == extStorageState) {
                true
            } else false
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewOfLayout = inflater.inflate(R.layout.home_screen, container, false)
        addImageButton = viewOfLayout.findViewById<Button>(R.id.addImage)
        addEventButton = viewOfLayout.findViewById<Button>(R.id.addEvent)
        saveEntryButton = viewOfLayout.findViewById<Button>(R.id.saveText)

        if (!isExternalStorageAvailable || isExternalStorageReadOnly) {
            Log.i("PErmission Denied", "Cannot Access")
        } else {
            myExternalFile = File(context?.getExternalFilesDir(filepath), filename)
        }



        saveEntryButton!!.setOnClickListener{ saveChanges()}

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

    fun saveChanges() {

        val today = Calendar.getInstance().getTime()
        val formatter = SimpleDateFormat("MMM dd, yyyy")
        val finalDate = formatter.format(today)
        //Create Object that stores entry for a certain date
        var entry = EntryComponent(finalDate, textView.toString())
        //Creates gson object
        var gson = Gson()
        //Convert the Json Object to JsonString
        var jsonString:String = gson.toJson(entry)
        //Write into file
        try {
            val fos = FileOutputStream(myExternalFile)
            fos.write(jsonString.toByteArray())
            fos.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        Toast.makeText(context?.applicationContext, "Successfully Saved", Toast.LENGTH_LONG).show()
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
}