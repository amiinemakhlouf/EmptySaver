package com.example.moneysaver.repostories

import androidx.lifecycle.LiveData
import com.example.moneysaver.data.db.ClientDao
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val dao:ClientDao
) {
    suspend fun upsert(item: ClientModelClass) = dao.upsert(item)
    suspend fun delete(item: ClientModelClass) = dao.delete(item)
    fun getSalary(userId:Int)=dao.getSalary(userId)
    fun checkClient(username: String, password: String) =
        dao.checkClient(username, password)
    fun   getCurrentUserData(userId:Int)=dao.getCurrentUserData(userId)
     fun getSalaryLimit(userId: Int)=dao.getExpenseLimit(userId)

}
