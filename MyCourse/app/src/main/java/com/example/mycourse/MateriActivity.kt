package com.example.mycourse

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mycourse.databinding.ActivityMainBinding
import com.example.mycourse.databinding.ActivityMateriBinding
import com.google.android.material.tabs.TabLayoutMediator


class MateriActivity : AppCompatActivity() {

    companion object {
        //load nama / title dari tab yang disimpan di dalam resource / string value
        @StringRes
        private val TAB_TITLE = intArrayOf(
            R.string.tab_materi_1,
            R.string.tab_materi_2
        )
    }

    private lateinit var binding: ActivityMateriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMateriBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var sectionsPagerAdapter = SectionsPagerAdapter(this)


        with(binding) {
            viewPager.adapter = sectionsPagerAdapter

            TabLayoutMediator(tabLayout, viewPager) {
                tab, position -> tab.text = resources.getString(TAB_TITLE[position])
            }.attach()
            supportActionBar?.elevation = 0f

        }
    }
}


//with(binding) {
//    btnToPicture.setOnClickListener {
//        val intenToPictureActivity = Intent(this@SecondActivity, PictureActivity::class.java)
//        startActivity(intenToPictureActivity)
//    }