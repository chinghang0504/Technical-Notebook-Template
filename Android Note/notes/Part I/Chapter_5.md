# [Kotlin Note](../../README.md) - Chapter 5 Activity Lifecycle
| Chapter | Title |
| :-: | :- |
| 5.1 | [Activity Lifecycle](#51-activity-lifecycle) |
| 5.2 | [Activity Lifecycle Callbacks](#52-activity-lifecycle-callbacks) |
|  | [onCreate](#oncreate) |
|  | [onStart](#onstart) |
|  | [onResume](#onresume) |
|  | [onPause](#onpause) |
|  | [onStop](#onstop) |
|  | [onDestroy](#ondestroy) |
| 5.3 | [Activity Protected Methods](#53-activity-protected-methods) |
|  | [Activity: onCreate](#activity-oncreate) |
|  | [Activity: onStart](#activity-onstart) |
|  | [Activity: onResume](#activity-onresume) |
|  | [Activity: onPause](#activity-onpause) |
|  | [Activity: onStop](#activity-onstop) |
|  | [Activity: onDestroy](#activity-ondestroy) |
|  | [Activity: onRestart](#activity-onrestart) |
| 5.4 | [Typical Cases](#54-typical-cases) |
|  | [Activity Class (MainActivity.kt)](#activity-class-mainactivitykt) |
|  | [Log: d](#log-d) |

<br />

## 5.1 [Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)
![](../../images/Part%20I/image_5_1.png)
- As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle. The Activity class provides a number of callbacks that let the activity know when a state changes or that the system is creating, stopping, or resuming an activity or destroying the process the activity resides in.

<br />

## 5.2 [Activity Lifecycle Callbacks](https://developer.android.com/guide/components/activities/activity-lifecycle#lc)

### [onCreate](https://developer.android.com/guide/components/activities/activity-lifecycle#oncreate)
- You must implement this callback, which fires when the system first creates the activity. On activity creation, the activity enters the Created state. In the onCreate() method, perform basic application startup logic that happens only once for the entire life of the activity.

### [onStart](https://developer.android.com/guide/components/activities/activity-lifecycle#onstart)
- When the activity enters the Started state, the system invokes onStart(). This call makes the activity visible to the user as the app prepares for the activity to enter the foreground and become interactive. For example, this method is where the code that maintains the UI is initialized.

### [onResume](https://developer.android.com/guide/components/activities/activity-lifecycle#onresume)
- When the activity enters the Resumed state, it comes to the foreground, and the system invokes the onResume() callback. This is the state in which the app interacts with the user. The app stays in this state until something happens to take focus away from the app, such as the device receiving a phone call, the user navigating to another activity, or the device screen turning off.

### [onPause](https://developer.android.com/guide/components/activities/activity-lifecycle#onpause)
- The system calls this method as the first indication that the user is leaving your activity, though it does not always mean the activity is being destroyed. It indicates that the activity is no longer in the foreground, but it is still visible if the user is in multi-window mode. There are several reasons why an activity might enter this state:
    - An event that interrupts app execution, as described in the section about the onResume() callback, pauses the current activity. This is the most common case.
    - In multi-window mode, only one app has focus at any time, and the system pauses all the other apps.
    - The opening of a new, semi-transparent activity, such as a dialog, pauses the activity it covers. As long as the activity is partially visible but not in focus, it remains paused.

### [onStop](https://developer.android.com/guide/components/activities/activity-lifecycle#onstop)
- When your activity is no longer visible to the user, it enters the Stopped state, and the system invokes the onStop() callback. This can occur when a newly launched activity covers the entire screen. The system also calls onStop() when the activity finishes running and is about to be terminated.

### [onDestroy](https://developer.android.com/guide/components/activities/activity-lifecycle#ondestroy)
- onDestroy() is called before the activity is destroyed. The system invokes this callback for one of two reasons:
    1. The activity is finishing, due to the user completely dismissing the activity or due to finish() being called on the activity.
    2. The system is temporarily destroying the activity due to a configuration change, such as device rotation or entering multi-window mode.

<br />

## 5.3 Activity Protected Methods
### [Activity: onCreate](https://developer.android.com/reference/kotlin/android/app/Activity#oncreate_1)
```kotlin
protected open fun onCreate(savedInstanceState: Bundle?): Unit
```
- Called when the activity is starting. This is where most initialization should go: calling setContentView(int) to inflate the activity's UI, using findViewById to programmatically interact with widgets in the UI, calling managedQuery(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String) to retrieve cursors for data being displayed, etc.

### [Activity: onStart](https://developer.android.com/reference/kotlin/android/app/Activity#onstart)
```kotlin
protected open fun onStart(): Unit
```
- Called after #onCreate — or after onRestart when the activity had been stopped, but is now again being displayed to the user. It will usually be followed by onResume. This is a good place to begin drawing visual elements, running animations, etc.

### [Activity: onResume](https://developer.android.com/reference/kotlin/android/app/Activity#onresume)
```kotlin
protected open fun onResume(): Unit
```
- Called after #onRestoreInstanceState, onRestart, or onPause. This is usually a hint for your activity to start interacting with the user, which is a good indicator that the activity became active and ready to receive input. This sometimes could also be a transit state toward another resting state. For instance, an activity may be relaunched to onPause due to configuration changes and the activity was visible, but wasn’t the top-most activity of an activity task. onResume is guaranteed to be called before onPause in this case which honors the activity lifecycle policy and the activity eventually rests in onPause.

### [Activity: onPause](https://developer.android.com/reference/kotlin/android/app/Activity#onpause)
```kotlin
protected open fun onPause(): Unit
```
- Called as part of the activity lifecycle when the user no longer actively interacts with the activity, but it is still visible on screen. The counterpart to onResume.

### [Activity: onStop](https://developer.android.com/reference/kotlin/android/app/Activity#onstop)
```kotlin
protected open fun onStop(): Unit
```
- Called when you are no longer visible to the user. You will next receive either onRestart, onDestroy, or nothing, depending on later user activity. This is a good place to stop refreshing UI, running animations and other visual things.

### [Activity: onDestroy](https://developer.android.com/reference/kotlin/android/app/Activity#ondestroy)
```kotlin
protected open fun onDestroy(): Unit
```
- Perform any final cleanup before an activity is destroyed. This can happen either because the activity is finishing (someone called finish on it), or because the system is temporarily destroying this instance of the activity to save space. You can distinguish between these two scenarios with the isFinishing method.

### [Activity: onRestart](https://developer.android.com/reference/kotlin/android/app/Activity#onrestart)
```kotlin
protected open fun onRestart(): Unit
```
- Called after onStop when the current activity is being re-displayed to the user (the user has navigated back to it). It will be followed by onStart and then onResume.

<br />

## 5.4 Typical Cases
After opened the app
![](../../images/Part%20I/image_5_2.png)

After closed the app
![](../../images/Part%20I/image_5_3.png)

After rotated
![](../../images/Part%20I/image_5_4.png)

After returned to home screen
![](../../images/Part%20I/image_5_5.png)

After backed to the app
![](../../images/Part%20I/image_5_6.png)

### Activity Class (MainActivity.kt)
```kotlin
package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

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
        Log.d(TAG, "onCreate Callback")
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
        val questionTextResId = questionBank[currentIndex].textResId
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

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Callback")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Callback")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Callback")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Callback")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Callback")
    }
}
```

### [Log: d](https://developer.android.com/reference/kotlin/android/util/Log#d)
```kotlin
static fun d(
    tag: String?, 
    msg: String
): Int
```
- Send a DEBUG log message.

<br />
