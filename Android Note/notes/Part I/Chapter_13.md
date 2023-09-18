# [Kotlin Note](../../README.md) - Chapter 13 Fragment View Binding Problem
| Chapter | Title |
| :-: | :- |
| 13.1 | [Problem: Fragment View Binding](#131-problem-fragment-view-binding) |
| 13.2 | [Fragment Class (CrimeDetailFragment.kt)](#132-fragment-class-crimedetailfragmentkt) |
|  | [Checks: checkNotNull](#checks-checknotnull) |

<br />

## 13.1 Problem: Fragment View Binding
- The OS cannot free the fragment view in the memory, because the app are holding a reference to the binding property.

<br />

## 13.2 Fragment Class (CrimeDetailFragment.kt)
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            crimeTitle.doOnTextChanged { text, _, _, _ ->
                crime = crime.copy(title = text.toString())
            }

            crimeDate.apply {
                text = crime.date.toString()
                isEnabled = false
            }

            crimeSolved.setOnCheckedChangeListener { _, b ->
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

### [Checks: checkNotNull](https://developer.android.com/reference/kotlin/androidx/test/espresso/intent/Checks#checkNotNull(T,java.lang.Object))
```kotlin
java-static fun <T> checkNotNull(reference: T!, errorMessage: Any!): T!
```

<br />
