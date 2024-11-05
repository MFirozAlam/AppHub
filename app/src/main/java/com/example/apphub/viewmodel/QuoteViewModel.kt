// QuotesViewModel.kt
package com.example.apphub.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apphub.model.Quote

class QuotesViewModel : ViewModel() {
    val quotesList = listOf(
        Quote("Be yourself; everyone else is already taken.", "Oscar Wilde"),
        Quote("Two things are infinite: the universe and human stupidity.", "Albert Einstein")
    )
}
