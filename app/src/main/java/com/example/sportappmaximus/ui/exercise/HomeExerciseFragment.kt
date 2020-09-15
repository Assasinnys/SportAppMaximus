package com.example.sportappmaximus.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sportappmaximus.R
import com.example.sportappmaximus.model.ExerciseModel
import com.example.sportappmaximus.ui.home.HomeFragment
import com.example.sportappmaximus.util.EXERCISE_KEY
import com.example.sportappmaximus.util.mainActivity
import kotlinx.android.synthetic.main.fragment_home_exercise.*

class HomeExerciseFragment : Fragment(R.layout.fragment_home_exercise) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity().hideNavigationBar()

        val exerciseType: Int = arguments?.getInt(EXERCISE_KEY)?:0

        when(exerciseType) {
            HomeFragment.BACK -> {
                iv_home_ex1.setImageResource(R.drawable.w1_1)
                tv_home_ex1.setText(R.string.w1)
                iv_home_ex2.setImageResource(R.drawable.w1_2)
                tv_home_ex2.setText(R.string.w2)
                iv_home_ex3.setImageResource(R.drawable.w1_3)
                tv_home_ex3.setText(R.string.w33)
                iv_home_ex4.setImageResource(R.drawable.w1_4)
                tv_home_ex4.setText(R.string.w4)
                iv_home_ex5.setImageResource(R.drawable.w1_5)
                tv_home_ex5.setText(R.string.w55)
            }

            HomeFragment.TRICEPS -> {
                iv_home_ex1.setImageResource(R.drawable.w1_3)
                tv_home_ex1.setText(R.string.w11)
                iv_home_ex2.setImageResource(R.drawable.w1_4)
                tv_home_ex2.setText(R.string.w22)
                iv_home_ex3.setImageResource(R.drawable.w1_5)
                tv_home_ex3.setText(R.string.w33)
                iv_home_ex4.setImageResource(R.drawable.w1_6)
                tv_home_ex4.setText(R.string.w4)
                iv_home_ex5.setImageResource(R.drawable.w1_7)
                tv_home_ex5.setText(R.string.w55)
            }

            HomeFragment.LEG -> {
                iv_home_ex1.setImageResource(R.drawable.w1_5)
                tv_home_ex1.setText(R.string.w111)
                iv_home_ex2.setImageResource(R.drawable.w1_6)
                tv_home_ex2.setText(R.string.w222)
                iv_home_ex3.setImageResource(R.drawable.w1_8)
                tv_home_ex3.setText(R.string.w333)
                iv_home_ex4.setImageResource(R.drawable.w1_9)
                tv_home_ex4.setText(R.string.w4)
                iv_home_ex5.setImageResource(R.drawable.w1_10)
                tv_home_ex5.setText(R.string.w55)
            }
        }
    }
}