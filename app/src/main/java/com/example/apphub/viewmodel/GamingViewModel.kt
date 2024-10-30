package com.example.apphub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apphub.screens.GameType

class GamingViewModel : ViewModel() {

    // LiveData to keep track of the selected game
    private val _gameSelected = MutableLiveData<GameType?>(null)
    val gameSelected: LiveData<GameType?> get() = _gameSelected

    // Function to select a game
    fun selectGame(gameType: GameType) {
        _gameSelected.value = gameType
    }

    // Function to reset the selection
    fun resetSelection() {
        _gameSelected.value = null
    }
}
