package dev.hashnode.danielwaiguru.androidstorage.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hashnode.danielwaiguru.androidstorage.databinding.PagerTitleItemBinding

class PagerAdapter(
    private val titles: List<String>): RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            PagerTitleItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bindItem(titles[position])
    }

    override fun getItemCount(): Int = titles.size

    inner class PagerViewHolder(
        private val binding: PagerTitleItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindItem(title: String) {
            with(binding) {
                tileTile.text = title
            }
        }
    }

}