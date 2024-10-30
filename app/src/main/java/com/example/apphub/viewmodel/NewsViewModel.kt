package com.example.apphub.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apphub.model.NewsArticle

class NewsViewModel : ViewModel() {
    val newsArticles = listOf(
        NewsArticle("Title 1", "Content 1", "Author 1", "Date 1"),
        NewsArticle("Title 2", "Content 2", "Author 2", "Date 2")
    )
}
