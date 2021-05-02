package com.project.gobike

data class Location(
        val number: Int,
        val contract_name: String,
        val name: String,
        val address: String,
        val lat: Double,
        val lng: Double,
        val bikeStands: Int,
        val available_bike_stands: Int,
        val available_bikes: Int,
        val status: String,
        val favorite: Boolean)

