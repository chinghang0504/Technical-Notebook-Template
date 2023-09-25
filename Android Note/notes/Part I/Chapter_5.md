# [Kotlin Note](../../README.md) - Chapter 5 Activity Lifecycle
| Chapter | Title |
| :-: | :- |
| 5.1 | [Activity Lifecycle](#51-activity-lifecycle) |
| 5.2 | [Activity Lifecycle Callbacks](#52-activity-lifecycle-callbacks) |
|  | [onCreate Callback](#oncreate-callback) |
|  | [onStart Callback](#onstart-callback) |
|  | [onResume Callback](#onresume-callback) |
|  | [onPause Callback](#onpause-callback) |
|  | [onStop Callback](#onstop-callback) |
|  | [onDestroy Callback](#ondestroy-callback) |
| 5.3 | [Typical Cases](#53-typical-cases) |
|  | [Activity Class (MainActivity.kt)](#activity-class-mainactivitykt) |
|  | [Case 1: After Started the App](#case-1-after-started-the-app) |
|  | [Case 2: After Terminated the App](#case-2-after-terminated-the-app) |
|  | [Case 3: After Rotated the App](#case-3-after-rotated-the-app) |
|  | [Case 4: After Clicked the Home Button](#case-4-after-clicked-the-home-button) |
|  | [Case 5: After Backed to the App](#case-5-after-backed-to-the-app) |
|  | [Activity: onCreate()](#activity-oncreate) |
|  | [Activity: onStart()](#activity-onstart) |
|  | [Activity: onResume()](#activity-onresume) |
|  | [Activity: onPause()](#activity-onpause) |
|  | [Activity: onStop()](#activity-onstop) |
|  | [Activity: onDestroy()](#activity-ondestroy) |
|  | [Log: d()](#log-d) |

<br />

## 5.1 [Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)
![](../../images/Part%20I/image_5_1.png)

- As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle. The Activity class provides a number of callbacks that let the activity know when a state changes or that the system is creating, stopping, or resuming an activity or destroying the process the activity resides in.

- Within the lifecycle callback methods, you can declare how your activity behaves when the user leaves and re-enters the activity. For example, if you're building a streaming video player, you might pause the video and terminate the network connection when the user switches to another app. When the user returns, you can reconnect to the network and let the user resume the video from the same spot.

- Each callback lets you perform specific work that's appropriate to a given change of state. Doing the right work at the right time and handling transitions properly make your app more robust and performant. For example, good implementation of the lifecycle callbacks can help your app avoid the following:

    1. Crashing if the user receives a phone call or switches to another app while using your app.

    2. Consuming valuable system resources when the user is not actively using it.
    
    3. Losing the user's progress if they leave your app and return to it at a later time.

    4. Crashing or losing the user's progress when the screen rotates between landscape and portrait orientation.

<br />

## 5.2 [Activity Lifecycle Callbacks](https://developer.android.com/guide/components/activities/activity-lifecycle#lc)
### [onCreate Callback](https://developer.android.com/guide/components/activities/activity-lifecycle#oncreate)
- You must implement this callback, which fires when the system first creates the activity. On activity creation, the activity enters the Created state. In the onCreate() method, perform basic application startup logic that happens only once for the entire life of the activity.

### [onStart Callback](https://developer.android.com/guide/components/activities/activity-lifecycle#onstart)
- When the activity enters the Started state, the system invokes onStart(). This call makes the activity visible to the user as the app prepares for the activity to enter the foreground and become interactive. For example, this method is where the code that maintains the UI is initialized.

### [onResume Callback](https://developer.android.com/guide/components/activities/activity-lifecycle#onresume)
- When the activity enters the Resumed state, it comes to the foreground, and the system invokes the onResume() callback. This is the state in which the app interacts with the user. The app stays in this state until something happens to take focus away from the app, such as the device receiving a phone call, the user navigating to another activity, or the device screen turning off.

### [onPause Callback](https://developer.android.com/guide/components/activities/activity-lifecycle#onpause)
- The system calls this method as the first indication that the user is leaving your activity, though it does not always mean the activity is being destroyed. It indicates that the activity is no longer in the foreground, but it is still visible if the user is in multi-window mode. There are several reasons why an activity might enter this state:

    1. An event that interrupts app execution, as described in the section about the onResume() callback, pauses the current activity. This is the most common case.

    2. In multi-window mode, only one app has focus at any time, and the system pauses all the other apps.

    3. The opening of a new, semi-transparent activity, such as a dialog, pauses the activity it covers. As long as the activity is partially visible but not in focus, it remains paused.

### [onStop Callback](https://developer.android.com/guide/components/activities/activity-lifecycle#onstop)
- When your activity is no longer visible to the user, it enters the Stopped state, and the system invokes the onStop() callback. This can occur when a newly launched activity covers the entire screen. The system also calls onStop() when the activity finishes running and is about to be terminated.

### [onDestroy Callback](https://developer.android.com/guide/components/activities/activity-lifecycle#ondestroy)
- onDestroy() is called before the activity is destroyed. The system invokes this callback for one of two reasons:

    1. The activity is finishing, due to the user completely dismissing the activity or due to finish() being called on the activity.

    2. The system is temporarily destroying the activity due to a configuration change, such as device rotation or entering multi-window mode.

<br />

## 5.3 Typical Cases
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

### Case 1: After Started the App
![](../../images/Part%20I/image_5_2.png)

### Case 2: After Terminated the App
![](../../images/Part%20I/image_5_3.png)

### Case 3: After Rotated the App
![](../../images/Part%20I/image_5_4.png)

### Case 4: After Clicked the Home Button
![](../../images/Part%20I/image_5_5.png)

### Case 5: After Backed to the App
![](../../images/Part%20I/image_5_6.png)

### [Activity: onCreate()](https://developer.android.com/reference/kotlin/android/app/Activity#oncreate_1)
- Called when the activity is starting. This is where most initialization should go: calling setContentView(int) to inflate the activity's UI, using findViewById to programmatically interact with widgets in the UI, calling managedQuery(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String) to retrieve cursors for data being displayed, etc.
```kotlin
protected open fun onCreate(savedInstanceState: Bundle?): Unit
```
### [Activity: onStart()](https://developer.android.com/reference/kotlin/android/app/Activity#onstart)
- Called after #onCreate — or after onRestart when the activity had been stopped, but is now again being displayed to the user. It will usually be followed by onResume. This is a good place to begin drawing visual elements, running animations, etc.
```kotlin
protected open fun onStart(): Unit
```

### [Activity: onResume()](https://developer.android.com/reference/kotlin/android/app/Activity#onresume)
- Called after #onRestoreInstanceState, onRestart, or onPause. This is usually a hint for your activity to start interacting with the user, which is a good indicator that the activity became active and ready to receive input. This sometimes could also be a transit state toward another resting state. For instance, an activity may be relaunched to onPause due to configuration changes and the activity was visible, but wasn’t the top-most activity of an activity task. onResume is guaranteed to be called before onPause in this case which honors the activity lifecycle policy and the activity eventually rests in onPause.
```kotlin
protected open fun onResume(): Unit
```

### [Activity: onPause()](https://developer.android.com/reference/kotlin/android/app/Activity#onpause)
- Called as part of the activity lifecycle when the user no longer actively interacts with the activity, but it is still visible on screen. The counterpart to onResume.
```kotlin
protected open fun onPause(): Unit
```

### [Activity: onStop()](https://developer.android.com/reference/kotlin/android/app/Activity#onstop)
- Called when you are no longer visible to the user. You will next receive either onRestart, onDestroy, or nothing, depending on later user activity. This is a good place to stop refreshing UI, running animations and other visual things.
```kotlin
protected open fun onStop(): Unit
```

### [Activity: onDestroy()](https://developer.android.com/reference/kotlin/android/app/Activity#ondestroy)
- Perform any final cleanup before an activity is destroyed. This can happen either because the activity is finishing (someone called finish on it), or because the system is temporarily destroying this instance of the activity to save space. You can distinguish between these two scenarios with the isFinishing method.
```kotlin
protected open fun onDestroy(): Unit
```

### [Log: d()](https://developer.android.com/reference/kotlin/android/util/Log#d)
- Send a DEBUG log message.
```kotlin
static fun d(
    tag: String?, 
    msg: String
): Int
```

<br />
