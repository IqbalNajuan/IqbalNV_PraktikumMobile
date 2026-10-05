package com.example.iqbal_3tib.Pertemuan5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iqbal_3tib.R
import com.example.iqbal_3tib.databinding.ActivityLimaBinding

class LimaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLimaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLimaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Halaman Pertama"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
        }
    }
}