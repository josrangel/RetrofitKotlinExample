package com.example.retroplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.retroplo.network.RandomRepo
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
    }


    fun getRandomPersonaaa(view:View){
        var interceptor = RandomRepo()
        doAsync {
            var response = interceptor.getPersonRandomRepo()
            uiThread {
                textView.text = response.body()?.results?.get(0)?.email
            }
        }
    }
}