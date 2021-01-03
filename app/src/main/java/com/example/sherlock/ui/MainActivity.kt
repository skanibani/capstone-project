package com.example.sherlock.ui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sherlock.R
import com.example.sherlock.database.ItemDao
import com.example.sherlock.database.ItemDatabase
import com.example.sherlock.databinding.ActivityMainBinding
import com.example.sherlock.model.Item
import com.example.sherlock.model.ItemViewModel
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.topAppBar))

        findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener {
            findViewById<DrawerLayout>(R.id.drawerLayout).open()
        }

        init()
    }

    private fun init() {

    }
}