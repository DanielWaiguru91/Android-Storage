package dev.hashnode.danielwaiguru.androidstorage.ui.private_storage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.hashnode.danielwaiguru.androidstorage.adapters.InternalStoragePhotoAdapter
import dev.hashnode.danielwaiguru.androidstorage.databinding.FragmentPrivateStorageBinding
import dev.hashnode.danielwaiguru.androidstorage.ui.MainViewModel

@AndroidEntryPoint
class PrivateStorageFragment : Fragment() {
    private var _binding: FragmentPrivateStorageBinding? = null
    private val binding: FragmentPrivateStorageBinding get() = _binding!!
    private val internalStorageAdapter: InternalStoragePhotoAdapter by lazy {
        InternalStoragePhotoAdapter {

        }
    }
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrivateStorageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        dataObservers()
    }
    private fun dataObservers() {
        mainViewModel.images.observe(viewLifecycleOwner, {
            Log.d("Private", it.toString())
            internalStorageAdapter.submitList(it)
        })
    }
    private fun setupRv() {
        binding.privateRv.apply {
            adapter = internalStorageAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}