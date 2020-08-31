package com.example.sportappmaximus.ui.chat

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.CHAT_TYPE_KEY
import com.example.sportappmaximus.util.mainActivity
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment(R.layout.fragment_chat) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity().showNavigationBar()

        img_btn_trainer_chat.setOnClickListener {
            findNavController().navigate(
            R.id.action_navigation_chat_to_trainersChatListWindowScreen
            )
        }
        img_btn_user_chat.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_chat_to_participantChatScreenFragment
            )
        }
    }
}