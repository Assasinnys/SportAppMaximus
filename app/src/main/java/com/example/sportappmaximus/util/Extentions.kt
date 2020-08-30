package com.example.sportappmaximus.util

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.MainActivity
import com.example.sportappmaximus.R
import com.example.sportappmaximus.adapter.ChatRecyclerViewAdapter
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_chat_window.*

fun Fragment.mainActivity() = requireActivity() as MainActivity

fun Fragment.chatAdapter() = rv_chat_window.adapter as ChatRecyclerViewAdapter

fun RecyclerView.Adapter<*>.lastItem() = itemCount.minus(1)

fun Fragment.areFieldsValid(viewList: List<TextInputLayout>): Boolean {
    var isValid = true

    viewList.forEach {
        if (it.editText?.text.toString().isEmpty()) {
            isValid = false
            it.apply {
                isErrorEnabled = true
                error = getString(R.string.err_empty_field)
            }
        } else {
            it.isErrorEnabled = false
        }
    }

    return isValid
}