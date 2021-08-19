package com.example.moneysaver.ui.mainActivity

import androidx.lifecycle.ViewModel
import com.example.moneysaver.repostories.MoneySaverRepository

class MainActivityViewModel (private  val repository: MoneySaverRepository
): ViewModel() {

    fun getCurrentUserData(userId:Int)=repository.getCurrentUserData(userId)



}