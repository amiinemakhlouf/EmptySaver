package com.example.moneysaver.repostories

import androidx.lifecycle.LiveData
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass

class ClientRepository(
    private val db:MoneySaverDatabase
) {
    suspend fun upsert(item: ClientModelClass) = db.clientDao().upsert(item)
    suspend fun delete(item: ClientModelClass) = db.clientDao().delete(item)
    fun checkClient(username: String, password: String) =
        db.clientDao().checkClient(username, password)
    fun   getCurrentUserData(userId:Int)=db.clientDao().getCurrentUserData(userId)

}
