package com.example.kotlinjson

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MainActivity : AppCompatActivity(){

    private lateinit var recyclerView:RecyclerView ;
    private val comidasDeMemin = listOf(
        Comida("burger", 15.0, "a juicy burger!"),
        Comida("hotdog", 20.0, "an ok hot dog"),
        Comida("tacos", 12.0, "some pretty good tacos"),
        Comida("torta", 22.0, "nice torta"),
        Comida("carne asada", 50.0, "a great carne asada")


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)



        recyclerView.adapter = FoodAdapter(comidasDeMemin) { comida : Comida -> comidaItemClicked(comida) }

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL

        GridLayoutManager(this, 2)

        recyclerView.layoutManager = llm


    }

    private fun comidaItemClicked(comida : Comida) {
        Toast.makeText(this, comida.description, Toast.LENGTH_LONG).show()
    }




}
