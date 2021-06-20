package dev.hashnode.danielwaiguru.androidstorage.domain.repos

import android.graphics.Bitmap
import dev.hashnode.danielwaiguru.androidstorage.models.InternalStoragePhoto

interface ImageRepository {
    fun deleteImage(filename: String): Boolean
    fun saveImage(filename: String, bitmap: Bitmap): Boolean
    suspend fun loadImages(): List<InternalStoragePhoto>
}