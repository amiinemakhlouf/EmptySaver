package com.example.moneysaver.ui.ProfileFragment

import androidx.lifecycle.ViewModel
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.repostories.ClientRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel( private  val repository: ClientRepository
): ViewModel() {

    fun   getCurrentUserData(userId:Int)=repository.getCurrentUserData(userId)
       fun upsert(item: ClientModelClass)= CoroutineScope(Dispatchers.Main).launch{
           repository.upsert(item)
       }



}