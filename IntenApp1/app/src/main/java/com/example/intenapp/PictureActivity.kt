package com.example.intenapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.intenapp.databinding.ActivityPictureBinding

class PictureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPictureBinding

    // Launcher untuk mendapatkan result dari InputDeskripsiActivity
    private val descLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            // Ambil deskripsi dari result
            val deskripsi = data?.getStringExtra("EXTRA_DESC") // Pastikan key-nya sama dengan yang dikirim

            // Update TextView dengan deskripsi baru
            binding.txtImage1.text = "Deskripsi Kamu: $deskripsi"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPictureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent jika ada (opsional)
        val desc = intent.getStringExtra("EXTRA_DESC")

        with(binding) {
            // Tampilkan gambar (pastikan ada ImageView di layout)
            // binding.imageView.setImageResource(R.drawable.your_image)

            // Tampilkan deskripsi awal
            if (!desc.isNullOrEmpty()) {
                txtImage1.text = "Deskripsi: $desc"
            } else {
                txtImage1.text = "Deskripsi: Belum ada deskripsi"
            }

            // Button untuk membuka form input deskripsi
            btnDescripsi.setOnClickListener {
                val intentToDeskripsiActivity = Intent(this@PictureActivity, InputDeskripsiActivity::class.java)
                descLauncher.launch(intentToDeskripsiActivity)
            }
        }
    }
}

// HAPUS fungsi-fungsi ini - tidak diperlukan dan menyebabkan error
// private fun Unit.getStringExtra(extrsDesc: String)
// private fun ActivityResult.desc()