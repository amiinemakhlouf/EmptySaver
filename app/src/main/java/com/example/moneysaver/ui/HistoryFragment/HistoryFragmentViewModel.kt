package com.example.moneysaver.ui.HistoryFragment

import android.content.Context
import android.view.contentcapture.ContentCaptureCondition
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneysaver.R
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.utils.CustomDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.internal.wait
import javax.inject.Inject

@HiltViewModel
class HistoryFragmentViewModel @Inject constructor (private  val repository: ExpenseRepository
): ViewModel() {

    fun getCurrentUserExpenses(userId:Int)=repository.getCurrentUserExpenses(userId)
    // fun checkUser(username:String,password:String)=repository.checkClient(username,password)
    fun getId( context:Context) :Int  {

        val dataStore= CustomDataStore(context)
        var id :Int=0
        runBlocking {
            id= dataStore.readInt(context.getString(R.string.id))!!


        }

        return id

    }
    suspend fun deleteExpense(expenseId:Int)= repository.deleteExpense(expenseId )
     fun filterByPrice(userId: Int)=repository.filterByPrice(userId)
    fun filterByCategory(userId: Int,category:String)=repository.filterByCategory(userId,category)



}