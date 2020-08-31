package com.example.sportappmaximus.ui.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_choosing_coach.*
import kotlinx.android.synthetic.main.fragment_list_participants.*
import kotlinx.android.synthetic.main.fragment_list_participants.imageParticipants1

class TrainersChatListWindowScreen : Fragment(R.layout.fragment_choosing_coach) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageCoach1.setOnClickListener {
            findNavController().navigate(
                R.id.action_trainersChatListWindowScreen_to_trainerChatWindowScreen
            )
        }
    }
}