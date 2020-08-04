package com.example.sportappmaximus.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sportappmaximus.R
import com.example.sportappmaximus.model.ExerciseModel
import com.example.sportappmaximus.util.EXERCISE_KEY
import kotlinx.android.synthetic.main.fragment_home_exercise.*

class HomeExerciseFragment : Fragment(R.layout.fragment_home_exercise) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exerciseModel: ExerciseModel = arguments?.get(EXERCISE_KEY) as ExerciseModel

        iv_s2.setImageBitmap(exerciseModel.image)
        tv_home_details.text = exerciseModel.text
    }
}