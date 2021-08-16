package com.example.moneysaver.repostories

import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass

class MoneySaverRepository(
    private val db:MoneySaverDatabase
) {
    suspend fun uspert(item: ClientModelClass) = db.clientDao().upsert(item)
    suspend fun delete(item: ClientModelClass) = db.clientDao().delete(item)
    fun readAllClients(username: String, password: String) =
        db.clientDao().clientExists(username, password)
}
