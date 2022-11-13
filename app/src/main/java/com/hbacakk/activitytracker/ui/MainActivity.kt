package com.hbacakk.activitytracker.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hbacakk.activitylifecyclecustom.R

class MainActivity : AppCompatActivity() {
    lateinit var buttonStart : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonStart = findViewById(R.id.buttonStart)
        buttonStart.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}