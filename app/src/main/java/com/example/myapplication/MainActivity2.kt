package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val edit1: EditText =findViewById(R.id.editText3)
        val edit2: EditText =findViewById(R.id.editText2)
        val things=edit1.getText().toString()
        val times=edit2.getText().toString()
        val dbHelper=Mysqlhelper(this,"Book",1)
        val db=dbHelper.writableDatabase
        val submit : Button =findViewById(R.id.btn_submit)
        submit.setOnClickListener {
            val value= ContentValues().apply {
                put("item",things)
                put("time",times)
            }
            db.insert("Book",null,value)
            Toast.makeText(this,"提交成功", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,FunctionActivity::class.java)
            startActivity(intent)
        }

    }
}