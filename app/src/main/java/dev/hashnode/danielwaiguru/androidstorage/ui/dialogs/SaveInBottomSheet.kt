package dev.hashnode.danielwaiguru.androidstorage.ui.dialogs

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import dev.hashnode.danielwaiguru.androidstorage.databinding.FragmentSaveInBottomShhetBinding
import dev.hashnode.danielwaiguru.androidstorage.ui.MainViewModel
import dev.hashnode.danielwaiguru.androidstorage.utils.getDate
@AndroidEntryPoint
class SaveInBottomSheet(private val data: Bitmap) : BottomSheetDialogFragment() {
    private var _binding: FragmentSaveInBottomShhetBinding? = null
    private val binding: FragmentSaveInBottomShhetBinding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSaveInBottomShhetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        radioButtonListeners()
    }
    private fun radioButtonListeners() {
        with(binding) {
            privateSave.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    saveImageInPrivateStorage()
                    dismiss()
                }
            }
            sharedSave.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    saveImageInSharedStorage()
                    dismiss()
                }
            }
        }
    }
    private fun saveImageInPrivateStorage() {
        val name = getDate()
        mainViewModel.saveImage(name, data)
    }
    private fun saveImageInSharedStorage() {
        val name = getDate()
    }
    companion object {
        fun newInstance(data: Bitmap): SaveInBottomSheet = SaveInBottomSheet(data)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}