package com.busra.selfcareapp.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

class UserSettingsManager(private val context: Context) {

    private val dataStore = context.dataStore
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_settings")
        val CHECKBOX_KEY = booleanPreferencesKey("checkbox_key")
    }

    val getCheckboxValueFlow: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[CHECKBOX_KEY] ?: false
    }
    suspend fun setCheckboxValue(value: Boolean) {
        dataStore.edit { preferences ->
            preferences[CHECKBOX_KEY] = value
        }
    }
}