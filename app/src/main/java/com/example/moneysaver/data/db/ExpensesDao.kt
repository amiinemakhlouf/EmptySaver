package com.example.moneysaver.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.data.db.entities.ExpenseModelClass

@Dao
interface ExpensesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ExpenseModelClass)
    @Query("Select * from expense where clientId=:userId")
    fun   getCurrentUserExpenses(userId:Int):LiveData<MutableList<ExpenseModelClass>>
    @Query("Select Sum(value) from expense group by(clientId) having clientId =:userId ")
    fun getSumExpenses(userId: Int): LiveData<Double>
    @Query("delete from expense where id=:expenseId")
    fun deleteExpense(expenseId:Int)
    @Query(" select * from expense where clientId=:userId order by value ")
    fun filterByPrice(userId: Int):LiveData<MutableList<ExpenseModelClass>>
    @Query(" select * from expense where clientId=:userId and category=:category ")
    fun filterByCategory(userId: Int,category: String):LiveData<MutableList<ExpenseModelClass>>




}