package com.example.kotlinjson

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Comida(val name: String, val price: Double, val description: String)

class FoodAdapter(private val list:List<Comida>, val clickListener: (Comida) -> Unit): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(inflater:LayoutInflater, parent:ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.row,parent,false))  {

        private var nombre: TextView? = null
        private var precio: TextView? = null
        private var descripcion: TextView? = null

        init {
            nombre = itemView.findViewById(R.id.nombre)
            precio = itemView.findViewById(R.id.precio)

        }

        @SuppressLint("SetTextI18n")
        fun bind(comida:Comida, clickListener: (Comida) -> Unit) {
            nombre?.text = comida.name
            precio?.text = "$" + comida.price.toString()
            descripcion?.text = comida.description
            itemView.setOnClickListener { clickListener(comida)}


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FoodViewHolder(inflater, parent)
    }

    override fun getItemCount():Int = list.size


    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        (holder as FoodViewHolder).bind(list[position], clickListener)
    }
}