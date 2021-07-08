package com.example.retroplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retroplo.adapter.PersonAdapter
import com.example.retroplo.entity.ResultsItem
import com.example.retroplo.network.RandomRepo
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    lateinit var rvPersons: RecyclerView
    var dataRV:List<ResultsItem> = ArrayList<ResultsItem>()
    lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        getPersons()
    }

    fun setupRecyclerView() {
        // getting the recyclerview by its id
        rvPersons = findViewById(R.id.rvPersons)

        // this creates a vertical layout Manager
        rvPersons.layoutManager = LinearLayoutManager(this)
    }


    fun getPersons() {
        var interceptor = RandomRepo()
        doAsync {
            var response = interceptor.getPersonRandomRepo()
            uiThread {
                dataRV = response.body()?.results as List<ResultsItem>

                // This will pass the ArrayList to our Adapter
                adapter = PersonAdapter(dataRV)

                // Setting the Adapter with the recyclerview
                rvPersons.adapter = adapter
            }
        }
    }
}