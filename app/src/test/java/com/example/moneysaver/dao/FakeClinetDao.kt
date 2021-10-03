package com.example.moneysaver.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.moneysaver.data.db.ClientDao
import com.example.moneysaver.data.db.entities.ClientModelClass

class FakeClientDao:ClientDao {
        var list= mutableListOf<ClientModelClass>()



    override suspend fun upsert(item: ClientModelClass) {
        list.add(item)
    }

    override suspend fun delete(item: ClientModelClass) {
        list.remove(item)
    }

    override fun checkClient(username: String, password: String): LiveData<ClientModelClass> {
        TODO("Not yet implemented")
    }

    override fun getCurrentUserData(userId: Int): LiveData<ClientModelClass> {
        return  liveData { list.find {it.id==userId  } }
    }

    override fun getSalary(userId: Int): LiveData<Double> {
        TODO("Not yet implemented")
    }

    override fun getExpenseLimit(userId: Int): LiveData<Double> {
        TODO("Not yet implemented")
    }


}