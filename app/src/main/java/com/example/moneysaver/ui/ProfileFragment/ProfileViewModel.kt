package com.example.moneysaver.ui.ProfileFragment

import androidx.lifecycle.ViewModel
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.repostories.ClientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor ( private  val repository: ClientRepository
): ViewModel() {

    fun   getCurrentUserData(userId:Int)=repository.getCurrentUserData(userId)
       fun upsert(item: ClientModelClass)= CoroutineScope(Dispatchers.Main).launch{
           repository.upsert(item)
       }



}