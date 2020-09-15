package com.example.sportappmaximus.ui.chat

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.api.load
import coil.transform.CircleCropTransformation
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_coach_account.*

class TrainerInfoFragment : Fragment(R.layout.fragment_coach_account) {

    override fun onStart() {
        super.onStart()
        avatarImageView.load(R.drawable.t1) {
            transformations(CircleCropTransformation())
        }

        imageCoach11.setOnClickListener {
            findNavController().navigate(
                R.id.action_trainer_info_fragment_to_chat_window_fragment
            )
        }
    }
}