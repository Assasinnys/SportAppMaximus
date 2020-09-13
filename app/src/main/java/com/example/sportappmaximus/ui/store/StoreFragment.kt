package com.example.sportappmaximus.ui.store

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import com.example.sportappmaximus.adapter.GoodsRecyclerAdapter
import com.example.sportappmaximus.util.CATEGORY_EQUIPMENT
import com.example.sportappmaximus.util.CATEGORY_FOOD
import com.example.sportappmaximus.util.CATEGORY_KEY
import kotlinx.android.synthetic.main.fragment_store.*

class StoreFragment : Fragment(R.layout.fragment_store) {

    private val storeViewModel: StoreViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycle.addObserver(storeViewModel)
        setup()
        setupViewModelObservers()
    }

    private fun setup() {
        rv_hot_goods.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = GoodsRecyclerAdapter()
        }

        btn_food.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_store_to_store_goods_list_fragment, bundleOf(
                    CATEGORY_KEY to CATEGORY_FOOD
                )
            )
        }
        btn_equipment.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_store_to_store_goods_list_fragment, bundleOf(
                    CATEGORY_KEY to CATEGORY_EQUIPMENT
                )
            )
        }
    }

    private fun setupViewModelObservers() {
        storeViewModel.apply {
            hotGoods.observe(viewLifecycleOwner) {
                (rv_hot_goods.adapter as GoodsRecyclerAdapter).setData(it)
            }
        }
    }
}
