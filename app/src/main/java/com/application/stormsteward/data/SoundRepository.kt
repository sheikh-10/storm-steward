package com.application.stormsteward.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


interface SoundRepository {

    val isSoundOn: Flow<Boolean>
    suspend fun saveSoundState(isSoundOn: Boolean)
}

class SoundRepositoryImp(private val dataStore: DataStore<Preferences>): SoundRepository {
    private companion object {
        val IS_SOUND_ON = booleanPreferencesKey("is_sound_on")
        val TAG = "SoundRepository"
    }

    override val isSoundOn: Flow<Boolean> = dataStore.data
        .catch {
            if(it is IOException) {
                Log.e(TAG, "Error reading preferences.", it)
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map { it[IS_SOUND_ON] ?: true }

    override suspend fun saveSoundState(isSoundOn: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_SOUND_ON] = isSoundOn
        }
    }
}

