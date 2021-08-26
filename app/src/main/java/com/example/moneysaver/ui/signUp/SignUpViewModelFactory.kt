package com.example.moneysaver.ui.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.signIn.SignInViewModel

class SignUpViewModelFactory ( val repository: ClientRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel( repository) as T
    }
}