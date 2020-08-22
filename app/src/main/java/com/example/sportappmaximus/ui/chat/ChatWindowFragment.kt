package com.example.sportappmaximus.ui.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import com.example.sportappmaximus.adapter.ChatRecyclerViewAdapter
import com.example.sportappmaximus.util.CHAT_TYPE_KEY
import com.example.sportappmaximus.util.chatAdapter
import com.example.sportappmaximus.util.lastItem
import com.example.sportappmaximus.util.mainActivity
import kotlinx.android.synthetic.main.fragment_chat_window.*

class ChatWindowFragment : Fragment(R.layout.fragment_chat_window) {

    private val chatWindowViewModel: ChatWindowViewModel by viewModels()
    private var isTrainerChat: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isTrainerChat = it.getBoolean(CHAT_TYPE_KEY)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainActivity().hideNavigationBar()
        rv_chat_window.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = ChatRecyclerViewAdapter()
        }

        chatWindowViewModel.text.observe(viewLifecycleOwner, Observer {
            chatAdapter().setData(it)
            rv_chat_window.scrollToPosition(chatAdapter().lastItem())
        })

        btn_send.setOnClickListener {
            chatWindowViewModel.notifyMessageSent(et_message.text.toString())
            et_message.setText("")
        }
    }
}
