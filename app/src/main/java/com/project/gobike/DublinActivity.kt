//21565 - Alessandra Reis // 21913 - Taiane Vieira da Silva // 21789 - Yuri Filipe Almeida Silva

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

        actionBar!!.title = "GoBike Dublin"

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

    fun openMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}