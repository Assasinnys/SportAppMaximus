package com.example.sportappmaximus.ui.chat

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.NAME
import com.example.sportappmaximus.util.SURNAME
import kotlinx.android.synthetic.main.fragment_list_participants.*

class ParticipantsChatListFragment : Fragment(R.layout.fragment_list_participants) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageParticipants1.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_participant_chat_widow_fragment
            )
        }

        btn_chat_participants.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_chat_window_fragment
            )
        }

        p1.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameParticipants.text, SURNAME to surnameParticipants.text)
            )
        }
        p2.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameParticipants2.text, SURNAME to surnameParticipants2.text)
            )
        }
        p3.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameParticipants3.text, SURNAME to surnameParticipants3.text)
            )
        }
        p4.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameParticipants4.text, SURNAME to surnameParticipants4.text)
            )
        }
        p5.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameParticipants5.text, SURNAME to surnameParticipants5.text)
            )
        }
        p6.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameParticipants6.text, SURNAME to surnameParticipants6.text)
            )
        }
        p7.setOnClickListener {
            findNavController().navigate(
                R.id.action_participant_chat_screen_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameParticipants7.text, SURNAME to surnameParticipants7.text)
            )
        }
    }
}