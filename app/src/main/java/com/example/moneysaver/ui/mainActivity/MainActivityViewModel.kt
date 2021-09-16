package com.example.moneysaver.ui.mainActivity

import androidx.lifecycle.ViewModel
import com.example.moneysaver.repostories.ClientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor (private  val repository: ClientRepository
): ViewModel() {

    fun getCurrentUserData(userId:Int)=repository.getCurrentUserData(userId)
   // fun checkUser(username:String,password:String)=repository.checkClient(username,password)


}