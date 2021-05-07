package com.project.gobike

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        },
                3000)
    }
}

