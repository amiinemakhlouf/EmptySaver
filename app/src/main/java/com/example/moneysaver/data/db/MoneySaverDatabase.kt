package com.example.moneysaver.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.data.db.entities.ExpenseModelClass
import com.example.moneysaver.utils.Constants
import javax.inject.Inject
import javax.inject.Singleton

@Database(entities = [ClientModelClass::class, ExpenseModelClass::class], version = 3)
 abstract class MoneySaverDatabase : RoomDatabase() {

    abstract fun clientDao(): ClientDao
    abstract fun expensesDao(): ExpensesDao
    companion object {
        val DATABASE_NAME:String= Constants.DATABASE_NAME

    }


}

