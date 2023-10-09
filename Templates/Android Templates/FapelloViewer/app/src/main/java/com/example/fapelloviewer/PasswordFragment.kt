package com.example.fapelloviewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fapelloviewer.databinding.FragmentPasswordBinding
import kotlin.system.exitProcess

private const val PASSWORD = "5555"

class PasswordFragment : Fragment() {

    private var _binding: FragmentPasswordBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Error: binding is null"
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPasswordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val infoFragment = InfoFragment()
        val imageFragment = ImageFragment()

        binding.enterButton.setOnClickListener {
            if (binding.passwordEditText.text.toString() == PASSWORD) {
                activity?.let {
                    it.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, imageFragment)
                        .commit()
                }
            } else {
                Toast.makeText(context, "Incorrect Password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}