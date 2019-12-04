package com.example.dailyjournal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddTextEntryActivity : AppCompatActivity() {

    private var entry: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_entry)

        entry = intent?.getStringExtra("JOURNAL_ENTRY_TEXT")

    }
}