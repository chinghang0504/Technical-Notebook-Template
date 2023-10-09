package com.example.fapelloviewer

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.fapelloviewer.databinding.FragmentImageBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.FileNotFoundException
import java.io.InputStream
import java.net.URL
import kotlin.system.exitProcess

private const val TAG = "ImageFragment"

class ImageFragment : Fragment() {

    private val viewModel: ImageFragmentViewModel by viewModels()
    private val activityViewModel: MainActivityViewModel by activityViewModels()
    private var _binding: FragmentImageBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Error: binding is null"
        }

    private val url: String = "https://fapello.com/content/h/e/%s/1000/%s_%s.jpg"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentImageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityViewModel.targetName = "heatheredeffect-2"
        activityViewModel.endIndex = 337

        binding.imageView.setOnTouchListener(object: OnSwipeTouchListener(context) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                showNextImage()
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                showPreviousImage()
            }
        })

        showImage()
    }

    private fun showImage() {
        var drawable: Drawable? = viewModel.getImage()
        if (drawable != null) {
            Log.d(TAG, "Getting image from the map")
            binding.imageView.setImageDrawable(drawable)
            return
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val numberString: String = viewModel.currentIndex.toString().padStart(4, '0')
                val inputStream: InputStream = URL(String.format(url, activityViewModel.targetName, activityViewModel.targetName, numberString)).content as InputStream
                val drawable: Drawable = Drawable.createFromStream(inputStream, null) ?: throw FileNotFoundException()

                Log.d(TAG, "Saving image to the map")
                viewModel.saveImage(drawable)

                CoroutineScope(Dispatchers.Main).launch {
                    binding.imageView.setImageDrawable(drawable)
                }
            } catch (e: FileNotFoundException) {
                Looper.prepare();
                Toast.makeText(activity, "File not found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showNextImage() {
        viewModel.currentIndex = if (viewModel.currentIndex == activityViewModel.endIndex) 1 else viewModel.currentIndex + 1
        showImage()
    }

    private fun showPreviousImage() {
        viewModel.currentIndex = if (viewModel.currentIndex == 1) activityViewModel.endIndex else viewModel.currentIndex - 1
        showImage()
    }
}