package com.project.gobike

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*
import java.text.FieldPosition

class MapsActivityParis : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    //private lateinit var listOfBikeStations: List<BikeStation>  //*************
    private val REQUEST_LOCATION_PERMISSION = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)


        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        val actionBar = supportActionBar

        actionBar!!.title = "GoBike"

        actionBar.setDisplayHomeAsUpEnabled(true)


        //retrieveFavourites()
    }



    private fun isPermissionGranted() : Boolean {
        return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun enableMyLocation() { // to add the icon that when you tap will drive the camera to the current location of the user
        if (isPermissionGranted()) {
            if(ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            map.isMyLocationEnabled = true
        }
        else {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_LOCATION_PERMISSION
            )
        }
    }


    override fun onMapReady(googleMap: GoogleMap) { // where we add the markers and move the camera
        map = googleMap

        //val latitude = 53.34807
        //val longitude = -6.24827

        val paris = LatLng(48.85856, 2.29441)
        //val station_1 = LatLng(53.349562, -6.278198)

        val zoomLevel = 15f

        //map.moveCamera(CameraUpdateFactory.newLatLng(dublin))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, zoomLevel)) // to move the camera and pass in the zoom level
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_1, zoomLevel))

        map.addMarker(MarkerOptions().position(paris).title("Marker in Louvre Museum")) //to add marker
        //map.addMarker(MarkerOptions().position(station_1).title("SMITHFIELD NORTH"))

        setMapLongClick(map)
        setPoiClick(map)
        enableMyLocation()
    }


    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.map_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) { // It will add 3 dots on the right top of the screen with the options below
        // Change the map type based on the user's selection.
        R.id.normal_map -> {
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_map -> {
            map.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_map -> {
            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_map -> {
            map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setMapLongClick(map: GoogleMap) { //an option to set the favorites
        map.setOnMapLongClickListener { latLng ->

            val snippet = String.format(
                    Locale.getDefault(),
                    "Lat: %1$.5f, Long: %2$.5f",
                    latLng.latitude,
                    latLng.longitude
            )


            map.addMarker(
                    MarkerOptions()
                            .position(latLng)
                            .title(getString(R.string.dropped_pin))
                            .snippet(snippet)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            ) //now if tap the marker it will show "dropped pin" and will show lat + long on the screen

            // It is around here you grab and store coordinates
        }
    }

    private fun setPoiClick(map: GoogleMap) {
        map.setOnPoiClickListener { poi ->
            val poiMarker = map.addMarker(
                    MarkerOptions()
                            .position(poi.latLng)
                            .title(poi.name)
            )
            poiMarker.showInfoWindow()
        }
    } //point of interest -- basically, if you tap on a place that already shows a marker (restaurant, hotel, hospital...) it will add a marker in front and print the name on the top



}