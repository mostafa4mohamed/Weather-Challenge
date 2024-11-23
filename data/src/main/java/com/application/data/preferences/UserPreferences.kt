package com.application.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(
    private val dataStore: DataStore<Preferences>
) {

    val lastCityName: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[LAST_CITY]
        }


    suspend fun saveLastCityName(cityName: String?) {
        dataStore.edit { preferences ->
            preferences[LAST_CITY] = cityName ?: ""
        }
    }



    companion object {
        const val PREFERENCES_STORE_NAME = "w_store"
        private val LAST_CITY = stringPreferencesKey("last_city")
    }
}