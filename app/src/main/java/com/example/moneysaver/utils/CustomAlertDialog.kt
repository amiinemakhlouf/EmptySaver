package com.example.moneysaver.utils

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat.finishAffinity
import com.example.moneysaver.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CustomAlertDialog {

     fun showAlertDialog(context:Activity,customDataStore: CustomDataStore) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.Android_Alert)
        builder.setMessage(R.string.sign_out_question)

        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            GlobalScope.launch {
                customDataStore.saveInt(Constants.ID, -1)

            }

            finishAffinity(context)


        }

        builder.setNegativeButton(android.R.string.cancel) { _, _ ->


        }


        builder.show()
    }

}