package com.example.fapelloviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fapelloviewer.databinding.FragmentInfoBinding
import kotlin.system.exitProcess

class InfoFragment : Fragment() {

    private val activityViewModel: MainActivityViewModel by activityViewModels()

    private var _binding: FragmentInfoBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Error: binding is null"
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageFragment = ImageFragment()

        binding.showButton.setOnClickListener {

            try {
//                activityViewModel.targetName = binding.targetNameEditText.text.toString()
//                activityViewModel.endIndex = binding.endIndexEditText.text.toString().toInt()

                activity?.let {
                    it.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, imageFragment)
                        .addToBackStack(null)
                        .commit()
                }

            } catch (e: Exception) {
                Toast.makeText(activity, "Incorrect Info", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}