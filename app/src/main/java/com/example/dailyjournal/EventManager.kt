package com.example.dailyjournal
import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log

class EventManagerActivity : ListActivity() {

    internal lateinit var mAdapter: EventAdapter

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAdapter = EventAdapter(applicationContext)
        listView.adapter = mAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("TAGGGG", "Entered onActivityResult()")
        if(requestCode == 0 && resultCode == RESULT_OK) {
            data?.let {
                val newEvent = Event(data)
                mAdapter.addEvent(newEvent)
            }
        }
    }
}
