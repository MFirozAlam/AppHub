// NewsViewModel.kt
package com.example.apphub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apphub.model.Article
import com.example.apphub.network.NewsApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val apiService: NewsApiService) : ViewModel() {
    private val _newsArticles = MutableStateFlow<List<Article>>(emptyList())
    val newsArticles = _newsArticles.asStateFlow()

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            val response = apiService.getTopHeadlines("us", "https://blog.gdeltproject.org/gdelt-2-0-our-global-world-in-realtime/")
            if (response.status == "ok") {
                _newsArticles.value = response.articles
            }
        }
    }
}
