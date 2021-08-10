package com.example.moneysaver.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moneysaver.data.db.entities.ClientModelClass
@Dao
interface MoneySaverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ClientModelClass)
    @Delete
    suspend fun delete(item: ClientModelClass)
    @Query("SELECT * FROM Client")
            fun  readAllClients():LiveData<List<ClientModelClass>>
}