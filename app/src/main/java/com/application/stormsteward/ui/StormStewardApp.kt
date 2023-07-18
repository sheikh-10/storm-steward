package com.application.stormsteward.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StormStewardApp(modifier: Modifier = Modifier) {
    var screenState by remember { mutableStateOf(Screen.LoadingScreen) }
    val navController: NavHostController = rememberNavController()

    LaunchedEffect(null) {
        delay(3_000L)
        screenState = Screen.HomeScreen
    }

    when (screenState) {
        Screen.LoadingScreen -> {
            LoadingScreen()
        }
        else -> {
            Scaffold() { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.name,
                    modifier = modifier.padding(innerPadding)) {

                    composable(route = Screen.HomeScreen.name) {
                        HomeScreen(onPlayClick = { navController.navigate(Screen.GameScreen.name) })
                    }

                    composable(route = Screen.GameScreen.name) {
                        GameScreen()
                    }
                }
            }
        }
    }
}

enum class Screen {
    LoadingScreen,
    HomeScreen,
    GameScreen
}