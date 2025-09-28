package com.example.intenapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intenapp.databinding.ActivityInputAddressBinding

class InputAddressActivity : AppCompatActivity() {

    lateinit var binding: ActivityInputAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityInputAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
//            btnSubmit1.setOnClickListener {
//                val resultIntent = Intent()
//                resultIntent.putExtra(MainActivity.EXTRA_ADDRESS, edtAddress.text.toString())
//                setResult(Activity.RESULT_OK, resultIntent)
//                finish()
//            }

            btnSubmit2.setOnClickListener {
                val resultIntent = Intent()
                resultIntent.putExtra(MainActivity.EXTRA_DREAM, edtDream.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_ADDRESS, edtAddress.text.toString())
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}