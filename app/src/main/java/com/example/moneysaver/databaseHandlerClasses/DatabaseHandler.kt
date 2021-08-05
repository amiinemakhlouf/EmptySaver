package com.example.moneysaver.databaseHandlerClasses

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.moneysaver.modelClasses.ClientModelClass

class DatabaseHandler(context: Context):SQLiteOpenHelper(context,
    DATABASE_NAME,null,
    DATABASE_VERSION
) {

    companion object{

        private const val DATABASE_NAME="MoneySaver"
        private const val DATABASE_VERSION=1
        private  const val TABLE_NAME="ClientTable"
        private  const val KEY_ID="_id"
        private  const val KEY_USERNAME="username"
        private  const val KEY_PASSWORD="password"
        private  const val KEY_SAlARY="salary"
        private  const val KEY_EXPENSE_LIMIT="expenseLimit"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CLIENT_TABLE=("CREATE TABLE"+ TABLE_NAME +"("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_USERNAME +" VARCHAR(30),"
                + KEY_PASSWORD +" VARCHAR(40),"
                + KEY_SAlARY +" REAL,"
                + KEY_EXPENSE_LIMIT +" REAL" +")"
                                 )
        db?.execSQL(CREATE_CLIENT_TABLE)
                                                }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME)
        onCreate(db)
    }
    fun addClient(Client: ClientModelClass):Long{

        val db=this.writableDatabase

        val contentValues=ContentValues()
        contentValues.put(KEY_USERNAME,Client.username)
        contentValues.put(KEY_PASSWORD,Client.password)
        contentValues.put(KEY_USERNAME,Client.salary)
        contentValues.put(KEY_EXPENSE_LIMIT,Client.expenseLimit)
        val success=db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return  success
    }

    fun readClient() :ArrayList<ClientModelClass>
     {

         val clientArrayList=ArrayList<ClientModelClass>()
         val selectQuery="SELECT * FROM $TABLE_NAME"
         val db=this.readableDatabase
         val cursor =db.rawQuery(selectQuery,null)

         // values containrs
         var username:String
         var password:String
         var salary:Double
         val limitSalary:Double
         if (cursor.moveToFirst()){

             do{
                 username=cursor.getString(cursor.getColumnIndex())
             }
         }




     }




















}