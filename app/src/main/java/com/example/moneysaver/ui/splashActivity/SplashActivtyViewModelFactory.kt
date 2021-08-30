package com.example.moneysaver.ui.splashActivity

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.ui.mainfragment.MainFragmentViewModel

class SplashActivtyViewModelFactory ( private val context: Activity): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashActivityViewModel( context) as T
    }
}