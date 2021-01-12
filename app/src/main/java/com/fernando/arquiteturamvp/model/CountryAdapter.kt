package com.fernando.arquiteturamvp.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fernando.arquiteturamvp.R

class CountryAdapter(private val listCountry: ArrayList<Country>):
        RecyclerView.Adapter<CountryAdapter.CountryVH>() {


    class CountryVH(itemView: View): RecyclerView.ViewHolder(itemView){
        val countryName: TextView = itemView.findViewById(R.id.listText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryVH {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false)
        return CountryVH(inflate)
    }

    override fun onBindViewHolder(holder: CountryVH, position: Int) {
        val item = listCountry.get(position)
        holder.countryName.text = item.countryName
    }

    override fun getItemCount() = listCountry.size
}