# [Kotlin Note](../../README.md) - Chapter 3 Fragment View Binding Problem
| Chapter | Title |
| :-: | :- |
| 3.1 | [Problem: Unable to Free Memory of Fragment Views](#31-problem-unable-to-free-memory-of-fragment-views) |
| 3.2 | [Fragment Class (CrimeDetailFragment.kt)](#32-fragment-class-crimedetailfragmentkt) |

<br />

## 3.1 Problem: Unable to Free Memory of Fragment Views
- Since the fragment holds a reference to the binding property, the system will not free the memory of fragment views.

<br />

## 3.2 Fragment Class (CrimeDetailFragment.kt)
```kotlin
package com.example.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.criminalintent.databinding.FragmentCrimeDetailBinding
import java.util.Date
import java.util.UUID

class CrimeDetailFragment : Fragment() {

    private var _binding: FragmentCrimeDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private lateinit var crime: Crime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            crimeTitle.doOnTextChanged { text, start, before, count ->
                crime = crime.copy(title = text.toString())
            }

            crimeDate.apply {
                text = crime.date.toString()
                isEnabled = false
            }

            crimeSolved.setOnCheckedChangeListener { compoundButton, b ->
                crime = crime.copy(isSolved = b)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
```

<br />
