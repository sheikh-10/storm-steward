package com.application.stormsteward.container

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.application.stormsteward.data.SoundRepository
import com.application.stormsteward.data.SoundRepositoryImp

interface AppContainer {
    val soundRepository: SoundRepository
}

class DefaultAppContainer(private val dataStore: DataStore<Preferences>): AppContainer {
    override val soundRepository: SoundRepository by lazy {
        SoundRepositoryImp(dataStore)
    }
}