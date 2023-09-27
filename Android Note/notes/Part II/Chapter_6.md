# [Kotlin Note](../../README.md) - Chapter 6 Fragment with ViewModel and RecyclerView
| Chapter | Title |
| :-: | :- |
| 6.1 | [Gradle Script (build.gradle.kts)](#61-gradle-script-buildgradlekts) |
| 6.2 | [Fragment ViewModel (CrimeListViewModel.kt)](#62-fragment-viewmodel-crimelistviewmodelkt) |
| 6.3 | [Fragment Layout (fragment_crime_list.xml)](#63-fragment-layout-fragment_crime_listxml) |
| 6.4 | [Fragment Class (CrimeListFragment.kt)](#64-fragment-class-crimelistfragmentkt) |
| 6.5 | [Activity Layout (activity_main.xml)](#65-activity-layout-activity_mainxml) |
| 6.6 | [RecyclerView ViewHolder Layout (list_item_crime.xml)](#66-recyclerview-viewholder-layout-list_item_crimexml) |
| 6.7 | [RecyclerView Adapter (CrimeListAdapter.kt)](#67-recyclerview-adapter-crimelistadapterkt) |
| 6.8 | [Demonstration](#68-demonstration) |

<br />

## 6.1 Gradle Script (build.gradle.kts)
```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.criminalintent"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.criminalintent"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
}
```

<br />

## 6.2 Fragment ViewModel (CrimeListViewModel.kt)
```kotlin
package com.example.criminalintent

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = Date(),
                isSolved = i % 2 == 0
            )

            crimes += crime
        }
    }
}
```

<br />

## 6.3 Fragment Layout (fragment_crime_list.xml)
![](../../images/Part%20II/image_6_1.png)

```xml
<androidx.recyclerview.widget.RecyclerView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/crime_recycler_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

<br />

## 6.4 Fragment Class (CrimeListFragment.kt)
```kotlin
package com.example.criminalintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.criminalintent.databinding.FragmentCrimeListBinding

class CrimeListFragment : Fragment() {

    private var _binding: FragmentCrimeListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val crimeListViewModel: CrimeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrimeListBinding.inflate(layoutInflater, container, false)

        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        val crimes = crimeListViewModel.crimes
        val adapter = CrimeListAdapter(crimes)
        binding.crimeRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
```

<br />

## 6.5 Activity Layout (activity_main.xml)
![](../../images/Part%20II/image_6_2.png)

```xml
<androidx.fragment.app.FragmentContainerView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/fragment_container"
    android:name="com.example.criminalintent.CrimeListFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"/>
```

<br />

## 6.6 RecyclerView ViewHolder Layout (list_item_crime.xml)
![](../../images/Part%20II/image_6_3.png)

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="8dp">

    <TextView
        android:id="@+id/crime_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Crime Title"/>

    <TextView
        android:id="@+id/crime_date"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Crime Date"/>

</LinearLayout>
```

<br />

## 6.7 RecyclerView Adapter (CrimeListAdapter.kt)
```kotlin
package com.example.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.databinding.ListItemCrimeBinding

class CrimeHolder(val binding: ListItemCrimeBinding) : RecyclerView.ViewHolder(binding.root) {
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
        holder.apply {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
        }
    }
}
```

<br />

## 6.8 Demonstration
After started the app
![](../../images/Part%20II/image_6_4.png)

<br />
