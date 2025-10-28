package com.example.mycontact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontact.data.Contact
//import com.example.mycontact.databinding.ItemCntactBinding
import com.example.mycontact.databinding.ItemContactBinding

class ContactViewAdapter(
    private val onEdit: (Contact) -> Unit,
    private val onDelete: (Contact) -> Unit

): RecyclerView.Adapter<ContactViewAdapter.ItemContactViewHolder>() {

    // variable yang menyimpan data list contact
    private val contact = mutableListOf<Contact>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemContactViewHolder {
        val binding = ItemContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return ItemContactViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemContactViewHolder,
        position: Int
    ) {
        holder.binding(contact[position])
    }

    override fun getItemCount(): Int {
        return contact.count()
    }

    // view holder
    // setiap item view akan diatur disini
    inner class ItemContactViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(contact: Contact) {
            with(binding) {
                txtName.setText(contact.name)
                txtPhone.setText(contact.phone)

                btnEdit.setOnClickListener { onEdit(contact) }
                btnDelete.setOnClickListener { onDelete(contact) }
            }
        }
        }

    fun setItem(newData: List<Contact>) {
        //hapus data sebelumnya
        contact.clear()

        //tambah data baru
        contact.addAll(newData)

        //nodify ke ui
        notifyDataSetChanged()
    }

}