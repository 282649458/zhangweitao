package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Mysqlhelper(val context: Context, name:String, version:Int): SQLiteOpenHelper(context,name,null,version){
    private val createItem="create table Item("+"id integer primary key autoincrement,"+"item text,"+"time text)"
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createItem)
    }
    //
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }



}