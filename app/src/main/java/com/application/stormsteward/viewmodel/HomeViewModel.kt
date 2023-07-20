package com.application.stormsteward.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.application.stormsteward.StormStewardApplication
import com.application.stormsteward.data.SoundRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class HomeUiState(val isSoundOn: Boolean = true)
class HomeViewModel(private val soundRepository: SoundRepository): ViewModel() {

    val uiState: StateFlow<HomeUiState> =
        soundRepository.isSoundOn.map { isLinearLayout ->
            HomeUiState(isLinearLayout)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = HomeUiState()
            )

    fun changeSoundState(soundState: Boolean) = viewModelScope.launch {
        soundRepository.saveSoundState(soundState)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as StormStewardApplication)
                HomeViewModel(application.container.soundRepository)
            }
        }
    }
}