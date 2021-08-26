package com.example.moneysaver.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class ExpenseModelClass (
    @ColumnInfo(name = "title")
    val title:String= "",
    @ColumnInfo(name = "value")
    val expenseValue:Double=0.0,
    @ColumnInfo(name = "clientId")
    val clientId :Int ,
)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

}