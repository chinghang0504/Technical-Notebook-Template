# [Kotlin Note](../../README.md) - Chapter 1 Single Activity
| Chapter | Title |
| :-: | :- |
| 1.1 | [Activity](#11-activity) |
| 1.2 | [Gradle Script (build.gradle.kts)](#12-gradle-script-buildgradlekts) |
| 1.3 | [Manifest (AndroidManifest.xml)](#13-manifest-androidmanifestxml) |
| 1.4 | [String Resources (strings.xml)](#14-string-resources-stringsxml) |
| 1.5 | [Activity Layout (activity_main.xml)](#15-activity-layout-activity_mainxml) |
| 1.6 | [Activity Class (MainActivity.kt)](#16-activity-class-mainactivitykt) |
|  | [Activity: setContentView()](#activity-setcontentview) |
|  | [Activity: findViewById()](#activity-findviewbyid) |
|  | [View: setOnClickListener()](#view-setonclicklistener) |
|  | [Toast: makeText()](#toast-maketext) |
|  | [Toast: show()](#toast-show) |
| 1.7 | [Demonstration](#17-demonstration) |

<br />

## 1.1 [Activity](https://developer.android.com/reference/kotlin/android/app/Activity)
- An activity is a single, focused thing that the user can do. Almost all activities interact with the user, so the Activity class takes care of creating a window for you in which you can place your UI with #setContentView. While activities are often presented to the user as full-screen windows, they can also be used in other ways: as floating windows (via a theme with android.R.attr#windowIsFloating set), Multi-Window mode or embedded into other windows. There are two methods almost all subclasses of Activity will implement:

    1. #onCreate is where you initialize your activity. Most importantly, here you will usually call setContentView(int) with a layout resource defining your UI, and using findViewById to retrieve the widgets in that UI that you need to interact with programmatically.

    2. onPause is where you deal with the user pausing active interaction with the activity. Any changes made by the user should at this point be committed (usually to the android.content.ContentProvider holding the data). In this state the activity is still visible on screen.

<br />

## 1.2 Gradle Script (build.gradle.kts)
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
        android:theme="@style/Theme.GeoQuiz"
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
    <string name="app_name">GeoQuiz</string>
    <string name="question_text">Canberra is the capital of Australia</string>
    <string name="true_button">True</string>
    <string name="false_button">False</string>
    <string name="correct_toast">Correct!</string>
    <string name="incorrect_toast">Incorrect!</string>
</resources>
```

<br />

## 1.5 Activity Layout (activity_main.xml)
![](../../images/Part%20I/image_1_1.PNG)

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="24dp"
        android:text="@string/question_text"/>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/true_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/true_button"/>

        <Button
            android:id="@+id/false_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/false_button"/>

    </LinearLayout>

</LinearLayout>
```

<br />

## 1.6 Activity Class (MainActivity.kt)
```kotlin
package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener {
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show()
        }
        falseButton.setOnClickListener {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show()
        }
    }
}
```

### [Activity: setContentView()](https://developer.android.com/reference/kotlin/android/app/Activity#setcontentview)
- Set the activity content from a layout resource. The resource will be inflated, adding all top-level views to the activity.
```kotlin
open fun setContentView(layoutResID: Int): Unit
```

### [Activity: findViewById()](https://developer.android.com/reference/kotlin/android/app/Activity#findviewbyid)
- Finds a view that was identified by the android:id XML attribute that was processed in #onCreate.
```kotlin
open fun <T : View!> findViewById(id: Int): T
```

### [View: setOnClickListener()](https://developer.android.com/reference/kotlin/android/view/View#setonclicklistener)
- Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
```kotlin
open fun setOnClickListener(l: View.OnClickListener?): Unit
```

### [Toast: makeText()](https://developer.android.com/reference/kotlin/android/widget/Toast#maketext_1)
- Make a standard toast that just contains text from a resource.
```kotlin
open static fun makeText(
    context: Context!, 
    resId: Int, 
    duration: Int
): Toast!
```

### [Toast: show()](https://developer.android.com/reference/kotlin/android/widget/Toast#show)
- Show the view for the specified duration.
```kotlin
open fun show(): Unit
```

<br />

## 1.7 Demonstration
After started the app
![](../../images/Part%20I/image_1_2.PNG)

After clicked the true button
![](../../images/Part%20I/image_1_3.PNG)

After clicked the false button
![](../../images/Part%20I/image_1_4.PNG)

<br />
