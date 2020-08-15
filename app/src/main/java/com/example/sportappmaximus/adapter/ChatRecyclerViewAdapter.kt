package com.example.sportappmaximus.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import kotlinx.android.synthetic.main.item_chat_window_recycler.view.*

class ChatRecyclerViewAdapter(private var chatList: List<Pair<String, String>> = emptyList()) :
    RecyclerView.Adapter<ChatRecyclerViewAdapter.ChatViewHolder>() {

    class ChatViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(data: Pair<String, String>) {
            root.tv_nickname.text = data.first
            root.tv_message.text = data.second
        }
    }

    fun setData(newChatList: List<Pair<String, String>>) {
        chatList = newChatList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_window_recycler, parent, false)
        return ChatViewHolder(root)
    }

    override fun getItemCount() = chatList.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(chatList[position])
    }
}