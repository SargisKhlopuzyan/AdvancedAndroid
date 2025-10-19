package com.sargis.khlopuzyan.advancedandroid.workManager

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import java.util.UUID

class PhotoViewModel : ViewModel() {

    init {
        viewModelScope
    }

    var uncompressedUri: Uri? by mutableStateOf(null)
        private set

    var compressedBitmap: Bitmap? by mutableStateOf(null)
        private set

    var workId: UUID? by mutableStateOf(null)
        private set

    fun updateUncompressedUri(uri: Uri?) {
        println("PhotoViewModel -> updateUncompressedUri")
        uncompressedUri = uri
    }

    fun updateCompressedBitmap(bitmap: Bitmap?) {
        println("PhotoViewModel -> updateCompressedBitmap")
        compressedBitmap = bitmap
    }

    fun updateWorkId(uuId: UUID?) {
        println("PhotoViewModel -> updateWorkId")
        workId = uuId
    }

}