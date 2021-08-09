package com.example.moneysaver.ui.clientlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.repostories.MoneySaverMoneySaverRepository

class ClientViewModelFactory (private val repository: MoneySaverMoneySaverRepository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ClientViewModel( repository) as T
    }
}



