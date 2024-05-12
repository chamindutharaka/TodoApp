package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashScreen :AppCompatActivity() {

    private lateinit var database: myDatabase

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        database = Room.databaseBuilder(
            applicationContext,myDatabase::class.java,"TaskManager"
        ).build()
        GlobalScope.launch {
            DataObject.listdata=database.dao().getTasks() as MutableList<CardInfo>
        }
        Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        },2000)

    }
}