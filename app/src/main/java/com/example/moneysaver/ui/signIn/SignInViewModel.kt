package com.example.moneysaver.ui.signIn

import androidx.lifecycle.ViewModel
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.repostories.ClientRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel (
    private  val repository: ClientRepository
): ViewModel() {

    fun checkClient(username:String,password:String)=  repository.checkClient(username,password)


}