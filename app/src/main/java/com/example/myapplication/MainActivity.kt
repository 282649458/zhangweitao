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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mRegisterButton : Button =findViewById(R.id.btn_register)
        mRegisterButton.setOnClickListener{
            val Registerintent = Intent(this, Register::class.java)
            startActivity(Registerintent)
        }

        val mloginbtn: Button =findViewById(R.id.btn_login)
        val mEdtUser: EditText =findViewById(R.id.mUser)
        val mEdtKey: EditText =findViewById(R.id.mKey)
        val name=mEdtUser.getText().toString()
        val password=mEdtKey.getText().toString()
        val prefs=getSharedPreferences("data", Context.MODE_PRIVATE)
        val named=prefs.getString("name","")
        val passworded=prefs.getString("password","")
        mloginbtn.setOnClickListener {
            if(name==named&&password==passworded){
                val intent1 = Intent(
                    this,
                    FunctionActivity::class.java
                )
                Toast.makeText(this, "登陆成功！", Toast.LENGTH_SHORT).show()
                startActivity(intent1)
            }
            else{
                Toast.makeText(this, "登陆失败,请重新登录!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}