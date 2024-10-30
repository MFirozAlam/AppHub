package com.example.apphub.model

data class Game(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String = "",     // Optional field for an image URL
    var isFavorite: Boolean = false // Field to track if a game is marked as favorite
)
