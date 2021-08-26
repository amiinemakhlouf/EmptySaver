package com.example.moneysaver.data.room_repostories

import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ExpenseModelClass

class ExpenseRepository (private val db: MoneySaverDatabase
) {
    suspend fun upsert(item: ExpenseModelClass) = db.expensesDao().upsert(item)
    fun getCurrentUserExpenses(id:Int)=db.expensesDao().getCurrentUserExpenses(id)

}