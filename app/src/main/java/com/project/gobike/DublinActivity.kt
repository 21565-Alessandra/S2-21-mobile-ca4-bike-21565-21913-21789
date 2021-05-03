package com.project.gobike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//To access the User Page
class DublinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dublin)

        val actionBar = supportActionBar

        actionBar!!.title = "GoBike"

        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    fun openMapsActivity(view: View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    fun openWeatherActivity(view: View) {
        val intent = Intent(this, WeatherActivity::class.java)
        startActivity(intent)
    }

    fun openBikeStationActivity(view: View) {
        val intent = Intent(this, BikeStationActivity::class.java)
        startActivity(intent)
    }
}