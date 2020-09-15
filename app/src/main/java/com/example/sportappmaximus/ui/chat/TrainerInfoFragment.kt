package com.example.sportappmaximus.ui.chat

import androidx.fragment.app.Fragment
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
    }
}