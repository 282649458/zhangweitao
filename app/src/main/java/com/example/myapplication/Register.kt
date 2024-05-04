package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val backButton: Button = findViewById(R.id.back)
        backButton.setOnClickListener {
            val backintent = Intent(this, MainActivity::class.java)
            startActivity(backintent)
        }
        val mEdtUser1: EditText = findViewById(R.id.mRegisterUser)
        val mEdtKey1: EditText = findViewById(R.id.mRegisterKey)
        val mBtnregister1: Button = findViewById(R.id.btn_register1)
        val user1=mEdtUser1.getText().toString()
        val password1=mEdtKey1.getText().toString()
        mBtnregister1.setOnClickListener {
            val editor=getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name",user1)
            editor.putString("password",password1)
            editor.apply()
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show()
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}