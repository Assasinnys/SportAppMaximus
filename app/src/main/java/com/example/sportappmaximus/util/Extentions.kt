package com.example.sportappmaximus.util

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.MainActivity
import com.example.sportappmaximus.adapter.ChatRecyclerViewAdapter

fun Fragment.mainActivity() = requireActivity() as MainActivity

fun RecyclerView.chatAdapter() = adapter as ChatRecyclerViewAdapter