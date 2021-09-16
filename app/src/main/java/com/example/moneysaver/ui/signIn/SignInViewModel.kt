package com.example.moneysaver.ui.signIn

import androidx.lifecycle.ViewModel
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.repostories.ClientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor (
    private  val repository: ClientRepository
): ViewModel() {

    fun checkClient(username:String,password:String)=  repository.checkClient(username,password)


}