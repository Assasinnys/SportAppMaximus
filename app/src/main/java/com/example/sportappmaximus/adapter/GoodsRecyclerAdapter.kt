package com.example.sportappmaximus.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.example.sportappmaximus.R
import com.example.sportappmaximus.model.ProductModel
import kotlinx.android.synthetic.main.item_goods.view.*
import java.util.*

class GoodsRecyclerAdapter(private var productList: MutableList<ProductModel> = mutableListOf()) :
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val imageBytes = Base64.getDecoder().decode(productModel.image)
                    val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                    iv_product.load(bitmap) {
                        transformations(CircleCropTransformation())
                    }
                }
                tv_title_product.text = productModel.name
                tv_description_product.text = productModel.description
                tv_cost.text = "${productModel.cost} BYN"
            }
        }
    }
}