package com.example.moneysaver.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "client")
data class ClientModelClass
    (
    @ColumnInfo(name = "username")
    val username: String="",
    @ColumnInfo(name="password")
    val password: String="",
    @ColumnInfo(name="salary")
    val salary: Double=0.0,
    @ColumnInfo(name="expenseLimit")
    val expenseLimit: Double=0.0
     )
{       @PrimaryKey(autoGenerate = true)
        var id:Int?=null
    }