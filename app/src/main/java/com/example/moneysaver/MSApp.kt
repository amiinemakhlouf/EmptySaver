package com.example.moneysaver

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi

@HiltAndroidApp
class MSApp:Application() {

    override fun onCreate() {
        super.onCreate()
    }

}