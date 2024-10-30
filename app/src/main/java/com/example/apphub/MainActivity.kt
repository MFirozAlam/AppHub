package com.example.apphub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.apphub.navigation.AppNavigation
import com.example.apphub.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enable edge-to-edge layout
        setContent {
            MyAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppScaffold(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppScaffold(modifier: Modifier = Modifier) {
    val navController = rememberNavController() // NavController for handling navigation
    AppNavigation(navController = navController, modifier = modifier) // Setup navigation
}

@Preview(showBackground = true)
@Composable
fun AppScaffoldPreview() {
    MyAppTheme {
        Scaffold {
            AppScaffold(modifier = Modifier.padding(it))
        }
    }
}