package com.example.sometask

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageSwitcher
import android.widget.ImageView

class SecondActivity : Activity() {
    private val REQUEST_TAKE_PHOTO = 1
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        imageView = findViewById(R.id.imageView)
        val button: ImageView = findViewById(R.id.imageView)

        button.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
               startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            }
            catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем миниатюру картинки
            val thumbnailBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(thumbnailBitmap)
        }
    }
}