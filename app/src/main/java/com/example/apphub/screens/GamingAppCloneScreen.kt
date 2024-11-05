package com.example.apphub.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random
import androidx.compose.material3.Button

@Composable
fun GamingAppCloneScreen(navController: NavHostController) {
    var gameSelected by remember { mutableStateOf<GameType?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Welcome to the Gaming App Clone!", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        when (gameSelected) {
            GameType.LUDO -> LudoGameUI { gameSelected = null }
            GameType.TIC_TAC_TOE -> TicTacToeUI { gameSelected = null }
            GameType.PUZZLE -> PuzzleGameUI { gameSelected = null }
            null -> {
                // Default UI for selecting a game
                GameButton("Ludo") { gameSelected = GameType.LUDO }
                Spacer(modifier = Modifier.height(16.dp))
                GameButton("Tic Tac Toe") { gameSelected = GameType.TIC_TAC_TOE }
                Spacer(modifier = Modifier.height(16.dp))
                GameButton("Puzzle Game") { gameSelected = GameType.PUZZLE }
            }
        }
    }
}
@Composable
fun GameButton(gameName: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = gameName, style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun LudoGameUI(onBack: () -> Unit) {
    // Game state variables
    var diceRoll by remember { mutableStateOf(1) }
    var playerPosition by remember { mutableStateOf(0) }
    val boardSize = 10 // Board length for a simplified board layout

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ludo Game", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        // Basic Board Layout
        LudoBoard(boardSize = boardSize, playerPosition = playerPosition)

        Spacer(modifier = Modifier.height(16.dp))

        // Player Position Display
        Text("Player Position: $playerPosition", style = MaterialTheme.typography.bodyMedium)

        // Dice Roll UI
        Dice(diceRoll) {
            diceRoll = Random.nextInt(1, 7) // Roll a dice from 1 to 6
            playerPosition = (playerPosition + diceRoll) % boardSize // Move player position with wrap-around
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBack) { Text("Back") }
    }
}

@Composable
fun LudoBoard(boardSize: Int, playerPosition: Int) {
    // Display a 1D board layout with boardSize cells
    Row(modifier = Modifier.wrapContentWidth()) {
        for (i in 0 until boardSize) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .padding(2.dp)
                    .background(if (i == playerPosition) Color.Red else Color.LightGray), // Highlight player position
                contentAlignment = Alignment.Center
            ) {
                Text(text = i.toString(), style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun Dice(currentRoll: Int, onRoll: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Dice Roll: $currentRoll", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onRoll, modifier = Modifier.size(100.dp), shape = CircleShape) {
            Text("Roll", style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
fun TicTacToeUI(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tic Tac Toe", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        // Tic Tac Toe board layout
        for (row in 1..3) {
            Row(horizontalArrangement = Arrangement.Center) {
                for (col in 1..3) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .padding(4.dp)
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "", style = MaterialTheme.typography.headlineMedium)
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
        Button(onClick = onBack) { Text("Back") }
    }
}

@Composable
fun PuzzleGameUI(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Puzzle Game", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        // Placeholder for puzzle grid
        Row(horizontalArrangement = Arrangement.Center) {
            for (i in 1..4) {
                Column {
                    for (j in 1..4) {
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(4.dp)
                                .background(Color.Blue),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "$i$j", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
        Button(onClick = onBack) { Text("Back") }
    }
}

enum class GameType {
    LUDO, TIC_TAC_TOE, PUZZLE
}
