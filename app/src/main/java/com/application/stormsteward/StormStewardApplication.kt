package com.application.stormsteward

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.application.stormsteward.container.AppContainer
import com.application.stormsteward.container.DefaultAppContainer

private const val SOUND_PREFERENCE_NAME = "sound_preferences"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = SOUND_PREFERENCE_NAME
)

class StormStewardApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(dataStore)
    }
}