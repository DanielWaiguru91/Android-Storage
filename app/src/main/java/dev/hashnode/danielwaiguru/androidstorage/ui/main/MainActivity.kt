package dev.hashnode.danielwaiguru.androidstorage.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import dev.hashnode.danielwaiguru.androidstorage.R
import dev.hashnode.danielwaiguru.androidstorage.adapters.PagerAdapter
import dev.hashnode.danielwaiguru.androidstorage.databinding.ActivityMainBinding
import dev.hashnode.danielwaiguru.androidstorage.ui.MainViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tiles: List<String> by lazy {
        resources.getStringArray(R.array.tab_tiles).toList()
    }
    private val pagerAdapter: PagerAdapter by lazy {
        PagerAdapter(tiles, supportFragmentManager, lifecycle)
    }
    //private val viewModel: MainViewModel by viewModels()
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
        }.attach()
    }
}