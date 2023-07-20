package com.application.stormsteward

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.application.stormsteward.ui.theme.StormStewardTheme
import android.media.MediaPlayer
import androidx.activity.viewModels
import androidx.lifecycle.coroutineScope
import com.application.stormsteward.viewmodel.HomeViewModel
import kotlinx.coroutines.launch
import com.application.stormsteward.viewmodel.HomeViewModel.Companion
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val viewModel: HomeViewModel by viewModels(factoryProducer = { HomeViewModel.Factory })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StormStewardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    com.application.stormsteward.ui.StormStewardApp()
                }
            }
        }
    }

    private fun startMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.bg)
        mediaPlayer?.let {
            it.isLooping = true
            it.setVolume(100f, 100f)

            if (!it.isPlaying) {
                it.start()
            }
        }
    }

    private fun stopMediaPlayer() {
        mediaPlayer?.let {
                it.stop()
                it.release()
            }
    }

    override fun onStart() {
        super.onStart()
        lifecycle.coroutineScope.launch {
            delay(1_000L)
            viewModel.uiState.collect {
                if (it.isSoundOn) {
                    startMediaPlayer()
                } else {
                    stopMediaPlayer()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        stopMediaPlayer()
    }
}