package com.example.fapelloviewer

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel

class ImageFragmentViewModel: ViewModel() {

    var currentIndex: Int = 1
    private val imageMap: MutableMap<Int, Drawable> = mutableMapOf()

    fun getImage(): Drawable? {
        return imageMap[currentIndex]
    }

    fun saveImage(drawable: Drawable) {
        imageMap += (currentIndex to drawable)
    }
}