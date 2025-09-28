package com.example.intenapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intenapp.databinding.ActivityDeskripsiBinding
import com.example.intenapp.databinding.ActivityInputAddressBinding

class InputDeskripsiActivity : AppCompatActivity() {

    lateinit var binding: ActivityDeskripsiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDeskripsiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnSubmitDesc.setOnClickListener {
                val deskripsi = binding.edtDeskipsi.text.toString()
                val resultIntent = Intent()
                resultIntent.putExtra("EXTRA_DESC", deskripsi)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
        }
    }

