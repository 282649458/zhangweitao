package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Feedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        val button: Button = findViewById(R.id.btn_feedback)
        button.setOnClickListener {

            Toast.makeText(this, "反馈成功", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,MineActivity::class.java)
            startActivity(intent)
        }
    }
}