package com.example.disasterapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.disasterapp.databinding.ItemDisasterBinding

// class untuk mengatur tamplan data  dari activity ke UI
// ubah disasterAdapter untuk menerima parameter listdisaster
typealias OnClickDisaster = (Disaster) -> Unit
class DisasterAdapter(private val listDisaster: List<Disaster>, private val onClickDisaster: OnClickDisaster): RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {

    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding):
        RecyclerView.ViewHolder(binding.root) {

        // create function to handle
        //  how to bind data
        fun bind(data: Disaster) {
            with(binding) {
                txtDisasterName.setText(data.name)
                txtDisasterType.setText(data.type)
                txtDisasterLocation.setText(data.location)
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        // return viewholder utk setiap item
        return ItemDisasterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }

    override fun getItemCount(): Int {
        return listDisaster.count()
    }
}