//21565 - Alessandra Reis // 21913 - Taiane Vieira da Silva // 21789 - Yuri Filipe Almeida Silva

package com.project.gobike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//To access the User Page
class ParisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_GoBike)
        setContentView(R.layout.activity_paris)

        val actionBar = supportActionBar

        actionBar!!.title = "GoBike Paris"

        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    fun openMapsActivityParis(view: View) {
        val intent = Intent(this, MapsActivityParis::class.java)
        startActivity(intent)
    }

    fun openWeatherParis(view: View) {
        val intent = Intent(this, WeatherParis::class.java)
        startActivity(intent)
    }

    fun openMainActivityParis(view: View) {
        val intent = Intent(this, MainActivityParis::class.java)
        startActivity(intent)
    }
}