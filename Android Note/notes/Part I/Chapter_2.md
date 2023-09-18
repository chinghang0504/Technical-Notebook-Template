# [Kotlin Note](../../README.md) - Chapter 2 Single Activity with Data Class
| Chapter | Title |
| :-: | :- |
| 2.1 | [String Resources](#21-string-resources) |
| 2.2 | [Activity Layout (activity_main.xml)](#22-activity-layout-activity_mainxml) |
|  | [tools:text](#toolstext) |
| 2.3 | [Data Class (Question.kt)](#23-data-class-questionkt) |
|  | [@StringRes](#stringres) |
| 2.4 | [Activity Class (MainActivity.kt)](#24-activity-class-mainactivitykt) |
|  | [TextView: setText](#textview-settext) |
| 2.5 | [Demonstration](#25-demonstration) |

<br />

## 2.1 String Resources
```xml
<resources>
    <string name="app_name">GeoQuiz</string>
    <string name="question_australia">Canberra is the capital of Australia.</string>
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
</resources>
```

<br />

## 2.2 Activity Layout (activity_main.xml)
In preview
![](../../images/Part%20I/image_2_1.PNG)

In app
![](../../images/Part%20I/image_2_2.PNG)

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
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
        android:id="@+id/next_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/next_button"/>

</LinearLayout>
```

### [tools:text](https://developer.android.com/studio/write/tool-attributes#design-time_view_attributes)
- For example, if the android:text attribute value is set at runtime, or you want to see the layout with a value different than the default, you can add tools:text to specify some text for the layout preview only.

<br />

## 2.3 Data Class (Question.kt)
```kotlin
package com.example.geoquiz

import androidx.annotation.StringRes

data class Question(

    @StringRes val textResId: Int,
    val answer: Boolean
)
```

### [@StringRes](https://developer.android.com/reference/kotlin/androidx/annotation/StringRes)
- Denotes that an integer parameter, field or method return value is expected to be a String resource reference (e.g. android.R.string.ok).

<br />

## 2.4 Activity Class (MainActivity.kt)
```kotlin
package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

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
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.question_text_view)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)

        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
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

### [TextView: setText](https://developer.android.com/reference/kotlin/android/widget/TextView#settext_3)
```kotlin
fun setText(resid: Int): Unit
```
- Sets the text to be displayed using a string resource identifier.

<br />

## 2.5 Demonstration
After opened the app
![](../../images/Part%20I/image_2_3.PNG)

After clicked the next button
![](../../images/Part%20I/image_2_4.PNG)

<br />
