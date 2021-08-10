package com.example.moneysaver.repostories

import com.example.moneysaver.data.db.MoneySAverDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass

class MoneySaverRepository(
    private val db:MoneySAverDatabase
) {
        suspend fun uspert(item:ClientModelClass)=db.getMoneySaverDao().upsert(item)
        suspend fun delete(item:ClientModelClass)=db.getMoneySaverDao().delete(item)
                fun readAllClients()=db.getMoneySaverDao().readAllClients()

}