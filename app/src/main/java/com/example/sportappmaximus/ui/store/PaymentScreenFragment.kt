package com.example.sportappmaximus.ui.store

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_payment_screen.*

class PaymentScreenFragment : Fragment(R.layout.fragment_payment_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button3.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}