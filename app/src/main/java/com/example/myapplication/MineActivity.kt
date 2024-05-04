package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mine)
        val renew: Button = findViewById(R.id.renew)
        renew.setOnClickListener {
            Toast.makeText(this, "当前已是最新版本", Toast.LENGTH_SHORT).show()
        }
        val feedback: Button = findViewById(R.id.feedback)
        feedback.setOnClickListener {
            val i1 = Intent(this, Feedback::class.java)
            startActivity(i1)
        }
        val logout: Button = findViewById(R.id.logout)
        logout.setOnClickListener {
            val i2 = Intent(this, MainActivity::class.java)
            startActivity(i2)
        }
        val Tohome: Button = findViewById(R.id.btn_house2)
        Tohome.setOnClickListener {
            val i2 = Intent(this, FunctionActivity::class.java)
            startActivity(i2)
        }
        val Toscore: Button = findViewById(R.id.btn_score2)
        Toscore.setOnClickListener {
            val i2 = Intent(this, ScoreActivity::class.java)
            startActivity(i2)

        }
        val Tomine: Button =findViewById(R.id.btn_mine2)
        Tomine.setOnClickListener {
            val i2 = Intent(this, MineActivity::class.java)
            startActivity(i2)
        }
    }
}