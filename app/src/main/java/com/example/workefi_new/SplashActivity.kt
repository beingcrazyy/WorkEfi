package com.example.workefi_new

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val Splashlogo : TextView = findViewById(R.id.MainLogo)
        val getLarge = AnimationUtils.loadAnimation(this,R.anim.larger_logo)
        Splashlogo.startAnimation(getLarge)


        val intentHome = Intent(this,OnboardActivity::class.java)
        val handler = Handler()
        handler.postDelayed({
            startActivity(intentHome)
            finish()
        },1800)
    }
}