package com.example.sportappmaximus.ui.home

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
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
import com.example.sportappmaximus.util.mainActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    companion object {
        const val BACK = 0
        const val TRICEPS = 1
        const val LEG = 2
    }


    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_home.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = HomeRecyclerViewAdapter(mutableListOf(
                ExerciseModel(BitmapFactory.decodeResource(resources, R.drawable.w1_1), "Back muscle complex"),
                ExerciseModel(BitmapFactory.decodeResource(resources, R.drawable.w1_3), "Triceps Strengthening Complex"),
                ExerciseModel(BitmapFactory.decodeResource(resources, R.drawable.w1_5), "Complex for the development of leg muscles")
            )) { position, exercise ->
                findNavController().navigate(R.id.action_navigation_home_to_home_exercise_fragment, bundleOf(
                    EXERCISE_KEY to position))
            }
        }
        mainActivity().showNavigationBar()
    }
}