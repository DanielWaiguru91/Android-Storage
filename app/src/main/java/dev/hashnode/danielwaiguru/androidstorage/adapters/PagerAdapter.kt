package dev.hashnode.danielwaiguru.androidstorage.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.hashnode.danielwaiguru.androidstorage.ui.private_storage.PrivateStorageFragment
import dev.hashnode.danielwaiguru.androidstorage.ui.shared_storage.SharedStorageFragment

class PagerAdapter(
    private val tiles: List<String>, fragmentManager: FragmentManager, lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragments = listOf(PrivateStorageFragment(), SharedStorageFragment())
    override fun getItemCount(): Int = tiles.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}