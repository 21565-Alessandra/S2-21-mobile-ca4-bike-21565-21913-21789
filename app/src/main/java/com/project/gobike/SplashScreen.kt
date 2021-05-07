//21565 - Alessandra Reis // 21913 - Taiane Vieira da Silva // 21789 - Yuri Filipe Almeida Silva

package com.project.gobike

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.splashScreenTheme)
        setContentView(R.layout.splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },
                3000)
    }
}

