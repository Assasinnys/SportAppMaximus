package com.example.sportappmaximus.ui.store

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.fragment_store.*

class StoreFragment : Fragment(R.layout.fragment_store) {

    private val storeViewModel: StoreViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeViewModel.text.observe(viewLifecycleOwner, Observer {
            tv_title_hot_goods.text = it
        })
    }

}