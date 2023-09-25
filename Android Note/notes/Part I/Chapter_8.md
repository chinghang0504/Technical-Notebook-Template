# [Kotlin Note](../../README.md) - Chapter 8 Multiple Activities
| Chapter | Title |
| :-: | :- |
| 8.1 | [Manifest (AndroidManifest.xml)](#81-manifest-androidmanifestxml) |
| 8.2 | [String Resources (strings.xml)](#82-string-resources-stringsxml) |
| 8.3 | [Activity Layout (activity_cheat.xml)](#83-activity-layout-activity_cheatxml) |
|  | [tools:context](#toolscontext) |
| 8.4 | [Activity Class (CheatActivity.kt)](#84-activity-class-cheatactivitykt) |
| 8.5 | [Activity Layout (activity_main.xml)](#85-activity-layout-activity_mainxml) |
| 8.6 | [Activity Class (MainActivity.kt)](#86-activity-class-mainactivitykt) |
|  | [Intent: Intent()](#intent-intent) |
|  | [Activity: startActivity()](#activity-startactivity) |
| 8.7 | [Demonstration](#87-demonstration) |

<br />

## 8.1 Manifest (AndroidManifest.xml)
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
            android:name=".CheatActivity"
            android:exported="false" />
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

## 8.2 String Resources (strings.xml)
```xml
<resources>
    <string name="app_name">GeoQuiz</string>
    <string name="question_australia">Canberra is the capital of Australia</string>
    <string name="question_oceans">The Pacific Ocean is larger than the Atlantic Ocean.</string>
    <string name="question_mideast">The Suez Canal connects the Red Sea and the Indian Ocean.</string>
    <string name="question_africa">The source of the Nile River is in Egypt.</string>
    <string name="question_americas">The Amazon River is the longest river in the Americas.</string>
    <string name="question_asia">Lake Baikal is the world\'s oldest and deepest freshwater lake.</string>
    <string name="true_button">True</string>
    <string name="false_button">False</string>
    <string name="next_button">Next</string>
    <string name="correct_toast">Correct!</string>
    <string name="incorrect_toast">Incorrect!</string>
    <string name="warning_text">Are you sure you want to do this?</string>
    <string name="show_answer_button">Show Answer</string>
    <string name="cheat_button">Cheat!</string>
    <string name="judgment_toast">Cheating is wrong.</string>
</resources>
```

<br />

## 8.3 Activity Layout (activity_cheat.xml)
![](../../images/Part%20I/image_8_1.PNG)

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical"
    tools:context=".CheatActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="24dp"
        android:text="@string/warning_text"/>

    <TextView
        android:id="@+id/answer_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="24dp"
        tools:text="Answer"/>

    <Button
        android:id="@+id/show_answer_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/show_answer_button"/>

</LinearLayout>
```

### [tools:context](https://developer.android.com/studio/write/tool-attributes#toolscontext)
- This attribute declares which activity this layout is associated with by default. This enables features in the editor or layout preview that require knowledge of the activity, such as what the layout theme is in the preview and where to insert onClick handlers generated from a quickfix.

<br />

## 8.4 Activity Class (CheatActivity.kt)
```kotlin
package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geoquiz.databinding.ActivityCheatBinding

class CheatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
```

<br />

## 8.5 Activity Layout (activity_main.xml)
![](../../images/Part%20I/image_8_2.PNG)

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/question_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:padding="24dp"
        tools:text="@string/question_australia"/>

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

    <Button
        android:id="@+id/cheat_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/cheat_button"/>

    <Button
        android:id="@+id/next_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/next_button"
        app:icon="@drawable/arrow_right"
        app:iconGravity="end"/>

</LinearLayout>
```

<br />

## 8.6 Activity Class (MainActivity.kt)
```kotlin
package com.example.geoquiz

import android.content.Intent
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
        binding.cheatButton.setOnClickListener {
            val intent = Intent(this, CheatActivity::class.java)
            startActivity(intent)
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

### [Intent: Intent()](https://developer.android.com/reference/kotlin/android/content/Intent#intent_5)
- Create an intent for a specific component. All other fields (action, data, type, class) are null, though they can be modified later with explicit calls. This provides a convenient way to create an intent that is intended to execute a hard-coded class name, rather than relying on the system to find an appropriate class for you; see setComponent for more information on the repercussions of this.
```kotlin
Intent(
    packageContext: Context!, 
    cls: Class<*>!)
```

### [Activity: startActivity()](https://developer.android.com/reference/kotlin/android/app/Activity#startactivity)
- Same as #startActivity(android.content.Intent,android.os.Bundle) with no options specified.
```kotlin
open fun startActivity(intent: Intent!): Unit
```

<br />

## 8.7 Demonstration
After started the app
![](../../images/Part%20I/image_8_3.PNG)

After clicked the cheat button
![](../../images/Part%20I/image_8_4.PNG)

<br />
