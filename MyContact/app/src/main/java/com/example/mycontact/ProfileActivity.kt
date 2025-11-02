package com.example.mycontact

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycontact.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefManager = PrefManager.getInstance(this)
        checkLoginStatus()


        with(binding) {
            txtUsername.text = prefManager.getUsername() //get username dari prefManager

            btnLogout.setOnClickListener {
                prefManager.setLoggedIn(false)
                startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
                finish()
            }

            btnBack.setOnClickListener {
                startActivity(Intent(this@ProfileActivity, MainActivity::class.java))
            }
//            btnClear.setOnClickListener {
//                prefManager.clear()
//                finish()
//            }
        }
    }

    fun checkLoginStatus() {
        val isLogedIn = prefManager.isLoggedIn()
        if (!isLogedIn) {
            startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
            finish()
        }
    }
}