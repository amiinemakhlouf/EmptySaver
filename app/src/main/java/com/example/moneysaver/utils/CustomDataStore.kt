package com.example.moneysaver.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.example.moneysaver.R
import kotlinx.coroutines.flow.first

class CustomDataStore(context: Context) {
     private val dataStore=context.createDataStore(R.string.settings.toString())

     suspend fun read(key: String): Int? {
        val dataStoreKey = preferencesKey<Int>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

     suspend fun saveInt(key: String, value: Int) {
        val dataStoreKey = preferencesKey<Int>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
    private suspend fun saveDouble(key: String, value: Double) {
        val dataStoreKey = preferencesKey<Double>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
    private suspend fun saveString(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }






}