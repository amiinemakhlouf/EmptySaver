package com.example.moneysaver.ui.mainActivity

import androidx.lifecycle.ViewModel
import com.example.moneysaver.repostories.ClientRepository

class MainActivityViewModel (private  val repository: ClientRepository
): ViewModel() {

    fun getCurrentUserData(userId:Int)=repository.getCurrentUserData(userId)
   // fun checkUser(username:String,password:String)=repository.checkClient(username,password)


}