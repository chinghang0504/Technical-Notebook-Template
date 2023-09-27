# [Kotlin Note](../../README.md) - Chapter 2 Fragment with View Binding
| Chapter | Title |
| :-: | :- |
| 2.1 | [Gradle Script (build.gradle.kts)](#21-gradle-script-buildgradlekts) |
| 2.2 | [Fragment Class (CrimeDetailFragment.kt)](#22-fragment-class-crimedetailfragmentkt) |
|  | [Generated Binding Classes: inflate()](#generated-binding-classes-inflate) |
| 2.3 | [Demonstration](#23-demonstration) |

<br />

## 2.1 Gradle Script (build.gradle.kts)
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
}
```

<br />

## 2.2 Fragment Class (CrimeDetailFragment.kt)
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

    private lateinit var binding: FragmentCrimeDetailBinding

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
        binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
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
}
```

### [Generated Binding Classes: inflate()](https://developer.android.com/topic/libraries/data-binding/generated-binding#create)
- There is an alternate version of the inflate() method that takes a ViewGroup object in addition to the LayoutInflater object.
```java
public static @NonNull com.example.criminalintent.databinding.FragmentCrimeDetailBinding inflate(
    @NonNull android.view.LayoutInflater inflater,
    @Nullable android.view.ViewGroup parent,
    boolean attachToParent
)
```

<br />

## 2.3 Demonstration
After started the app
![](../../images/Part%20II/image_2_1.png)

<br />
