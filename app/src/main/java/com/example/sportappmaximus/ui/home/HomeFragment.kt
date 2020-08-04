package com.example.sportappmaximus.ui.home

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import com.example.sportappmaximus.adapter.HomeRecyclerViewAdapter
import com.example.sportappmaximus.model.ExerciseModel
import com.example.sportappmaximus.util.EXERCISE_KEY
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_home.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = HomeRecyclerViewAdapter(mutableListOf(
                ExerciseModel(BitmapFactory.decodeResource(resources, R.drawable.kettlebell), "kettlebell"),
                ExerciseModel(BitmapFactory.decodeResource(resources, R.drawable.dumbbell), "dumbbell"),
                ExerciseModel(BitmapFactory.decodeResource(resources, R.drawable.horizontal_bar), "horizontal bar")
            )) { position, exercise ->
                Toast.makeText(context, "Position $position, text: ${exercise.text}", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_navigation_home_to_homeExerciseFragment, bundleOf(
                    EXERCISE_KEY to exercise))
            }
        }
    }
}