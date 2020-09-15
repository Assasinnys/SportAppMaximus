package com.example.sportappmaximus.ui.progress

import android.app.Application
import android.location.Location
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.*
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.isLocationPermissionGranted
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task

@Suppress("MemberVisibilityCanBePrivate")
class MapViewModel(
    val appContext: Application
) : AndroidViewModel(appContext), DefaultLifecycleObserver,
    OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mFusedLocationProviderClient: FusedLocationProviderClient
    private var mLastKnownLocation: Location? = null

    private val isGpsPermissionGranted = MutableLiveData(false)
    val gpsPermissionState: LiveData<Boolean> get() = isGpsPermissionGranted

    override fun onCreate(owner: LifecycleOwner) {
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(appContext)
        if (appContext.applicationContext.isLocationPermissionGranted()) {
            isGpsPermissionGranted.value = true
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        googleMap.setOnMapClickListener {
            googleMap.addMarker(MarkerOptions().apply {
                draggable(true)
                position(it)
            })
        }
        val mapStyle =
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                R.raw.style_json_n
            else
                R.raw.style_json
        googleMap.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                appContext,
                mapStyle
            )
        )
        updateLocationUI()
        getDeviceLocation()
        if (mLastKnownLocation != null) mMap.moveCamera(CameraUpdateFactory.newLatLng(getLatLng()))
    }

    private fun getDeviceLocation() {
        try {
            val locationResult: Task<Location> = mFusedLocationProviderClient.lastLocation
            locationResult.addOnCompleteListener { p0 ->
                if (p0.isSuccessful) {
                    mLastKnownLocation = p0.result?.also {
                        mMap.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    it.latitude,
                                    it.longitude
                                ), 14F
                            )
                        )
                    }
                } else {
                    Log.d("kj", "Current location is null. Using defaults.")
                    Log.e("kj", "Exception: %s", p0.exception)
                    mMap.uiSettings.isMyLocationButtonEnabled = false
                }
            }
        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message ?: "")
        }
    }

    private fun updateLocationUI() {
        try {
            if (isGpsPermissionGranted.value!!) {
                mMap.isMyLocationEnabled = true
                mMap.uiSettings.isMyLocationButtonEnabled = true
            } else {
                mMap.isMyLocationEnabled = false
                mMap.uiSettings.isMyLocationButtonEnabled = false
            }
        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message!!)
        }
    }

    private fun getLatLng() = LatLng(mLastKnownLocation!!.latitude, mLastKnownLocation!!.longitude)
}