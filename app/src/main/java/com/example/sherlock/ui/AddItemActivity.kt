package com.example.sherlock.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sherlock.R

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        // Do not show previous app bar
        supportActionBar?.hide()
    }
}