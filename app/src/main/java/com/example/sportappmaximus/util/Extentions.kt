package com.example.sportappmaximus.util

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.MainActivity
import com.example.sportappmaximus.adapter.ChatRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_chat_window.*

fun Fragment.mainActivity() = requireActivity() as MainActivity

fun Fragment.chatAdapter() = rv_chat_window.adapter as ChatRecyclerViewAdapter

fun RecyclerView.Adapter<*>.lastItem() = itemCount.minus(1)