package com.example.mycourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.disasterapp.Materi
import com.example.mycourse.databinding.MateriItemBinding

typealias OnClickMateri = (Materi) -> Unit

class MateriAdapter (
    private val listMateri: List<Materi>,
    private val onClickMateri: OnClickMateri):
    RecyclerView.Adapter<com.example.mycourse.MateriAdapter.ItemMateriViewHolder> () {

    inner class ItemMateriViewHolder(private val binding: MateriItemBinding):
            RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Materi) {
            with(binding) {
                txtJudul.text = data.judul
                txtDeskripsi.text = data.deskripsi
                txtDate.text = data.tanggal
                itemView.setOnClickListener {
                    onClickMateri(data)
                }
            }
        }
    }

    override fun onCreateViewHolder (
        parent: ViewGroup,
        viewType: Int
    ): ItemMateriViewHolder {
        val binding = MateriItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemMateriViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemMateriViewHolder,
        position: Int
    ) {
        holder.bind (listMateri[position])
    }

    override fun getItemCount(): Int {
        return listMateri.count()
    }
}
