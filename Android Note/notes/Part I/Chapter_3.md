# [Kotlin Note](../../README.md) - Chapter 3 Single Activity with View Binding
| Chapter | Title |
| :-: | :- |
| 3.1 | [View Binding](#31-view-binding) |
| 3.2 | [Gradle Script (build.gradle.kts)](#32-gradle-script-buildgradlekts) |
| 3.3 | [Activity Class (MainActivity.kt)](#33-activity-class-mainactivitykt) |
|  | [Generated Binding Classes: inflate()](#generated-binding-classes-inflate) |
|  | [Generated Binding Classes: root](#generated-binding-classes-root) |
|  | [Activity: setContentView()](#activity-setcontentview) |
| 3.4 | [Demonstration](#34-demonstration) |

<br />

## 3.1 [View Binding](https://developer.android.com/topic/libraries/view-binding)
- View binding is a feature that makes it easier to write code that interacts with views. Once view binding is enabled in a module, it generates a binding class for each XML layout file present in that module. An instance of a binding class contains direct references to all views that have an ID in the corresponding layout.

<br />

## 3.2 Gradle Script (build.gradle.kts)
```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.geoquiz"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.geoquiz"
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

## 3.3 Activity Class (MainActivity.kt)
```kotlin
package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textRestId
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}
```

### [Generated Binding Classes: inflate()](https://developer.android.com/topic/libraries/data-binding/generated-binding#create)
- The binding object is created immediately after inflating the layout to make sure the view hierarchy isn't modified before it binds to the views with expressions within the layout. The most common method to bind the object to a layout is to use the static methods on the binding class. You can inflate the view hierarchy and bind the object to it by using the inflate() method of the binding class.
```java
public static @NonNull com.example.geoquiz.databinding.ActivityMainBinding inflate(     @NonNull android.view.LayoutInflater inflater )
```

### [Generated Binding Classes: root](https://developer.android.com/topic/libraries/data-binding/generated-binding#create)
```kotlin
public android.widget.LinearLayout getRoot()
```

### [Activity: setContentView()](https://developer.android.com/reference/kotlin/android/app/Activity#setcontentview_1)
- Set the activity content to an explicit view. This view is placed directly into the activity's view hierarchy. It can itself be a complex view hierarchy. When calling this method, the layout parameters of the specified view are ignored. Both the width and the height of the view are set by default to ViewGroup.LayoutParams#MATCH_PARENT. To use your own layout parameters, invoke setContentView(android.view.View,android.view.ViewGroup.LayoutParams) instead.
```kotlin
open fun setContentView(view: View!): Unit
```

<br />

## 3.4 Demonstration
After started the app
![](../../images/Part%20I/image_3_1.PNG)

After clicked the next button
![](../../images/Part%20I/image_3_2.PNG)

<br />
