package com.example.mycourse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mycourse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            //handling UI
        }
    }
    //function untuk menampilkan menu di dalam action bar
    //untuk activity terkait / this
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)

        return true
    }

    //funct untuk handle jika menu di pili oleh user
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_home -> {
                Toast.makeText(this@MainActivity, "Home Menu Selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_materi -> {
                //action untuk materi
                //buat nav ke activity baru (MateriActivit)
                Toast.makeText(this@MainActivity, "Materi Menu Selected", Toast.LENGTH_SHORT).show()

                var intent = Intent(this@MainActivity, MateriActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_quiz -> {
                Toast.makeText(this@MainActivity, "Quiz Menu Selected", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


//tugas
//Di materi 1 buat menampilkan 10 data (judul, deskripsi, tanggal)
//buat pakai recycler view
//ketika di klik muncul toast


//bikin ui untuk item
//buat data class / model
//buat adapter
//tambahkan recycler view
//set up recycler view dengan adapter
