package dev.hashnode.danielwaiguru.androidstorage.utils

import android.graphics.Bitmap
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

fun Fragment.takePicture(): ActivityResultLauncher<Void> =
    registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        //block(it)
    }