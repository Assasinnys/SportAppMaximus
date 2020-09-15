package com.example.sportappmaximus.ui.progress

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.sportappmaximus.R
import com.google.android.gms.maps.SupportMapFragment

class MapFragment : Fragment(R.layout.fragment_map) {

    private val viewModel: MapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        lifecycle.addObserver(viewModel)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViewModelObservers()
        val mapFragment = SupportMapFragment.newInstance()
        childFragmentManager.beginTransaction().replace(R.id.map_container, mapFragment).commit()
        mapFragment.getMapAsync(viewModel)
    }

    private fun setupViewModelObservers() {
        viewModel.gpsPermissionState.observe(viewLifecycleOwner) {
            if (!it) Toast.makeText(
                context,
                R.string.error_gps_permission,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}