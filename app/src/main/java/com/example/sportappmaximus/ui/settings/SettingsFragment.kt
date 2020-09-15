package com.example.sportappmaximus.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_confirm.setOnClickListener {
//            val browseIntent = Intent(Intent.ACTION_VIEW)
//            browseIntent.data = Uri.parse(URL_VERIFICATION)
//            if (browseIntent.resolveActivity(requireContext().packageManager) != null) {
//                startActivity(browseIntent)
//            }
            findNavController().navigate(R.id.action_navigation_settings_to_mapFragment)
        }
    }
}