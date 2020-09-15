package com.example.sportappmaximus.ui.progress

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_calculator.*

class CalculationFragment : Fragment(R.layout.fragment_calculator) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonSave.setOnClickListener {
            findNavController().navigate(R.id.action_calculationFragment_to_progress_screen_fragment)
        }
        buttonDell.setOnClickListener {
            editCalculator4.setText("")
            editCalculator2.setText("")
            editCalculator3.setText("")
            editCalculator1.setText("")
        }
    }
}