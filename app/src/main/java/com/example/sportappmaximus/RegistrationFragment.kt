package com.example.sportappmaximus

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_registration_main.*

class RegistrationFragment : Fragment(R.layout.fragment_registration_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        img_btn_trainer.setOnClickListener {
            //TODO navigate to trainer registration fragment
        }
        img_btn_user.setOnClickListener {
            //TODO navigate to user registration fragment
        }
    }
}