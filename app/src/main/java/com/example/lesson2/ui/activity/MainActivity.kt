package com.example.lesson2.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lesson2.R
import com.example.lesson2.databinding.ActivityMainBinding
import com.example.lesson2.ui.fragments.contactnote.ContactNoteFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        hideBotNav()
        setAppbarConfiguration()

    }

    private fun hideBotNav(){
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val hideBotNav = when(destination.id){
                R.id.contact_note_fragment,R.id.onBoardFragment -> true
                else -> false
            }
            if (hideBotNav){
                binding.navigation.visibility= View.GONE
            }else{
                binding.navigation.visibility= View.VISIBLE
            }
        }

    }
    private fun setAppbarConfiguration() {
        if (!App.prefs.isBoardShow()) {
            navController.navigate(R.id.onBoardFragment)
        }
        // замена фрагментов
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.contact_note_fragment,
                R.id.noteFragment,
                R.id.profile_note_fragment

            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigation.setupWithNavController(navController)
    }
}
