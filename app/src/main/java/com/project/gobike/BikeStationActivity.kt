//21565 - Alessandra Reis // 21913 - Taiane Vieira da Silva // 21789 - Yuri Filipe Almeida Silva

package com.project.gobike

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class BikeStationActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsersListParis.layoutManager = LinearLayoutManager( this)

        fetchJson()

    }

    fun fetchJson() {
        println("Attempting to Fetch JSON")

        val url = "https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=bf9524e96a1c70d571efc99d5318c526ce6848b0"

        val request = Request.Builder().url(url).build()
        val user = OkHttpClient()

        user.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                /*runOnUiThread {
                    recyclerView_main.adapter = LocationAdapter(homeFeed)

                }*/
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")

            }

        })
    }
}
