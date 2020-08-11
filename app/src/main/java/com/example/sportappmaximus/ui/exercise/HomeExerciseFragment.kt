package com.example.sportappmaximus.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sportappmaximus.R
import com.example.sportappmaximus.model.ExerciseModel
import com.example.sportappmaximus.util.EXERCISE_KEY
import com.example.sportappmaximus.util.mainActivity
import kotlinx.android.synthetic.main.fragment_home_exercise.*

class HomeExerciseFragment : Fragment(R.layout.fragment_home_exercise) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity().hideNavigationBar()

        val exerciseModel: ExerciseModel = arguments?.get(EXERCISE_KEY) as ExerciseModel

        iv_home_ex1.setImageBitmap(exerciseModel.image)
        tv_home_ex1.text = exerciseModel.text
        iv_home_ex2.setImageBitmap(exerciseModel.image)
        tv_home_ex2.text = exerciseModel.text
        iv_home_ex3.setImageBitmap(exerciseModel.image)
        tv_home_ex3.text = exerciseModel.text
        iv_home_ex4.setImageBitmap(exerciseModel.image)
        tv_home_ex4.text = exerciseModel.text
        iv_home_ex5.setImageBitmap(exerciseModel.image)
        tv_home_ex5.text = exerciseModel.text
    }
}