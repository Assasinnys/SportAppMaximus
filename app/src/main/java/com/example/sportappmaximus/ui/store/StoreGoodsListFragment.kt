package com.example.sportappmaximus.ui.store

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import com.example.sportappmaximus.adapter.GoodsRecyclerAdapter
import com.example.sportappmaximus.util.CATEGORY_KEY
import kotlinx.android.synthetic.main.fragment_store_goods_list.*

class StoreGoodsListFragment : Fragment(R.layout.fragment_store_goods_list) {

    private val viewModel: StoreGoodsListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycle.addObserver(viewModel)
        viewModel.notifySelectedCategory(arguments?.getString(CATEGORY_KEY))
        setup()
        setupViewModelObservers()
    }

    private fun setup() {
        rv_goods.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = GoodsRecyclerAdapter()
        }
    }

    private fun setupViewModelObservers() {
        viewModel.apply {
            goodsList.observe(viewLifecycleOwner) {
                (rv_goods.adapter as GoodsRecyclerAdapter).setData(it)
            }
        }
    }
}