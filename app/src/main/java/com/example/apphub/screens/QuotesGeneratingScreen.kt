package com.example.apphub.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun QuotesGeneratingScreen(navController: NavHostController) {
    val quotes = listOf(
        "Believe in yourself!",
        "You are stronger than you think.",
        "Stay positive, work hard, make it happen."
    )
    var quote by remember { mutableStateOf(quotes.random()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Quote of the Day")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = quote, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { quote = quotes.random() }) {
            Text("Generate New Quote")
        }
    }
}
