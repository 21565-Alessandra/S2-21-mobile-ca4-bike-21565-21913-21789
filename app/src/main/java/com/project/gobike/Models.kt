package com.project.gobike

class HomeFeed(val favorites: List<ListBikeStation>)

class ListBikeStation(
        val number: Int, val contract_name: String, val name: String,
        val address: String, val lat: Double, val lng: Double,
        val banking: Boolean, val bonus: Boolean,
        val bike_stands: Int, val available_bike_stands: Int,
        val available_bikes: Int, val status: String,
        val last_update: Int

)