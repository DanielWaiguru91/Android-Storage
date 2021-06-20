package dev.hashnode.danielwaiguru.androidstorage.data.repos

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import dev.hashnode.danielwaiguru.androidstorage.domain.repos.ImageRepository
import dev.hashnode.danielwaiguru.androidstorage.models.InternalStoragePhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.io.IOException
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(private val context: Context): ImageRepository {
    override fun deleteImage(filename: String): Boolean =
        try {
            context.deleteFile(filename)
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }

    override fun saveImage(filename: String, bitmap: Bitmap): Boolean = try {
        context.openFileOutput("$filename.jpg", MODE_PRIVATE).use { fileOutputStream ->
            if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream)) {
                throw IOException("Could not compress the file")
            }
        }
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }

    override suspend fun loadImages(): List<InternalStoragePhoto> = withContext(Dispatchers.IO) {
        context.filesDir?.listFiles()?.filter { file ->
            file.canRead() && file.isFile && file.name.endsWith(".jpg")
        }?.map {
            val bytes = it.readBytes()
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            InternalStoragePhoto(it.name, bitmap)
        } ?: listOf()
    }
}