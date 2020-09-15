package com.example.sportappmaximus.ui.settings

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.URL_VERIFICATION
import kotlinx.android.synthetic.main.fragment_coach_verification.*

class CoachVerificationFragment : Fragment(R.layout.fragment_coach_verification) {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onStart() {
        super.onStart()
        web_verification.apply {
            settings.javaScriptEnabled = true
            loadUrl(URL_VERIFICATION)
        }
    }
}