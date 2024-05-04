package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
val Itemlist= ArrayList<Item>()

class FunctionActivity : AppCompatActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)

        val Tohome: Button = findViewById(R.id.btn_house)
        Tohome.setOnClickListener {
            val i2 = Intent(this, FunctionActivity::class.java)
            startActivity(i2)
        }
        val Toscore: Button = findViewById(R.id.btn_score)
        Toscore.setOnClickListener {
            val i2 = Intent(this, ScoreActivity::class.java)
            startActivity(i2)

        }
        val Tomine: Button = findViewById(R.id.btn_mine)
        Tomine.setOnClickListener {
            val i2 = Intent(this, MineActivity::class.java)
            startActivity(i2)
        }
        val start: Button = findViewById(R.id.btn_name)
        start.setOnClickListener {
            val i1 = Intent(this, MainActivity2::class.java)
            startActivity(i1)
        }
        val dbHelper=Mysqlhelper(this,"Item.db",1)
        val db=dbHelper.writableDatabase
        val cursor=db.query("Item",null,null,null,null,null,null)
        if(cursor.moveToFirst()){
            do {
                val name=cursor.getString(cursor.getColumnIndex("item"))
                val times=cursor.getString(cursor.getColumnIndex("time"))
                Log.d("FunctionActivity","tiaoshi")
                Itemlist.add(ClipData.Item(name, times))
            }while (cursor.moveToNext())
        }
        val layoutManager = LinearLayoutManager(this)
        val recyclerView: RecyclerView = findViewById(R.id.rv_item)
        recyclerView.layoutManager = layoutManager
        val adapter = ItemAdapter()
        recyclerView.adapter = adapter
    }
}