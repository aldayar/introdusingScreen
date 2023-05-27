package com.example.lesson2.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lesson2.R
import com.example.lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
        setAppbarConfiguration()
        //не показывает фрагмент
        if (!App.prefs.isRegisterShowed()){
            navController.navigateUp()
        }
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val hideBotNav = when (destination.id) {
                R.id.onBoardFragment, R.id.phoneFragment, R.id.codeFragment -> true
                else -> false
            }
            binding.navigation.visibility = if (hideBotNav) View.GONE else View.VISIBLE

            if (destination.id == R.id.contact_note_fragment) {
                Toast.makeText(this, "Loading contacts", Toast.LENGTH_SHORT).show()
            }
        }

        binding.navigation.setupWithNavController(navController)
    }
    private fun setAppbarConfiguration() {
        if (!App.prefs.isBoardShow()) {
            navController.navigate(R.id.onBoardFragment)
        }



        val bottomNav = setOf(
            R.id.contact_note_fragment,
            R.id.noteFragment,
            R.id.profile_note_fragment
        )
        val appBarConfiguration = AppBarConfiguration(bottomNav)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
