package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipData.Item
import android.content.ContentValues
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
val Itemlist= ArrayList<itemlist>()

class FunctionActivity : AppCompatActivity() {

    @SuppressLint("Range", "MissingInflatedId")
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

        val dbHelper=Mysqlhelper(this,"wt.db",1)
        val db=dbHelper.writableDatabase
        val newer: Button = findViewById(R.id.renewitem)
        newer.setOnClickListener {
            val values=ContentValues()
            values.put("time","30")
            db.update("Item",values,"time<?", arrayOf("10"))
        }
        val deleteitem:Button=findViewById(R.id.deleteitem)
        deleteitem.setOnClickListener {
            db.delete("Item","time<?", arrayOf("10"))
        }
        val cursor=db.query("Item",null,null,null,null,null,null)
        if(cursor.moveToFirst()){
            do {
                val name=cursor.getString(cursor.getColumnIndex("item"))
                val times=cursor.getString(cursor.getColumnIndex("time"))
                Log.d("function",name)
                Log.d("function",times)
                Itemlist.add(itemlist(name, times))
            }while (cursor.moveToNext())
        }
        val layoutManager = LinearLayoutManager(this)
        val recyclerView: RecyclerView = findViewById(R.id.rv_item)
        recyclerView.layoutManager = layoutManager
        val adapter = ItemAdapter(Itemlist)
        recyclerView.adapter = adapter
    }

    override fun onRestart() {
        super.onRestart()
        setContentView(R.layout.activity_function)
        val layoutManager = LinearLayoutManager(this)
        val recyclerView: RecyclerView = findViewById(R.id.rv_item)
        recyclerView.layoutManager = layoutManager
        val adapter = ItemAdapter(Itemlist)
        recyclerView.adapter = adapter
    }
}