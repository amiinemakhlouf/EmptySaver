package com.example.moneysaver.repostories

import com.example.moneysaver.data.db.MoneySAverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass

class MoneySaverMoneySaverRepository(
    private val db:MoneySAverDatabase
) {
        suspend fun uspert(item:ClientModelClass)=db.getClientsItemsDao().upsert(item)
        suspend fun delete(item:ClientModelClass)=db.getClientsItemsDao().delete(item)
                fun readAllClients()=db.getClientsItemsDao().readAllClients()

}