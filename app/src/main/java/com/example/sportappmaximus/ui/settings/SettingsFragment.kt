package com.example.sportappmaximus.ui.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.URL_VERIFICATION
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_confirm.setOnClickListener {
            val browseIntent = Intent(Intent.ACTION_VIEW)
            browseIntent.data = Uri.parse(URL_VERIFICATION)
            if (browseIntent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(browseIntent)
            }
        }
    }
}