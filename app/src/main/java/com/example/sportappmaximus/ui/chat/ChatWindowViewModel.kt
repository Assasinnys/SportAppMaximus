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
        _text.value = _text.value?.plus(listOf<Pair<String, String>>("You" to message))
    }
}