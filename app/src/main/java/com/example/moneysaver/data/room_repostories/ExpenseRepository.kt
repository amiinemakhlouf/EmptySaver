package com.example.moneysaver.data.room_repostories

import com.example.moneysaver.data.db.ExpensesDao
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import javax.inject.Inject

class ExpenseRepository @Inject constructor (private val dao: ExpensesDao
) {
    suspend fun upsert(item: ExpenseModelClass) = dao.upsert(item)
    fun getCurrentUserExpenses(id:Int)=dao.getCurrentUserExpenses(id)
    fun getSumExpenses(id:Int)=dao.getSumExpenses(id)
    fun deleteExpense(expenseId:Int)=dao.deleteExpense(expenseId )
    fun filterByPrice(userId:Int)=dao.filterByPrice(userId)
    fun filterByCategory(userId: Int,category: String)=dao.filterByCategory(userId,category)

}