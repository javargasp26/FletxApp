package com.example.fletxapp.ui.map_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fletxapp.R
import com.example.fletxapp.databinding.ActivityMapBinding
import com.example.fletxapp.domain.Model
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMapBinding
    private lateinit var map: GoogleMap
    private lateinit var dataModel:Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        dataModel = intent.getSerializableExtra("model") as Model
        createMapFragment()
    }

    private fun createMapFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun createMarker() {
        val marker = LatLng(dataModel.lat,dataModel.lng)
        val info = "Placa: " + dataModel.licensePlate + ", Conductor: " + dataModel.driverName + " Trailer:" + dataModel.trailerLicensePlate
        map.addMarker(MarkerOptions().position(marker).title(info))
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(marker, 18f),
            4000,
            null
        )
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }
}