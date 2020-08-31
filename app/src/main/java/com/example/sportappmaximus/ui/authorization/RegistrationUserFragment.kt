package com.example.sportappmaximus.ui.authorization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.areFieldsValid
import com.example.sportappmaximus.util.isPasswordsEquals
import kotlinx.android.synthetic.main.fragment_registration_user.*

class RegistrationUserFragment : Fragment(R.layout.fragment_registration_user) {

    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_sign_up.setOnClickListener {
            if (areFieldsValid(
                    listOf(
                        tf_input_name,
                        tf_input_age,
                        tf_input_gender,
                        tf_input_pass,
                        tf_input_pass_conf
                    )
                ) && isPasswordsEquals(tf_input_pass, tf_input_pass_conf)
            )
                navController.navigate(R.id.action_registration_user_fragment_to_navigation_home)
        }
    }

    override fun onPause() {
        container_registration_user.clearFocus()
        super.onPause()
    }
}