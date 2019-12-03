package com.example.dailyjournal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddTextEntryActivity : AppCompatActivity() {
    private var saveBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_entry)

        saveBtn = findViewById<Button>(R.id.saveButton)

        saveBtn!!.setOnClickListener {
            //TODO: integrate with calendar activity and firebase
            val homeIntent = Intent(this@AddTextEntryActivity, HomeScreenActivity::class.java)
            startActivity(homeIntent)
        }
    }
}