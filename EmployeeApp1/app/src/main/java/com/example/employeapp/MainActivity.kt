package com.example.employeapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.employeapp.databinding.ActivityMainBinding
import com.example.employeapp.databinding.DialogCreateEmployeeBinding
import com.example.employeapp.model.CreateEmployeeRequest
import com.example.employeapp.model.Employee
import com.example.employeapp.model.EmployeeDetailResponse
import com.example.employeapp.model.EmployeeResponse
import com.example.employeapp.model.UpdateEmployeeRequest
import com.example.employeapp.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val client = ApiClient.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        loadEmployees()

        with(binding) {
            btnCreate.setOnClickListener {
                showCreateDialog()
            }
        }
    }

    private fun loadEmployees() {
        val response = client.getAllEmployes()

        // lakukan request dengan async (tidak ditunggu)
        // ketika sudah dapat datanya baru di proses
        response.enqueue(object: Callback<EmployeeResponse> {
            override fun onResponse(
                call: Call<EmployeeResponse?>,
                response: Response<EmployeeResponse?>
            ) {
                if (!response.isSuccessful) {
                    Toast.makeText(
                        this@MainActivity,
                        "HTTP ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()

                    return
                }

                val body = response.body()
                val employees = body?.data.orEmpty()

                if (employees.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        "Data kosong",
                        Toast.LENGTH_SHORT
                    ).show()

                    return
                }

                val names = employees.map { it.employeeName }

                val listAdapter = ArrayAdapter(
                    this@MainActivity,
                    android.R.layout.simple_list_item_1,
                    names
                )

                binding.lvUsers.adapter = listAdapter
                binding.lvUsers.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    val id = employees[position].id
                    DetailEmployeActivity.start(this@MainActivity, id)
                }
            }

            override fun onFailure(p0: Call<EmployeeResponse?>, p1: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Get data failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun showCreateDialog() {
        val dialogBinding = DialogCreateEmployeeBinding.inflate(layoutInflater)

        var builder = AlertDialog.Builder(this)
        builder.setTitle("Create Employee")
        builder.setView(dialogBinding.root)
        builder.setPositiveButton("Create") { dialog, _ ->
                val name = dialogBinding.etName.text.toString().trim()
                val salary = dialogBinding.etSalary.text.toString().toIntOrNull()
                val age = dialogBinding.etAge.text.toString().toIntOrNull()

                if (name.isEmpty() || salary == null || age == null) {
                    Toast.makeText(
                        this@MainActivity,
                        "Isi semua data",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@setPositiveButton
                }

                createEmployee(name, salary!!, age!!) {
                    dialog.dismiss()
                }
            }

        builder.setNegativeButton("Cancel", null)

        builder.show()
    }

    private fun createEmployee(name: String, salary: Int, age: Int, onSuccess: () -> Unit) {
        val body = CreateEmployeeRequest(name, salary, age)
        client.createEmployee(body).enqueue(object : Callback<EmployeeDetailResponse> {
            override fun onResponse(c: Call<EmployeeDetailResponse>, r: Response<EmployeeDetailResponse>) {
                if (!r.isSuccessful) {
                    Toast.makeText(
                        this@MainActivity,
                        "Create gagal: HTTP ${r.code()}",
                        Toast.LENGTH_SHORT
                    ).show()

                    return
                }
                val emp = r.body()?.data ?: return
                onSuccess()
                loadEmployees() // refresh list
            }
            override fun onFailure(c: Call<EmployeeDetailResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Gagal: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateEmployee(id: Int, name: String, salary: Int, age: Int, onSuccess: () -> Unit) {
        val body = UpdateEmployeeRequest (name, salary, age)
        client.updateEmployee(id, body).enqueue(object : Callback<EmployeeDetailResponse> {
            override fun onResponse(c: Call<EmployeeDetailResponse>, r: Response<EmployeeDetailResponse>) {
                if (!r.isSuccessful) {
                    Toast.makeText(
                        this@MainActivity,
                        "Update gagal: HTTP ${r.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                val emp = r.body()?.data ?: return
                onSuccess()
                loadEmployees() // refresh list
            }
            override fun onFailure(c: Call<EmployeeDetailResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Gagal: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteEmployee(id: Int, onSuccess: () -> Unit) {
        client.deleteEmployee(id).enqueue(object : Callback<Void> {
            override fun onResponse(c: Call<Void>, r: Response<Void>) {
                if (!r.isSuccessful) {
                    Toast.makeText(
                        this@MainActivity,
                        "Delete gagal: HTTP ${r.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                onSuccess()
                loadEmployees() // refresh list
            }
            override fun onFailure(c: Call<Void>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Gagal: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}