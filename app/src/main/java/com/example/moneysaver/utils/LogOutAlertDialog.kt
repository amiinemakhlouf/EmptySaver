package com.example.moneysaver.utils

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.res.TypedArrayUtils.getString
import com.example.moneysaver.R
import com.example.moneysaver.ui.mainfragment.MainFragment
import com.example.moneysaver.ui.mainfragment.MainFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LogOutAlertDialog {

     fun showAlertDialog(context:Activity) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.Android_Alert)
        builder.setMessage(R.string.sign_out_question)

        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            CoroutineScope(Main)
                .launch {
                CustomDataStore(context).saveInt(context.getString(R.string.id), -1)


            }

            finishAffinity(context)


        }

        builder.setNegativeButton(android.R.string.cancel) { _, _ ->


        }


        builder.show()
    }

}