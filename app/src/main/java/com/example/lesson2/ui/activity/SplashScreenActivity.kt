package com.example.lesson2.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.lesson2.R
import com.example.lesson2.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private var progress= 0
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animation.setAnimation(R.raw.animation)
        start()

    }

    private fun start(){
        Handler(Looper.getMainLooper()).postDelayed({
            if (progress>=1500){
                startApp()
                finish()
            }else{
                start()
                progress+=100
                binding.itemProgess.progress =  progress
            }
        },100)
    }
    private fun startApp() {
        val intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
        startActivity(intent)
    }
}