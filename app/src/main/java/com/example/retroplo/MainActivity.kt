package com.example.retroplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.retroplo.network.RandomRepo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getButton(view:View){
        var interceptor = RandomRepo()
        interceptor.getPersonRandomRepo()
    }
}