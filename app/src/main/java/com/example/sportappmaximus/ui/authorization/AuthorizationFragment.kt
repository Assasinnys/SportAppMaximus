package com.example.sportappmaximus.ui.authorization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.areFieldsValid
import com.example.sportappmaximus.util.mainActivity
import kotlinx.android.synthetic.main.fragment_authorization.*

class AuthorizationFragment : Fragment(R.layout.fragment_authorization) {

    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainActivity().hideNavigationBar()

        btn_sign_in.setOnClickListener {
            if (areFieldsValid(listOf(tf_input_name, tf_input_pass))) {
                hideSoftKeyboard()
                navController.navigate(R.id.action_authorization_fragment_to_navigation_home)
            }
        }

        btn_register.setOnClickListener {
            hideSoftKeyboard()
            navController.navigate(R.id.action_authorization_fragment_to_registration_main_fragment)
        }
    }

    private fun hideSoftKeyboard() {
        tf_input_name.clearFocus()
        tf_input_pass.clearFocus()
    }
}