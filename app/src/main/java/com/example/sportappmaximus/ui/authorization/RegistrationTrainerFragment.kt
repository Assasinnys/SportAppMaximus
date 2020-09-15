package com.example.sportappmaximus.ui.authorization

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import com.example.sportappmaximus.util.URL_VERIFICATION
import com.example.sportappmaximus.util.areFieldsValid
import com.example.sportappmaximus.util.isPasswordsEquals
import kotlinx.android.synthetic.main.fragment_registration_trainer.*

class RegistrationTrainerFragment : Fragment(R.layout.fragment_registration_trainer) {

    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_sign_up_trainer.setOnClickListener {
            if (areFieldsValid(
                    listOf(
                        tf_input_name_trainer,
                        tf_input_age_trainer,
                        tf_input_gender_trainer,
                        tf_input_pass_trainer,
                        tf_input_pass_conf_trainer
                    )
                ) && isPasswordsEquals(tf_input_pass_trainer, tf_input_pass_conf_trainer)
            )
                navController.navigate(R.id.action_registration_trainer_fragment_to_navigation_home)
        }

        btn_confirm.setOnClickListener {
            val browseIntent = Intent(Intent.ACTION_VIEW)
            browseIntent.data = Uri.parse(URL_VERIFICATION)
            if (browseIntent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(browseIntent)
            }
        }
    }

    override fun onPause() {
        container_registration_trainer.clearFocus()
        super.onPause()
    }
}