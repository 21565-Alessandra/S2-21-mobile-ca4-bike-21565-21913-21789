//21565 - Alessandra Reis // 21913 - Taiane Vieira da Silva // 21789 - Yuri Filipe Almeida Silva

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
import okhttp3.*
import java.io.IOException
import java.util.*
import java.text.FieldPosition

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    //private lateinit var listOfBikeStations: List<BikeStation>  //*************
    private val REQUEST_LOCATION_PERMISSION = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_GoBike)
        setContentView(R.layout.activity_maps)


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        val actionBar = supportActionBar

          actionBar!!.title = "GoBike Dublin"

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

        val dublin = LatLng(53.34807, -6.24827)
        val station_1 = LatLng(53.349562, -6.278198)
        val station_2 = LatLng(53.353462, -6.265305)
        val station_3 = LatLng(53.336021, -6.26298)
        val station_4 = LatLng(53.359405, -6.265305)
        val station_5 = LatLng(53.33796, -6.24153)
        val station_6 = LatLng(53.343368, -6.27012)
        val station_7 = LatLng(53.334123, -6.265436)
        val station_8 = LatLng(53.344304, -6.250427)
        val station_9 = LatLng(53.338755, -6.262003)
        val station_10 = LatLng(53.347777, -6.244239)
        val station_11 = LatLng(53.336074, -6.252825)
        val station_12 = LatLng(53.330091, -6.268044)
        val station_13 = LatLng(53.350929, -6.265125)
        val station_14 = LatLng(53.341515, -6.256853)
        val station_15 = LatLng(53.348279, -6.254662)
        val station_16 = LatLng(53.35893, -6.280337)
        val station_17 = LatLng(53.357841, -6.251557)
        val station_18 = LatLng(53.344115, -6.237153)
        val station_19 = LatLng(53.343893, -6.280531)
        val station_20 = LatLng(53.347477, -6.28525)
        val station_21 = LatLng(53.339005, -6.300217)
        val station_22 = LatLng(53.344153, -6.233451)
        val station_23 = LatLng(53.334295, -6.258503)
        val station_24 = LatLng(53.340803, -6.267732)
        val station_25 = LatLng(53.351464, -6.255265)
        val station_26 = LatLng(53.333653, -6.248345)
        val station_27 = LatLng(53.343105, -6.277167)
        val station_28 = LatLng(53.341428, -6.24672)
        val station_29 = LatLng(53.338614, -6.248606)
        val station_30 = LatLng(53.341833, -6.231291)
        val station_31 = LatLng(53.346637, -6.246154)
        val station_32 = LatLng(53.343034, -6.263578)
        val station_33 = LatLng(53.346867, -6.230852)
        val station_34 = LatLng(53.3547, -6.272314)
        val station_35 = LatLng(53.33403, -6.260714)

        val station_36 = LatLng(53.346026, -6.243576)
        val station_37 = LatLng(53.330662, -6.260177)
        val station_38 = LatLng(53.342113, -6.310015)
        val station_39 = LatLng(53.357043, -6.263232)
        val station_40 = LatLng(53.348875, -6.267459)
        val station_41 = LatLng(53.342081, -6.275233)
        val station_42 = LatLng(53.346874, -6.272976)
        val station_43 = LatLng(53.347932, -6.240928)
        val station_44 = LatLng(53.334432, -6.245575)
        val station_45 = LatLng(53.343565, -6.275071)


