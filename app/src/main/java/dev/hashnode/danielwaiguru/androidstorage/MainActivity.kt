package dev.hashnode.danielwaiguru.androidstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.hashnode.danielwaiguru.androidstorage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}