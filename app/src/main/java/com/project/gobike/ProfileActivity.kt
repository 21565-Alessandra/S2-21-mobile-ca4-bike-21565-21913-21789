package com.project.gobike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_registration.*
import org.w3c.dom.Text

//To access the User Page
class ProfileActivity : AppCompatActivity() {
    lateinit var displayUser: TextView
    lateinit var welcomeText: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val preferences = getSharedPreferences("DATA_USER", MODE_PRIVATE)
        val user = preferences.getString("display", "")

        displayUser = findViewById(R.id.userTextView);
        welcomeText = findViewById(R.id.textViewWelcome)

        displayUser.text = user
        welcomeText.text = "WELCOME"

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