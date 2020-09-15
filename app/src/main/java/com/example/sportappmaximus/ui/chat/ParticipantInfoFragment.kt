package com.example.sportappmaximus.ui.chat

import androidx.fragment.app.Fragment
import coil.api.load
import coil.transform.CircleCropTransformation
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_member_account.*

class ParticipantInfoFragment : Fragment(R.layout.fragment_member_account) {

    override fun onStart() {
        super.onStart()
        avatarImageView.load(R.drawable.p1) {
            transformations(CircleCropTransformation())
        }
    }
}