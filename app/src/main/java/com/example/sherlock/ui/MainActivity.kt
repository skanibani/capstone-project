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
    private lateinit var viewModel: ItemViewModel

    private val registeredItems = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.topAppBar))

        findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener {
            findViewById<DrawerLayout>(R.id.drawerLayout).open()
        }

        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        viewModel.items.observe(this, Observer<List<Item>> {
            registeredItems.addAll(it)
            // TODO notify Adapter
        })

        init()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun init() {
        val testItem = Item(
                "Apple",
                "Phones",
                "Black",
                "Found on chair",
                "Plastic",
                "None",
                "T4"
        )

        viewModel.insertItem(testItem)
    }
}