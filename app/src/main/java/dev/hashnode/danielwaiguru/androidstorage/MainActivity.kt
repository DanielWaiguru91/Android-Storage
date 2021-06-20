package dev.hashnode.danielwaiguru.androidstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import dev.hashnode.danielwaiguru.androidstorage.adapters.PagerAdapter
import dev.hashnode.danielwaiguru.androidstorage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tiles: List<String> by lazy {
        resources.getStringArray(R.array.tab_tiles).toList()
    }
    private val pagerAdapter: PagerAdapter by lazy {
        PagerAdapter(tiles)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
        setupTabLayout()
    }
    private fun setupViewPager() {
        binding.viewPager.adapter = pagerAdapter
    }
    private fun setupTabLayout() {
        TabLayoutMediator(binding.tab, binding.viewPager) { tab, position ->
            tab.text = tiles[position]
        }
    }
}