package com.example.moneysaver.utils

import android.content.Context
import android.os.Looper
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.moneysaver.R
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.ui.mainfragment.MainFragmentViewModel
import kotlinx.coroutines.*
import java.util.logging.Handler

class CustomAlertDialog(private val context: Context) {
    private lateinit var customDataStore: CustomDataStore
    private val titleEditText = EditText(context)
    private val priceEditText = EditText(context)
    private val checkInputs = CheckInputs()
    private val layout = CustomLayout(titleEditText, priceEditText)

    fun showCustomAlertDialog(
        userId: Int,
        viewModel: MainFragmentViewModel,
        AlertTitle: String,
        hint1: String,
        hint2: String
    ) {
        customDataStore = CustomDataStore(context)

        this.titleEditText.hint = hint1
        priceEditText.hint = hint2
        val alert = AlertDialog.Builder(context)
        alert.setTitle(AlertTitle)
        alert.setView(layout)
        alert.setPositiveButton(android.R.string.ok) {

                _, _ ->

            if (checkInputs.isBlanck(titleEditText)||checkInputs.isBlanck(priceEditText))
                {
                  Toast.makeText(context,context.getString(R.string.fields_constraints),Toast.LENGTH_SHORT).show()
                  return@setPositiveButton
                }






            val title = titleEditText.text.toString()
        val price = priceEditText.text.toString()


        viewModel.upsert(ExpenseModelClass(title, price.toDouble(), userId))
        Toast.makeText(context, context.getString(R.string.expenses_added), Toast.LENGTH_SHORT)
            .show()


    }

    alert.setNegativeButton(android.R.string.cancel)
    {

        _, _ ->


    }
    alert.show()

} }

