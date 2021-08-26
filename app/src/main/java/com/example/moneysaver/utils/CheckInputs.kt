package com.example.moneysaver.utils

import android.widget.EditText

class CheckInputs {
    fun passwordIsValid(editText: EditText): Boolean {

        // password must contain letters , numbers and at least 8 characters
        val hasDigits: Boolean = editText.text.toString().any { it.isDigit() }
        val hasLetters: Boolean = editText.text.toString().any { it.isLetter() }


        return (hasDigits && hasLetters && editText.text.toString().length >= 8)


    }
    fun isMatch(password: EditText, passwordConfirm: EditText) =
        password.text.toString() == (passwordConfirm.text.toString())


    fun isBlanck(editText: EditText): Boolean = editText.text.isBlank()

}