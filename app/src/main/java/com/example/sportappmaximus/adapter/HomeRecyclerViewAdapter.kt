package com.example.sportappmaximus.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import com.example.sportappmaximus.model.ExerciseModel
import kotlinx.android.synthetic.main.item_home_recycler.view.*

class HomeRecyclerViewAdapter(
    private var dataList: MutableList<ExerciseModel>,
    private val clickListener: (position: Int, exercise: ExerciseModel) -> Unit
) : RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>() {

    @Suppress("MemberVisibilityCanBePrivate")
    inner class HomeViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        init {
            root.setOnClickListener {
                clickListener(adapterPosition, dataList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val root =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_recycler, parent, false)
        return HomeViewHolder(root)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val exerciseModel = dataList[position]
        holder.root.iv_s.setImageBitmap(exerciseModel.image)
        holder.root.tv_title.text = exerciseModel.text
    }
}