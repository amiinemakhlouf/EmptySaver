package com.example.moneysaver.ui.signUp

import androidx.lifecycle.ViewModel
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.repostories.MoneySaverRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(
    private  val repository: MoneySaverRepository
):ViewModel() {
    fun upsert(item:ClientModelClass)= CoroutineScope(Dispatchers.Main).launch{
        repository.uspert(item)}


        //fun delete(item:ClientModelClass)= CoroutineScope(Dispatchers.Main).launch{
            //repository.delete(item)}



}


