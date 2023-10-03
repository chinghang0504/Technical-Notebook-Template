# [Kotlin Note](../../README.md) - Chapter 7 Fragment with RecyclerView and ConstraintLayout
| Chapter | Title |
| :-: | :- |
| 7.1 | [Drawable (ic_solved.xml)](#71-drawable-ic_solvedxml) |
| 7.2 | [RecyclerView ViewHolder Layout (list_item_crime.xml)](#72-recyclerview-viewholder-layout-list_item_crimexml) |
| 7.3 | [RecyclerView Adapter Class (CrimeListAdapter.kt)](#73-recyclerview-adapter-class-crimelistadapterkt) |
| 7.4 | [Demonstration](#74-demonstration) |

<br />

## 7.1 Drawable (ic_solved.xml)
![](../../images/Part%20II/image_7_1.png)

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
  <path
      android:pathData="M5.07,1.11A6.19,6.19 0,0 0,3.65 12.7a0.57,0.57 0,0 1,0.32 0.44l0.19,1.25a0.62,0.62 0,0 0,0.61 0.63,16.41 16.41,0 0,0 3.29,0 0.62,0.62 0,0 0,0.61 -0.63l0.18,-1.23a0.61,0.61 0,0 1,0.35 -0.47A6.2,6.2 0,0 0,5.07 1.11ZM7,14H6.51a0.49,0.49 0,0 1,-0.38 0.19,0.51 0.51,0 1,1 0.38,-0.83H7a0.33,0.33 0,0 1,0.32 0.32A0.32,0.32 0,0 1,7 14ZM6.4,11a3.79,3.79 0,1 1,3.79 -3.79A3.79,3.79 0,0 1,6.4 11Z"
      android:fillColor="#111"/>
  <path
      android:pathData="M5.66,18.2l-0.21,-0.07a1,1 0,0 1,-0.69 -1.27l0.44,-1.5a1,1 0,0 1,1.27 -0.69l0.21,0.06A1,1 0,0 1,7.38 16l-0.44,1.5A1,1 0,0 1,5.66 18.2ZM6.27,15.33a0.33,0.33 0,0 0,-0.41 0.23l-0.44,1.5a0.33,0.33 0,0 0,0.22 0.41l0.22,0.06a0.33,0.33 0,0 0,0.41 -0.22l0.44,-1.5a0.33,0.33 0,0 0,-0.22 -0.41Z"
      android:fillColor="#111"/>
  <path
      android:pathData="M7.9,20.72l-0.17,0.13a1,1 0,0 1,-1.44 -0.2L5.35,19.4A1,1 0,0 1,5.55 18l0.18,-0.14a1,1 0,0 1,1.43 0.2l0.94,1.25A1,1 0,0 1,7.9 20.72ZM6,18.52A0.34,0.34 0,0 0,5.9 19l0.94,1.24a0.34,0.34 0,0 0,0.47 0.07l0.18,-0.14a0.33,0.33 0,0 0,0.06 -0.46l-0.94,-1.25a0.33,0.33 0,0 0,-0.47 -0.06Z"
      android:fillColor="#111"/>
  <path
      android:pathData="M11.12,20.79l0,0.22a1.07,1.07 0,0 1,-1 1.11l-1.7,0.14a1.08,1.08 0,0 1,-1.2 -0.93l0,-0.23a1.08,1.08 0,0 1,1 -1.11l1.71,-0.13A1.06,1.06 0,0 1,11.12 20.79ZM8,21.27a0.36,0.36 0,0 0,0.39 0.3l1.7,-0.14a0.36,0.36 0,0 0,0.34 -0.36l0,-0.22a0.35,0.35 0,0 0,-0.39 -0.3l-1.7,0.13A0.34,0.34 0,0 0,8 21Z"
      android:fillColor="#111"/>
  <path
      android:pathData="M22.19,12.33A6.19,6.19 0,0 0,11.5 17a0.61,0.61 0,0 1,-0.21 0.51l-1,0.79a0.62,0.62 0,0 0,-0.24 0.84A16.5,16.5 0,0 0,11.75 22a0.61,0.61 0,0 0,0.85 0.2l1.15,-0.47a0.63,0.63 0,0 1,0.58 0.06,6.19 6.19,0 0,0 7.86,-9.45ZM12.13,20.55l-0.26,-0.43a0.49,0.49 0,0 1,-0.35 -0.23,0.51 0.51,0 0,1 0.17,-0.69 0.51,0.51 0,0 1,0.69 0.18,0.48 0.48,0 0,1 0,0.42l0.26,0.43a0.32,0.32 0,0 1,-0.12 0.44A0.31,0.31 0,0 1,12.13 20.55ZM14.4,18.5a3.79,3.79 0,1 1,5.19 1.33A3.79,3.79 0,0 1,14.4 18.5Z"
      android:fillColor="#111"/>
</vector>
```

<br />

## 7.2 RecyclerView ViewHolder Layout (list_item_crime.xml)
![](../../images/Part%20II/image_7_2.png)

```xml
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/linearLayout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
        android:id="@+id/crime_title"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="8dp"
        android:text="Crime Title"
        android:textAppearance="@style/TextAppearance.MaterialComponents.Headline6"
        app:layout_constraintEnd_toStartOf="@+id/crime_solved"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/crime_date"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:text="Crime Date"
        app:layout_constraintEnd_toStartOf="@+id/crime_solved"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/crime_title" />

    <ImageView
        android:id="@+id/crime_solved"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/ic_solved" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

<br />

## 7.3 RecyclerView Adapter Class (CrimeListAdapter.kt)
```kotlin
package com.example.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.databinding.ListItemCrimeBinding

class CrimeHolder(val binding: ListItemCrimeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${crime.title} clicked!", Toast.LENGTH_SHORT).show()
        }

        binding.crimeSolved.visibility = if (crime.isSolved) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }
}

class CrimeListAdapter(private val crimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun getItemCount() = crimes.size

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }
}
```

<br />

## 7.4 Demonstration
After started the app
![](../../images/Part%20II/image_7_3.png)

<br />
