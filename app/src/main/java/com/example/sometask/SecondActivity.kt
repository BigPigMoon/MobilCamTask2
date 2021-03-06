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

        val menuView1: View = findViewById(R.id.menuView1);
        val menuView2: View = findViewById(R.id.menuView2);
        val menuView3: View = findViewById(R.id.menuView3);
        val menuView4: View = findViewById(R.id.menuView4);
        val menuView5: View = findViewById(R.id.menuView5);


        menuView1.setOnClickListener {
            val popupMenu = androidx.appcompat.widget.PopupMenu(this, menuView1)

            popupMenu.inflate(R.menu.popupmenu)
            popupMenu.show()
        }

        menuView2.setOnClickListener {
            val popupMenu = androidx.appcompat.widget.PopupMenu(this, menuView2)

            popupMenu.inflate(R.menu.popupmenu)
            popupMenu.show()
        }

        menuView3.setOnClickListener {
            val popupMenu = androidx.appcompat.widget.PopupMenu(this, menuView3)

            popupMenu.inflate(R.menu.popupmenu)
            popupMenu.show()
        }

        menuView4.setOnClickListener {
            val popupMenu = androidx.appcompat.widget.PopupMenu(this, menuView4)

            popupMenu.inflate(R.menu.popupmenu)
            popupMenu.show()
        }

        menuView5.setOnClickListener {
            val popupMenu = androidx.appcompat.widget.PopupMenu(this, menuView5)

            popupMenu.inflate(R.menu.popupmenu)
            popupMenu.show()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            // ?????????? ??????????????, ?????????????????? ?????????????????? ????????????????
            val thumbnailBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(thumbnailBitmap)
        }
    }
}