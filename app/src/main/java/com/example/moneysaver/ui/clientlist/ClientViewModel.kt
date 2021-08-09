package com.example.moneysaver.ui.clientlist

import androidx.lifecycle.ViewModel
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.repostories.MoneySaverMoneySaverRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ClientViewModel(
    private  val repository: MoneySaverMoneySaverRepository
):ViewModel() {
    fun upsert(item:ClientModelClass)= CoroutineScope(Dispatchers.Main).launch{
        repository.uspert(item)}
    fun delete(item:ClientModelClass)= CoroutineScope(Dispatchers.Main).launch{
            repository.delete(item)}

    fun readAllClients()=  repository.readAllClients()


}


