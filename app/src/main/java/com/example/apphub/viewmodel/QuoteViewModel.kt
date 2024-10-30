package com.example.apphub.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apphub.screens.QuotesGeneratingScreen

class QuotesViewModel : ViewModel() {
    val quotesGeneratingScreens = listOf(
        QuotesGeneratingScreen("Be yourself; everyone else is already taken.", "Oscar Wilde"),
        QuotesGeneratingScreen("Two things are infinite: the universe and human stupidity.", "Albert Einstein")
    )
}
