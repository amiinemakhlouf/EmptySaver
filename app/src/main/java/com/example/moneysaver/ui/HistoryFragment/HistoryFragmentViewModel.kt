package com.example.moneysaver.ui.HistoryFragment

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.moneysaver.R
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.utils.CustomDataStore
import kotlinx.coroutines.runBlocking

class HistoryFragmentViewModel (private  val repository: ExpenseRepository,private  val context: Context
): ViewModel() {
    private val dataStore= CustomDataStore(context)

    fun getCurrentUserData(userId:Int)=repository.getCurrentUserExpenses(userId)
    // fun checkUser(username:String,password:String)=repository.checkClient(username,password)
    fun getId() :Int  {
        val id :Int
        runBlocking {
            id= dataStore.readInt(context.getString(R.string.id))!!

        }
        return id

    }


}