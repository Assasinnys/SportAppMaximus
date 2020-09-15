package com.example.sportappmaximus.ui.chat

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.api.load
import coil.transform.CircleCropTransformation
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.NAME
import com.example.sportappmaximus.util.SURNAME
import kotlinx.android.synthetic.main.fragment_choosing_coach.*

class TrainersChatListFragment : Fragment(R.layout.fragment_choosing_coach) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCoachImages()
        imageCoach1.setOnClickListener {
            findNavController().navigate(
                R.id.action_trainers_chat_list_fragment_to_trainer_info_fragment
            )
        }

        t1.setOnClickListener {
            findNavController().navigate(
                R.id.action_trainers_chat_list_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameCoach.text, SURNAME to surnameCoach.text)
            )
        }
        t2.setOnClickListener {
            findNavController().navigate(
                R.id.action_trainers_chat_list_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameCoach2.text, SURNAME to surnameCoach2.text)
            )
        }
        t3.setOnClickListener {
            findNavController().navigate(
                R.id.action_trainers_chat_list_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameCoach3.text, SURNAME to surnameCoach3.text)
            )
        }
        t4.setOnClickListener {
            findNavController().navigate(
                R.id.action_trainers_chat_list_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameCoach4.text, SURNAME to surnameCoach4.text)
            )
        }
        t5.setOnClickListener {
            findNavController().navigate(
                R.id.action_trainers_chat_list_fragment_to_chat_window_fragment,
                bundleOf(NAME to nameCoach5.text, SURNAME to surnameCoach5.text)
            )
        }
    }

    private fun setupCoachImages() {
        imageCoach1.load(R.drawable.t1) {
            transformations(CircleCropTransformation())
        }
        imageCoach2.load(R.drawable.t2) {
            transformations(CircleCropTransformation())
        }
        imageCoach3.load(R.drawable.t3) {
            transformations(CircleCropTransformation())
        }
        imageCoach4.load(R.drawable.t4) {
            transformations(CircleCropTransformation())
        }
        imageCoach5.load(R.drawable.t5) {
            transformations(CircleCropTransformation())
        }
    }
}