package com.example.moneysaver.utils

import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout

class CustomLayout(private val title: EditText, private val price:EditText):LinearLayout(title.context) {

    init{
        this.setPaddingRelative(45,15,45,15)
        this.orientation=LinearLayout.VERTICAL
        this.addView(title)
        price.inputType=InputType.TYPE_NUMBER_FLAG_DECIMAL
        this.addView(price)




    }
}