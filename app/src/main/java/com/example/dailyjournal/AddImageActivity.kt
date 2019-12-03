package com.example.dailyjournal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.home_screen.*

class AddImageActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_text_entry)

        imageUpload()
    }

    private fun imageUpload() {

        val imageIntent = Intent(Intent.ACTION_GET_CONTENT)
        imageIntent.type = "image/*"
        startActivityForResult(imageIntent, PICK_IMAGE_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /*if(resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE_REQUEST) {
            imageView.setImageURI(data?.data)
        }*/
    }

    companion object {
        private val PICK_IMAGE_REQUEST = 1000;
    }

}