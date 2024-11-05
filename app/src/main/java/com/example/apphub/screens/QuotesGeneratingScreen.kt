// In QuotesGeneratingScreen.kt
package com.example.apphub.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apphub.viewmodel.QuotesViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuotesGeneratingScreen(viewModel: QuotesViewModel = viewModel()) {
    Column(modifier = Modifier.padding(16.dp)) {
        viewModel.quotesList.forEach { quote ->
            Text(text = "\"${quote.text}\"", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "- ${quote.author}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
