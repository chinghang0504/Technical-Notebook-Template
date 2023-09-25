# [Kotlin Note](../../README.md) - Chapter 6 Single Activity with ViewModel
| Chapter | Title |
| :-: | :- |
| 6.1 | [Problem: Configuration Changes](#61-problem-configuration-changes) |
|  | [Activity Recreation](#activity-recreation) |
|  | [Screen Orientation Change](#screen-orientation-change) |
| 6.2 | [ViewModel](#62-viewmodel) |
| 6.3 | [Gradle Script (build.gradle.kts)](#63-gradle-script-buildgradlekts) |
| 6.4 | [Activity ViewModel (QuizViewModel.kt)](#64-activity-viewmodel-quizviewmodelkt) |
| 6.5 | [Activity Class (MainActivity.kt)](#65-activity-class-mainactivitykt) |
| 6.6 | [Demonstration](#66-demonstration) |

<br />

## 6.1 [Problem: Configuration Changes](https://developer.android.com/guide/topics/resources/runtime-changes)
- Some device configurations can change while the app is running. These include, but aren't limited to:
    1. App display size
    2. Screen orientation
    3. Font size and weight
    4. Locale
    5. Dark mode versus light mode
    6. Keyboard availability

### [Activity Recreation](https://developer.android.com/guide/topics/resources/runtime-changes#activity-recreation)
- The system recreates an Activity when a configuration change occurs. To do this, the system calls onDestroy() and destroys the existing Activity instance. It then creates a new instance using onCreate(), and this new Activity instance is initialized with the new, updated configuration. This also means that the system also recreates the UI with the new configuration.

- The recreation behavior helps your application adapt to new configurations by automatically reloading your application with alternative resources that match the new device configuration.

### Screen Orientation Change
After started the app
![](../../images/Part%20I/image_6_1.png)

After clicked the next button
![](../../images/Part%20I/image_6_2.png)

After rotated the screen
![](../../images/Part%20I/image_6_3.png)

<br />

## 6.2 [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- The ViewModel class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic. Its principal advantage is that it caches state and persists it through configuration changes. This means that your UI doesn’t have to fetch data again when navigating between activities, or following configuration changes, such as when rotating the screen.

<br />

## 6.3 Gradle Script (build.gradle.kts)
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
    implementation("androidx.activity:activity-ktx:1.7.2")
}
```

<br />

## 6.4 Activity ViewModel (QuizViewModel.kt)
```kotlin
package com.example.geoquiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textRestId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}
```

<br />

## 6.5 Activity Class (MainActivity.kt)
```kotlin
package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Calling onCreate()")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Calling onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Calling onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Calling onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Calling onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Calling onDestroy()")
    }
}
```

<br />

## 6.6 Demonstration
After started the app
![](../../images/Part%20I/image_6_4.png)

After clicked the next button
![](../../images/Part%20I/image_6_5.png)

After rotated the app
![](../../images/Part%20I/image_6_6.png)

<br />
