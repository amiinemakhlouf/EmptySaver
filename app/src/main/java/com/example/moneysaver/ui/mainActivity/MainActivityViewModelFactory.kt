package com.example.moneysaver.ui.mainActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.signIn.SignInViewModel

class MainActivityViewModelFactory (private val repository: ClientRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel( repository) as T
    }
}