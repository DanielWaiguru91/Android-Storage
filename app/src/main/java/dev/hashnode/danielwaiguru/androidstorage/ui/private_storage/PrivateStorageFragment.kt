package dev.hashnode.danielwaiguru.androidstorage.ui.private_storage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.hashnode.danielwaiguru.androidstorage.adapters.InternalStoragePhotoAdapter
import dev.hashnode.danielwaiguru.androidstorage.databinding.FragmentPrivateStorageBinding
import dev.hashnode.danielwaiguru.androidstorage.ui.MainViewModel
import dev.hashnode.danielwaiguru.androidstorage.ui.dialogs.SaveInBottomSheet
import dev.hashnode.danielwaiguru.androidstorage.utils.takePicture

@AndroidEntryPoint
class PrivateStorageFragment : Fragment() {
    private var _binding: FragmentPrivateStorageBinding? = null
    private val binding: FragmentPrivateStorageBinding get() = _binding!!

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        val saveInSheet = SaveInBottomSheet.newInstance(it)
        saveInSheet.show(childFragmentManager, null)
    }
    private val mainViewModel: MainViewModel by viewModels()
    private val internalStorageAdapter: InternalStoragePhotoAdapter by lazy {
        InternalStoragePhotoAdapter {
            mainViewModel.deleteImage(it.name)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrivateStorageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.getImages()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        dataObservers()
        setupListeners()
    }

    private fun setupListeners() {
        binding.takePicture.setOnClickListener {
            takePicture.launch()
        }
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