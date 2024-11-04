package com.example.apphub.model

// NewsResponse.kt
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val title: String,
    val author: String?,
    val description: String,
    val url: String,
    val publishedAt: String
)
