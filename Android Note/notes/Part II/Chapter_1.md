# [Kotlin Note](../../README.md) - Chapter 1 Single Fragment with View Binding and android:name
| Chapter | Title |
| :-: | :- |
| 1.1 | [Fragment](#11-fragment) |
| 1.2 | [Gradle Script (build.gradle.kts)](#12-gradle-script-buildgradlekts) |
| 1.3 | [Manifest (AndroidManifest.xml)](#13-manifest-androidmanifestxml) |
| 1.4 | [String Resources (strings.xml)](#14-string-resources-stringsxml) |
| 1.5 | [Data Class (Crime.kt)](#15-data-class-crimekt) |
| 1.6 | [Fragment Layout (fragment_crime_detail.xml)](#16-fragment-layout-fragment_crime_detailxml) |
| 1.7 | [Fragment Class (CrimeDetailFragment.kt)](#17-fragment-class-crimedetailfragmentkt) |
|  | [Generated Binding Classes: inflate()](#generated-binding-classes-inflate) |
|  | [TextView: doOnTextChanged()](#textview-doontextchanged) |
|  | [CompoundButton: setOnCheckedChangeListener()](#compoundbutton-setoncheckedchangelistener) |
| 1.8 | [Activity Layout (activity_main.xml)](#18-activity-layout-activity_mainxml) |
|  | [FragmentContainerView: android:name](#fragmentcontainerview-androidname) |
| 1.9 | [Activity Class (MainActivity.kt)](#19-activity-class-mainactivitykt) |
| 1.10 | [Demonstration](#110-demonstration) |

<br />

## 1.1 [Fragment](https://developer.android.com/guide/fragments)
- A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events. Fragments can't live on their own. They must be hosted by an activity or another fragment. The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.

<br />

## 1.2 Gradle Script (build.gradle.kts)
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

## 1.3 Manifest (AndroidManifest.xml)
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.CriminalIntent"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

<br />

## 1.4 String Resources (strings.xml)
```xml
<resources>
    <string name="app_name">CriminalIntent</string>
    <string name="crime_title_hint">Enter a title for the crime.</string>
    <string name="crime_title_label">Title</string>
    <string name="crime_details_label">Details</string>
    <string name="crime_solved_label">Solved</string>
</resources>
```

<br />

## 1.5 Data Class (Crime.kt)
```kotlin
package com.example.criminalintent

import java.util.Date
import java.util.UUID

data class Crime(

    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)
```

<br />

## 1.6 Fragment Layout (fragment_crime_detail.xml)
![](../../images/Part%20II/image_1_1.png)

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:layout_margin="16dp">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAppearance="?attr/textAppearanceHeadline5"
        android:text="@string/crime_title_label"/>

    <EditText
        android:id="@+id/crime_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/crime_title_hint"
        android:importantForAutofill="no"
        android:inputType="text"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAppearance="?attr/textAppearanceHeadline5"
        android:text="@string/crime_details_label"/>

    <Button
        android:id="@+id/crime_date"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:text="Wed May 11 11:56 EST 2022"/>

    <CheckBox
        android:id="@+id/crime_solved"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/crime_solved_label"/>

</LinearLayout>
```

<br />

## 1.7 Fragment Class (CrimeDetailFragment.kt)
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

### [TextView: doOnTextChanged()](https://developer.android.com/reference/kotlin/androidx/core/widget/package-summary#(android.widget.TextView).doOnTextChanged(kotlin.Function4))
- Add an action which will be invoked when the text is changing.
```kotlin
inline fun TextView.doOnTextChanged(
    crossinline action: (CharSequence?, start: Int, before: Int, count: Int) -> Unit
): TextWatcher
```

### [CompoundButton: setOnCheckedChangeListener()](https://developer.android.com/reference/kotlin/android/widget/CompoundButton#setoncheckedchangelistener)
- Register a callback to be invoked when the checked state of this button changes.
```kotlin
open fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener?): Unit
```

<br />

## 1.8 Activity Layout (activity_main.xml)
![](../../images/Part%20II/image_1_2.png)

```xml
<androidx.fragment.app.FragmentContainerView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/fragment_container"
    android:name="com.example.criminalintent.CrimeDetailFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"/>
```

### [FragmentContainerView: android:name](https://developer.android.com/reference/androidx/fragment/app/FragmentContainerView)
- FragmentContainerView can also be used to add a Fragment by using the android:name attribute.

<br />

## 1.9 Activity Class (MainActivity.kt)
```kotlin
package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```

<br />

## 1.10 Demonstration
After started the app
![](../../images/Part%20II/image_1_3.png)

<br />
