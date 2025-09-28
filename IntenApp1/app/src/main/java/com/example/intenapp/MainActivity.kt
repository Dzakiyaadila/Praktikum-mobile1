package com.example.intenapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intenapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 1. Bikin UI untuk MainActivity > 1 button untuk navigasi ke SecondActivity
    // 2. Bikin UI untuk SecondActivity > 1 TextView menampilkan welocom ${name}
    // 3. Gunakan intent untuk navigasi dan kirim data

    lateinit var binding: ActivityMainBinding
    companion object {
        const val EXTRA_NAME = "data_name"
        const val EXTRA_ADDRESS = "data_address"
        const val EXTRA_DREAM = "data_dream"
        const val EXTRA_DESC = "data_description"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MAINACTIVITY", "onCreate dipanggil")

        // handle binding
        with(binding) {
            btnToSecondActivity.setOnClickListener {
                var intentToSecondActivity = Intent(
                    this@MainActivity,
                    SecondActivity::class.java)
                intentToSecondActivity.putExtra(MainActivity.EXTRA_NAME, "Kiyaaa^^")
                intentToSecondActivity.putExtra(MainActivity.EXTRA_ADDRESS, "Jogjakerdahh")
                startActivity(intentToSecondActivity)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MAINACTIVITY", "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MAINACTIVITY", "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAINACTIVITY", "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MAINACTIVITY", "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAINACTIVITY", "onDestroy dipanggil")
    }
}