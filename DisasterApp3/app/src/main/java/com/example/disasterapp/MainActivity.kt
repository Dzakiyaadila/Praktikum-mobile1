package com.example.disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disasterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        // binding root
        setContentView(binding.root)

        // panggil dummy
        var disaster = generateDummy();

        // init adapter
        // sekaligus data
        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(this@MainActivity, "You clicked on ${disaster.name}", Toast.LENGTH_SHORT).show()
        }

        // jika binding sdh terassigned
        with(binding) {

            rvDisaster.apply {
                adapter = adapterDisaster;
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    // create function to generate dummy data
    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(name = "Gempa", type = "Alam", location = "Pkp"),
            Disaster(name = "Banjir", type = "Alam", location = "Pkp"),
            Disaster(name = "Angin Topan", type = "Alam", location = "Pkp"),
            Disaster(name = "Kebakaran", type = "Buatan", location = "Pkp"),
            Disaster(name = "Tsunami", type = "Alam", location = "Pkp"),
            Disaster(name = "Tanah Longsor", type = "Alam", location = "Pkp"),
            Disaster(name = "Gempa", type = "Alam", location = "Pkp"),
            Disaster(name = "Banjir", type = "Alam", location = "Pkp"),
            Disaster(name = "Gempa", type = "Alam", location = "Pkp"),
            Disaster(name = "Banjir", type = "Alam", location = "Pkp"),
            Disaster(name = "Angin Topan", type = "Alam", location = "Pkp"),
            Disaster(name = "Kebakaran", type = "Buatan", location = "Pkp"),
            Disaster(name = "Tsunami", type = "Alam", location = "Pkp"),
            Disaster(name = "Tanah Longsor", type = "Alam", location = "Pkp"),
            Disaster(name = "Gempa", type = "Alam", location = "Pkp"),
            Disaster(name = "Banjir", type = "Alam", location = "Pkp"),
            Disaster(name = "Gempa", type = "Alam", location = "Pkp"),
            Disaster(name = "Banjir", type = "Alam", location = "Pkp"),
            Disaster(name = "Angin Topan", type = "Alam", location = "Pkp"),
            Disaster(name = "Kebakaran", type = "Buatan", location = "Pkp"),
            Disaster(name = "Tsunami", type = "Alam", location = "Pkp"),
            Disaster(name = "Tanah Longsor", type = "Alam", location = "Pkp"),
            Disaster(name = "Gempa", type = "Alam", location = "Pkp"),
            Disaster(name = "Banjir", type = "Alam", location = "Pkp")
        )
    }
}