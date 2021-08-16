package com.example.moneysaver.data.db.entities

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
class CategoryModelClass (
    @ColumnInfo(name = "image")
    val image :Image?=null,
    @ColumnInfo(name="name")
    val name:String=""
        ){

    @PrimaryKey(autoGenerate = true)
   var    id:Int =0
}