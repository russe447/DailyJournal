package com.example.dailyjournal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_text_entry)

        imageUpload()
    }

    private fun imageUpload() {

        val imageIntent = Intent(Intent.ACTION_PICK)
        imageIntent.type = "image/*"
        startActivityForResult(Intent.createChooser(imageIntent, "Choose Picture"), PICK_IMAGE_REQUEST)

    }

    companion object {
        private val PICK_IMAGE_REQUEST = 1000;
    }



}