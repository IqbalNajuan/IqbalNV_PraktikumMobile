package com.example.iqbal_3tib.Pertemuan5 // Sesuaikan jika ada perbedaan nama folder/package

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.iqbal_3tib.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {


    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://chatgpt.com/")



        setSupportActionBar(binding.toolbar)


        supportActionBar?.apply {
            title = "Noval"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }


        binding.webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {

                binding.appBar.setExpanded(false, true)
            } else if (scrollY < oldScrollY) {

                binding.appBar.setExpanded(true, true)
            }
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}