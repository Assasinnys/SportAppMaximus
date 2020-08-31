package com.example.sportappmaximus.ui.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_list_participants.*

class ParticipantsChatListWindowFragment : Fragment(R.layout.fragment_list_participants) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageParticipants1.setOnClickListener {
            findNavController().navigate(
                R.id.action_participantChatScreenFragment_to_participantChatWidowFragment
            )
        }

        btn_chat_participants.setOnClickListener {
            findNavController().navigate(
                R.id.action_participantChatScreenFragment_to_chat_window_fragment
            )
        }
    }
}