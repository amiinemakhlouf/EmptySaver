package com.example.moneysaver.utils

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.example.moneysaver.R
import com.example.moneysaver.ui.HistoryFragment.HistoryFragmentViewModel
import com.example.moneysaver.ui.mainfragment.MainFragmentViewModel
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_ViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteItemDialog(private val viewModel:HistoryFragmentViewModel) {
    fun showAlertDialog(context: Activity,expenseId:Int) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.Android_Alert)
        builder.setMessage(R.string.delete_request)

        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            CoroutineScope(Dispatchers.IO)
                .launch {

                   viewModel.deleteExpense(expenseId )

                }



        }

        builder.setNegativeButton(android.R.string.cancel) { _, _ ->


        }


        builder.show()
    }

}