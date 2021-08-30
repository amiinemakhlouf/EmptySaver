package com.example.moneysaver.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.ViewModel
import com.example.moneysaver.R
import com.example.moneysaver.ui.signUp.SignUpViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class CustomDataStore(context: Context) {
     private val dataStore=context.createDataStore(R.string.settings.toString())

     suspend fun readInt(key: String): Int? {
        val dataStoreKey = preferencesKey<Int>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }
    suspend fun readString(key: String): String? {
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }
    suspend fun readDouble(key: String): Double? {
        val dataStoreKey = preferencesKey<Double>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }



    suspend fun saveInt(key: String, value: Int) {
        val dataStoreKey = preferencesKey<Int>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
    suspend fun saveDouble(key: String, value: Double) {
        val dataStoreKey = preferencesKey<Double>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }
     suspend fun saveString(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }



}