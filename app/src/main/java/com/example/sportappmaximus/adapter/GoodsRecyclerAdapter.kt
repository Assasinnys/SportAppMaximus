package com.example.sportappmaximus.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import com.example.sportappmaximus.model.GoodsModel
import kotlinx.android.synthetic.main.item_goods.view.*

class GoodsRecyclerAdapter(var goodsList: MutableList<GoodsModel> = mutableListOf()) :
    RecyclerView.Adapter<GoodsRecyclerAdapter.GoodsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item_goods, parent, false)
        return GoodsViewHolder(root)
    }

    fun setData(newList: MutableList<GoodsModel>) {
        goodsList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount() = goodsList.size

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {
        holder.bind(goodsList[position])
    }

    class GoodsViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

        fun bind(goodsModel: GoodsModel) {
            root.apply {
                tv_title_product.text = goodsModel.name
                tv_description_product.text = goodsModel.description
            }
        }
    }
}