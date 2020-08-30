package com.example.sportappmaximus.ui.authorization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_registration_main.*

class RegistrationMainFragment : Fragment(R.layout.fragment_registration_main) {

    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        img_btn_trainer.setOnClickListener {
            navController.navigate(R.id.action_registration_main_fragment_to_registration_trainer_fragment)
        }
        img_btn_user.setOnClickListener {
            navController.navigate(R.id.action_registration_main_fragment_to_registration_user_fragment)
        }
    }
}