package dev.hashnode.danielwaiguru.androidstorage.ui.dialogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.hashnode.danielwaiguru.androidstorage.R

class SaveInBottomSheet : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_save_in_bottom_shhet, container, false)
    }

}