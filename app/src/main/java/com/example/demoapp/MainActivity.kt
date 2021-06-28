package com.example.demoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.demoapp.fragment.HomeFragment
import com.example.demoapp.fragment.ListFragment
import com.example.demoapp.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val listFragment = ListFragment()
        val settingsFragment = SettingsFragment()
        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_list -> makeCurrentFragment(listFragment)
                R.id.ic_settings -> makeCurrentFragment(settingsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
}