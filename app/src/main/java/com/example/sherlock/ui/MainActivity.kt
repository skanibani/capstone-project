package com.example.sherlock.ui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.sherlock.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.topAppBar))

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        val navView = findViewById<NavigationView>(R.id.navView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        topAppBar.setupWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_item_overview -> {
                    it.isChecked = true
                    drawerLayout.close()
                    true
                }
                R.id.nav_item_scan -> {
                    it.isChecked = true
                    drawerLayout.close()
                    true
                }
                R.id.nav_item_gather -> {
                    it.isChecked = true
                    drawerLayout.close()
                    true
                }
                R.id.nav_item_out_system -> {
                    it.isChecked = true
                    drawerLayout.close()
                    true
                }
                else -> false
            }
        }

        init()
    }

    private fun init() {

    }
}