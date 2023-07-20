package com.application.stormsteward.ui

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.application.stormsteward.viewmodel.HomeViewModel
import kotlinx.coroutines.delay

private const val TAG = "StormStewardApp"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StormStewardApp(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)) {
    var screenState by remember { mutableStateOf(Screen.LoadingScreen) }
    val navController: NavHostController = rememberNavController()

    val homeUiState by homeViewModel.uiState.collectAsState()

    Log.d(TAG, homeUiState.isSoundOn.toString())

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
                        HomeScreen(
                            onPlayClick = { navController.navigate(Screen.GameScreen.name) },
                            soundState = homeUiState.isSoundOn,
                            onSoundClick = { homeViewModel.changeSoundState(homeUiState.isSoundOn.not()) }
                            )
                    }

                    composable(route = Screen.GameScreen.name) {
                        GameScreen()
                    }

                    composable(route = Screen.GameOverScreen.name) {
                        GameOverScreen()
                    }
                }
            }
        }
    }
}

enum class Screen {
    LoadingScreen,
    HomeScreen,
    GameScreen,
    GameOverScreen
}