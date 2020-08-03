package com.example.sportappmaximus.ui.progress

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_progress.*

class ProgressFragment : Fragment(R.layout.fragment_progress) {

    private val progressViewModel: ProgressViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressViewModel.text.observe(viewLifecycleOwner, Observer {
            tv_progress.text = it
        })
    }
}