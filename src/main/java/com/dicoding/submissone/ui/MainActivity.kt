package com.dicoding.submissone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dicoding.submissone.R
import com.dicoding.submissone.databinding.ActivityMainBinding
import com.dicoding.submissone.ui.fragment.PastEventsFragment
import com.dicoding.submissone.ui.fragment.UpcomingEventsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set default fragment only if there is no saved instance state
        if (savedInstanceState == null) {
            openFragment(UpcomingEventsFragment()) // Set default fragment
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_upcoming -> {
                    openFragment(UpcomingEventsFragment())
                    true
                }
                R.id.navigation_past -> {
                    openFragment(PastEventsFragment())
                    true
                }
                else -> false
            }
        }

        // Set the default selected item
        bottomNavigationView.selectedItemId = R.id.navigation_upcoming
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Optionally add to back stack
            .commitAllowingStateLoss() // Avoid crashes on state loss
    }
}
