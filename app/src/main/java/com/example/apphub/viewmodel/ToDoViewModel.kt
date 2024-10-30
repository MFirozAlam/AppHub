package com.example.apphub.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {
    // List of to-do items
    val todoItems = mutableStateListOf<String>()

    // Function to add a new item
    fun addItem(item: String) {
        if (item.isNotBlank()) todoItems.add(item)
    }

    // Function to remove an item
    fun removeItem(item: String) {
        todoItems.remove(item)
    }
}
