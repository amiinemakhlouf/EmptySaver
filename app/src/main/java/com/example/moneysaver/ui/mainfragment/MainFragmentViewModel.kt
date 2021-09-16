package com.example.moneysaver.ui.mainfragment

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.moneysaver.R
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import com.example.moneysaver.databinding.FragmentMainBinding
import com.example.moneysaver.repostories.ClientRepository
import com.example.moneysaver.ui.ProfileFragment.ProfileViewModel
import com.example.moneysaver.utils.Category
import com.example.moneysaver.utils.CustomAlertDialog
import com.example.moneysaver.utils.CustomDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.NullPointerException
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private  val repository: ExpenseRepository, private val rep:ClientRepository
): ViewModel() {
      lateinit var category: Category
    fun  alertDialog(context: Context):CustomAlertDialog{
        return CustomAlertDialog(context)
    }

    fun getSalary(id:Int)=rep.getSalary(id)
    fun getSalaryLimit(id:Int)=rep.getSalaryLimit(id)
    fun upsert(item: ExpenseModelClass)= CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)
    }
    fun getCurrentUserExpenses(id:Int)=repository.getCurrentUserExpenses(id)

        fun getId(context: Context) :Int  {
                 val id :Int
                 runBlocking {
                      id= CustomDataStore(context).readInt(context.getString(R.string.id))!!

                 }
            return id

        }
     fun getSumExpenses(userId:Int)=repository.getSumExpenses(userId)


}


