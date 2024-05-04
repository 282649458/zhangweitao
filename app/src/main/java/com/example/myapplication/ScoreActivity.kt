package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val Tohome: Button = findViewById(R.id.btn_house1)
        Tohome.setOnClickListener {
            val i2 = Intent(this, FunctionActivity::class.java)
            startActivity(i2)
        }
        val Toscore: Button = findViewById(R.id.btn_score1)
        Toscore.setOnClickListener {
            val i2 = Intent(this, ScoreActivity::class.java)
            startActivity(i2)

        }
        val Tomine: Button =findViewById(R.id.btn_mine1)
        Tomine.setOnClickListener {
            val i2 = Intent(this, MineActivity::class.java)
            startActivity(i2)
        }
    }
}