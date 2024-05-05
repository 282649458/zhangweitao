package com.example.myapplication

class itemlist() {
    var id:Long=0
    lateinit var itemname:String
    lateinit var time:String
    constructor(itemname:String,time:String):this(){
        this.itemname=itemname
        this.time=time
    }
}