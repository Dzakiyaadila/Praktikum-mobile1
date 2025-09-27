package com.example.countryapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.countryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityMainBinding
    private val countries = arrayOf(
        "indonesia",
        "Singapura",
        "Thailand",
        "Vietnam",
        "Philippines"
    )
    //ini array untuk menyimpan data province. tambahkan lateinit krna datanya ditambahkan dari resource
    private lateinit var provinces: Array <String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        provinces = resources.getStringArray(R.array.provinces)

        with(binding) {
            val adapterCountry = ArrayAdapter (this@MainActivity, android.R.layout.simple_spinner_dropdown_item, countries
            )

            adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCountry.adapter = adapterCountry

            val adapterProvinces = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, provinces)

            adapterProvinces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerProvince.adapter = adapterProvinces
            
            // handle on item selected, kayakdisini kita harus ngapaian what??
            
            spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@MainActivity, countries[position], Toast.LENGTH_SHORT).show()
                }
                //position itu maksudnya untuk ngambil index dari array untuk menampilkan data dr index tersebut gt dech

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
            //hanling on select calender
            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) {
                _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth/ ${monthOfYear + 1}/ $year"
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }
            //handle on select time picker
            timePicker.setOnTimeChangedListener {
                view, jam, menit ->
                val selectedTime = "$jam:$menit"
                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
            }

            btnShowCalendar.setOnClickListener {
                val datePicker = DatePicker ()
                datePicker.show(supportFragmentManager, "datePicker")
            }

            btnShowAlertDialog.setOnClickListener {
                //buat builder
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Keluar")
                builder.setMessage("Apakah anda yaqinn mw keluar aplikasi????")
                //bikin button positif
                builder.setPositiveButton("Yeah") {
                    dialog, which ->
                    //lakukan smth, misal keluar app
                    finish()
                }
                builder.setNegativeButton("TIDAK") {
                    dialog, _ -> dialog.dismiss()
                }

                val dialog = builder.create()
                dialog.show()

            }
            btnShowCustomDialog.setOnClickListener {
                val dialog = DialogExit()
                dialog.show(supportFragmentManager, "dialogExit")
            }
        }
    }
    override fun onDateSet(p0: android.widget.DatePicker?, p1: Int, p2: Int, p3:
    Int) {
        val selectedDate = "$p3/${p2 + 1}/$p1"
        Toast.makeText(this@MainActivity, selectedDate,
            Toast.LENGTH_SHORT).show()

    }




}