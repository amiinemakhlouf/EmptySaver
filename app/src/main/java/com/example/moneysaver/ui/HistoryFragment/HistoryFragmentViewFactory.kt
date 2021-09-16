package com.example.moneysaver.ui.HistoryFragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.mainActivity.MainActivityViewModel

class HistoryFragmentViewFactory (private val repository: ExpenseRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HistoryFragmentViewModel( repository) as T
    }
}