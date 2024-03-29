package com.example.hw_5_2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_5_2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, FirstFragment())
            .commit()
    }
}