//        val station_16 = LatLng()
//        val station_17 = LatLng()
//        val station_18 = LatLng()
//        val station_19 = LatLng()
//        val station_20 = LatLng()
//        val station_21 = LatLng()
//        val station_22 = LatLng()
//        val station_23 = LatLng()
//        val station_24 = LatLng()
//        val station_25 = LatLng()
//        val station_16 = LatLng()
//        val station_17 = LatLng()
//        val station_18 = LatLng()
//        val station_19 = LatLng()
//        val station_20 = LatLng()
//        val station_21 = LatLng()
//        val station_22 = LatLng()
//        val station_23 = LatLng()
//        val station_24 = LatLng()
//        val station_25 = LatLng()




        val zoomLevel = 15f

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(dublin, zoomLevel)) // to move the camera and pass in the zoom level
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_1, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_2, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_3, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_4, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_5, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_6, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_7, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_8, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_9, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_10, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_11, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_12, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_13, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_14, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_15, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_16, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_17, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_18, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_19, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_20, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_21, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_22, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_23, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_24, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_25, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_26, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_27, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_28, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_29, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_30, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_31, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_32, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_33, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_34, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_35, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_36, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_37, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_38, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_39, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_40, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_41, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_42, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_43, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_44, zoomLevel))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station_45, zoomLevel))




        map.addMarker(MarkerOptions().position(dublin).title("Marker in Dublin")) //to add marker
        map.addMarker(MarkerOptions().position(station_1).title("SMITHFIELD NORTH"))
        map.addMarker(MarkerOptions().position(station_2).title("PARNELL SQUARE NORTH"))
        map.addMarker(MarkerOptions().position(station_3).title("CLONMEL STREET"))
        map.addMarker(MarkerOptions().position(station_4).title("AVONDALE ROAD"))
        map.addMarker(MarkerOptions().position(station_5).title("MOUNT STREET LOWER"))
        map.addMarker(MarkerOptions().position(station_6).title("CHRISTCHURCH PLACE"))
        map.addMarker(MarkerOptions().position(station_7).title("GRANTHAM STREET"))
        map.addMarker(MarkerOptions().position(station_8).title("PEARSE STREET"))
        map.addMarker(MarkerOptions().position(station_9).title("YORK STREET EAST"))
        map.addMarker(MarkerOptions().position(station_10).title("EXCISE WALK"))
        map.addMarker(MarkerOptions().position(station_11).title("FITZWILLIAM SQUARE WEST"))
        map.addMarker(MarkerOptions().position(station_12).title("PORTOBELLO ROAD"))
        map.addMarker(MarkerOptions().position(station_13).title("PARNELL STREET"))
        map.addMarker(MarkerOptions().position(station_14).title("FREDERICK STREET SOUTH"))
        map.addMarker(MarkerOptions().position(station_15).title("CUSTOM HOUSE"))
        map.addMarker(MarkerOptions().position(station_16).title("RATHDOWN ROAD"))
        map.addMarker(MarkerOptions().position(station_17).title("NORTH CIRCULAR ROAD (O'CONNELL'S)"))
        map.addMarker(MarkerOptions().position(station_18).title("HANOVER QUAY"))
        map.addMarker(MarkerOptions().position(station_19).title("OLIVER BOND STREET"))
        map.addMarker(MarkerOptions().position(station_20).title("COLLINS BARRACKS MUSEUM"))
        map.addMarker(MarkerOptions().position(station_21).title("BROOKFIELD ROAD"))
        map.addMarker(MarkerOptions().position(station_22).title("BENSON STREET"))
        map.addMarker(MarkerOptions().position(station_23).title("EARLSFORT TERRACE"))
        map.addMarker(MarkerOptions().position(station_24).title("GOLDEN LANE"))
        map.addMarker(MarkerOptions().position(station_25).title("DEVERELL PLACE"))
        map.addMarker(MarkerOptions().position(station_26).title("WILTON TERRACE (PARK)"))
        map.addMarker(MarkerOptions().position(station_27).title("JOHN STREET WEST"))
        map.addMarker(MarkerOptions().position(station_28).title("FENIAN STREET"))
        map.addMarker(MarkerOptions().position(station_29).title("MERRION SQUARE SOUTH"))
        map.addMarker(MarkerOptions().position(station_30).title("SOUTH DOCK ROAD"))
        map.addMarker(MarkerOptions().position(station_31).title("CITY QUAY"))
        map.addMarker(MarkerOptions().position(station_32).title("EXCHEQUER STREET"))
        map.addMarker(MarkerOptions().position(station_33).title("THE POINT"))
        map.addMarker(MarkerOptions().position(station_34).title("BROADSTONE"))
        map.addMarker(MarkerOptions().position(station_35).title("HATCH STREET"))
        map.addMarker(MarkerOptions().position(station_36).title("LIME STREET"))
        map.addMarker(MarkerOptions().position(station_37).title("CHARLEMONT PLACE"))
        map.addMarker(MarkerOptions().position(station_38).title("KILMAINHAM GAOL"))
        map.addMarker(MarkerOptions().position(station_39).title("HARDWICKE PLACE"))
        map.addMarker(MarkerOptions().position(station_40).title("WOLFE TONE STREET"))
        map.addMarker(MarkerOptions().position(station_41).title("FRANCIS STREET"))
        map.addMarker(MarkerOptions().position(station_42).title("GREEK STREET"))
        map.addMarker(MarkerOptions().position(station_43).title("GUILD STREET"))
        map.addMarker(MarkerOptions().position(station_44).title("HERBERT PLACE"))
        map.addMarker(MarkerOptions().position(station_45).title("HIGH STREET"))

        setMapLongClick(map)
        setPoiClick(map)
        enableMyLocation()


    }


//    fun fetchJson() {
//        println("Attempting to Fetch JSON")
//
//        val url = "https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=bf9524e96a1c70d571efc99d5318c526ce6848b0"
//
//        val request = Request.Builder().url(url).build()
//
//        val client = OkHttpClient()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onResponse(call: Call, response: Response) {
//                val body = response.body?.string()
//                println(body)
//
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//                println("Failed to execute request")
//            }
//
//        })
//    }





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



