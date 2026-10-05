package com.example.iqbal_3tib

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iqbal_3tib.Pertemuan5.LimaActivity
import com.google.android.material.snackbar.Snackbar
import com.example.iqbal_3tib.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")

        binding.txtUsername.text = user
        binding.txtPassword.text = pass

        binding.SnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Item dihapus", Snackbar.LENGTH_LONG)
                .setAction("BATAL") {

                }
                .show()
        }
        binding.AlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage(
                    "Data yang dihapus tidak " +
                            "bisa dikembalikan."
                )
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btnKembali.setOnClickListener {
           // val intent = Intent(this, LoginActivity::class.java)
           // startActivity(intent)

            finish()
        }
        binding.btnToLima.setOnClickListener {
            val intent = Intent(this@MainActivity, LimaActivity::class.java)
            startActivity(intent)
        }
    }
}