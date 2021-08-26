package com.example.moneysaver.ui.mainfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.ProfileFragment.ProfileViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragmentViewModel(private  val repository: ExpenseRepository
): ViewModel() {

    fun upsert(item: ExpenseModelClass)= CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)
    }
    fun getCurrentUserExpenses(id:Int)=repository.getCurrentUserExpenses(id)



}