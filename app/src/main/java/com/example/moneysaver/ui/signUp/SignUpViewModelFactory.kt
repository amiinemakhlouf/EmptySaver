package com.example.moneysaver.ui.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.repostories.MoneySaverRepository

class SignUpViewModelFactory (private val repository: MoneySaverRepository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel( repository) as T
    }
}



