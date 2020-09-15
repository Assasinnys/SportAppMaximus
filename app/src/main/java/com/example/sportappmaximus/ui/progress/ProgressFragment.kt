package com.example.sportappmaximus.ui.progress

import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_progress.*

class ProgressFragment : Fragment(R.layout.fragment_progress) {

    private val progressViewModel: ProgressViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv_stats.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_progress_to_progress_screen_fragment)
        }
        btn_share.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.putExtra(EXTRA_TEXT, "This is a test message")
            sendIntent.type = "text/plain"
            if (sendIntent.resolveActivity(requireContext().packageManager) != null)
                startActivity(sendIntent)
        }
        btn_add_result.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_progress_to_calculationFragment)
        }
    }
}