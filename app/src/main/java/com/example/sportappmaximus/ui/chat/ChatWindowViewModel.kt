package com.example.sportappmaximus.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatWindowViewModel : ViewModel() {

    private val _text = MutableLiveData<List<Pair<String, String>>>().apply {
        value = listOf("Welcome message" to "Welcome to our chat")
    }
    val text: LiveData<List<Pair<String, String>>> = _text

    fun notifyMessageSent(message: String) {
        if (message.trim().isNotEmpty())
            _text.value = _text.value?.plus(listOf("You" to message))
    }

    fun notifyInfo(name: String, surname: String) {
        _text.value = listOf("Welcome message" to "Welcome to chat with $name $surname")
    }
}