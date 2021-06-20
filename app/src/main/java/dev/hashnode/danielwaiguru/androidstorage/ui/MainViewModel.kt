package dev.hashnode.danielwaiguru.androidstorage.ui

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hashnode.danielwaiguru.androidstorage.domain.repos.ImageRepository
import dev.hashnode.danielwaiguru.androidstorage.models.InternalStoragePhoto
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val imageRepo: ImageRepository): ViewModel() {
    private val _images: MutableLiveData<List<InternalStoragePhoto>> = MutableLiveData()
    val images: LiveData<List<InternalStoragePhoto>> get() = _images
    fun getImages() {
        viewModelScope.launch {
            _images.value = imageRepo.loadImages()
        }
    }
    fun saveImage(filename: String, bitmap: Bitmap) {
        imageRepo.saveImage(filename, bitmap)
    }
    fun deleteImage(filename: String) {
        imageRepo.deleteImage(filename)
    }
}