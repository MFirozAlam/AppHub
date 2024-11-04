package com.example.apphub.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun NewsScreen(viewModel: NavHostController = viewModel()) {
    val newsArticles = viewModel.newsArticles.collectAsState().value

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(newsArticles) { article ->
            Text(text = article.title, style = MaterialTheme.typography.titleMedium)
            Text(
                text = "by ${article.author ?: "Unknown"} on ${article.publishedAt}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = article.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
