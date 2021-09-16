package com.example.moneysaver.ui.signUp

import androidx.lifecycle.ViewModel
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.repostories.ClientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private  val repository: ClientRepository
):ViewModel() {
    fun upsert(item:ClientModelClass)= CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)}
    fun checkClient(username:String,password:String)=  repository.checkClient(username,password)


    //fun delete(item:ClientModelClass)= CoroutineScope(Dispatchers.Main).launch{
            //repository.delete(item)}



}


