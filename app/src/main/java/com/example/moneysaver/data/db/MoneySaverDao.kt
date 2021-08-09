package com.example.moneysaver.data

import androidx.room.*
import com.example.moneysaver.data.ClientModelClass
@Dao
interface MoneySaverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upset(item: ClientModelClass)
    @Delete
    suspend fun delete(item: ClientModelClass)
    @Query("SELECT * FROM Client")
    fun  readAllItems(item: ClientModelClass)
}