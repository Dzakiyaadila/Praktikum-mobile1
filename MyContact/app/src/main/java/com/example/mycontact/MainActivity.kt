package com.example.mycontact

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontact.data.AppDatabase
import com.example.mycontact.data.Contact
import com.example.mycontact.databinding.ActivityMainBinding
import com.example.mycontact.databinding.FormContactBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//create variable
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val contactDao by lazy { AppDatabase.get(this).contactDao() }
    private lateinit var contactViewAdapter: ContactViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        contactViewAdapter = ContactViewAdapter(
            onEdit = { contact ->  showEditDialog(contact)},
        onDelete = { contact -> showDeleteDialog(contact)}
        )
        setContentView(binding.root)

        with(binding) {
            //setting recylerview
            rvContact.apply {
                adapter = contactViewAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            //show form ketika user klik add
            btnAdd.setOnClickListener {
                showAddDialog()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    //digunakan untuk merefresh dtaa / mengambil data
    private fun refreshList() {
        lifecycleScope.launch {
            //ambil data dari getAll tapi menggunakan background thread
            var item = withContext(Dispatchers.IO) {
                contactDao.getAll()
            }

            //update data ke adapter
            contactViewAdapter.setItem(item)
        }
    }

    private fun showAddDialog() {
        val binding = FormContactBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Add new contact")
        //setting view agar muncul form

        builder.setView(binding.root)

        //bikin positif button
        builder.setPositiveButton("save") {
            dialog, which -> //ambil nama hp dr phone
            val name = binding.edtName.text.toString().trim()
            val phone = binding.edtPhone.text.toString().trim()

            if (name.isNotEmpty() && phone.isNotEmpty()) {
                //tambahkan ke db
                lifecycleScope.launch(Dispatchers.IO) {
                    //insert data ke background thread
                    contactDao.insert(Contact(name = name, phone = phone))

                    withContext(Dispatchers.Main) {
                        refreshList()
                    }
                }

            } else{
                Toast.makeText(
                    this@MainActivity, "Nama dan phone harus di isi", Toast.LENGTH_SHORT
                ).show()
            }
        }

        builder.setNeutralButton("Cancel") {
            dialog, which ->
        }

        val dialog = builder.create()
        dialog.show()
    }
    //fungsi untuk menampilkan edit form
    private fun showEditDialog(contact: Contact) {

    }
    //fungsi untuk menampilkan delete dialog
    private fun showDeleteDialog(contact: Contact) {

    }

}