package com.project.gobike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//To access the User Page
class ParisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paris)

        val actionBar = supportActionBar

        actionBar!!.title = "GoBike"

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

    fun openBikeStationParis(view: View) {
        val intent = Intent(this, BikeStationParis::class.java)
        startActivity(intent)
    }
}