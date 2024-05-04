package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val edit1: EditText =findViewById(R.id.editText3)
        val edit2: EditText =findViewById(R.id.editText2)
        val dbHelper=Mysqlhelper(this,"Item.db",1)
        val db=dbHelper.writableDatabase
        val submit : Button =findViewById(R.id.btn_submit)
        submit.setOnClickListener {
            val things:String=edit1.getText().toString()
            val times:String=edit2.getText().toString()
            val value= ContentValues().apply {
                put("item",things)
                put("time",times)
                Log.d("MainActivity2",things)
                Log.d("MainActivity2",times)
            }
            db.insert("Item",null,value)
            Log.d("MainActivity2","chenggong")
            Toast.makeText(this,"提交成功", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,FunctionActivity::class.java)
            startActivity(intent)
        }

    }

}