package com.example.employeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.employeapp.databinding.ActivityDetailEmployeBinding
import com.example.employeapp.model.EmployeeDetailResponse
import com.example.employeapp.model.EmployeeResponse
import com.example.employeapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.map
import kotlin.collections.orEmpty

class DetailEmployeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailEmployeBinding

    private val client = ApiClient.getInstance()

    companion object {
        private const val EXTRA_EMPLOYEE_ID = "extra_employee_id"

        fun newIntent(context: Context, employeeId: Int): Intent =
            Intent(context, DetailEmployeActivity::class.java)
                .putExtra(EXTRA_EMPLOYEE_ID, employeeId)

        fun start(context: Context, employeeId: Int) {
            context.startActivity(newIntent(context, employeeId))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailEmployeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val employeeId = intent.getIntExtra(EXTRA_EMPLOYEE_ID, -1)
        if (employeeId == -1) {
            Toast.makeText(
                this,
                "ID tidak valid",
                Toast.LENGTH_SHORT
            ).show()

            finish()
            return
        }

        getDetailEmployee(employeeId)
    }

    private fun getDetailEmployee(id: Int) {
        val response = client.getAllEmployeDetail(id = 1)

        // lakukan request dengan async (tidak ditunggu)
        // ketika sudah dapat datanya baru di proses
        response.enqueue(object: Callback<EmployeeDetailResponse> {
            override fun onResponse(
                call: Call<EmployeeDetailResponse?>,
                response: Response<EmployeeDetailResponse?>
            ) {
                if (!response.isSuccessful) {
                    Toast.makeText(
                        this@DetailEmployeActivity,
                        "HTTP ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()

                    return
                }

                val body = response.body()
                val employee = body?.data

                binding.txtName.setText("Name: ${employee?.employeeName.toString()}")
                binding.txtAge.setText("Age: ${employee?.employeeAge.toString()}")
                binding.txtSalary.setText("Salary: ${employee?.employeeSalary.toString()}")
            }

            override fun onFailure(p0: Call<EmployeeDetailResponse?>, p1: Throwable) {
                Toast.makeText(
                    this@DetailEmployeActivity,
                    "Get data failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}