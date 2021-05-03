package com.project.gobike

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CityActivity : AppCompatActivity() {

    lateinit var displayName: TextView
    lateinit var welcomeText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_city)

        val preferences = getSharedPreferences("DATA_USER", AppCompatActivity.MODE_PRIVATE)
        val userName = preferences.getString("display", "")

        displayName = findViewById(R.id.userTextView);
        welcomeText = findViewById(R.id.textViewWelcome)

        displayName.text = userName
        welcomeText.text = "WELCOME"
    }

    fun openDublinActivity(view: View) {
        val intent = Intent(this, DublinActivity::class.java)
        startActivity(intent)
    }

    fun openParisActivity(view: View) {
        val intent = Intent(this, ParisActivity::class.java)
        startActivity(intent)
    }


}