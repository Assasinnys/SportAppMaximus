package com.example.sportappmaximus.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import com.example.sportappmaximus.model.ProductModel
import kotlinx.android.synthetic.main.item_goods.view.*

class GoodsRecyclerAdapter(var productList: MutableList<ProductModel> = mutableListOf()) :
    RecyclerView.Adapter<GoodsRecyclerAdapter.GoodsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item_goods, parent, false)
        return GoodsViewHolder(root)
    }

    fun setData(newList: MutableList<ProductModel>) {
        productList = newList
        notifyDataSetChanged()
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    class GoodsViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

        @SuppressLint("SetTextI18n")
        fun bind(productModel: ProductModel) {
            root.apply {
                tv_title_product.text = productModel.name
                tv_description_product.text = productModel.description
                tv_cost.text = "${productModel.cost} BYN"
            }
        }
    }
}