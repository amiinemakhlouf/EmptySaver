package com.example.moneysaver.ui.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.repostories.MoneySaverRepository
import com.example.moneysaver.ui.signUp.SignUpViewModel

class SignInViewModelFactory (private val repository: MoneySaverRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignInViewModel( repository) as T
    }
}