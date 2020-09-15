package com.example.sportappmaximus.ui.chat

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.R
import com.example.sportappmaximus.adapter.ChatRecyclerViewAdapter
import com.example.sportappmaximus.util.*
import kotlinx.android.synthetic.main.fragment_chat_window.*

class ChatWindowFragment : Fragment(R.layout.fragment_chat_window) {

    private val chatWindowViewModel: ChatWindowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.getInt(IS_COACH_KEY, PARTICIPANT) == COACH) {
                setHasOptionsMenu(true)
            }
            val name = it.getString(NAME, "")
            val surname = it.getString(SURNAME, "")
            chatWindowViewModel.notifyInfo(name, surname)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_chat_window, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.pay) {
            // TODO go to payment page
        }
        return super.onOptionsItemSelected(item)
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
