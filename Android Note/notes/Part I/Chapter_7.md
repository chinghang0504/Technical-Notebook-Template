# [Kotlin Note](../../README.md) - Chapter 7 Single Activity with ViewModel and SavedStateHandle
| Chapter | Title |
| :-: | :- |
| 7.1 | [Problem: System-Initiated UI State Dismissal](#71-problem-system-initiated-ui-state-dismissal) |
|  | [Options for Preserving UI State](#options-for-preserving-ui-state) |
| 7.2 | [Destroying Activity for Testing](#72-destroying-activity-for-testing) |
| 7.3 | [ViewModel (QuizViewModel.kt)](#73-viewmodel-quizviewmodelkt) |
|  | [SavedStateHandle: get()](#savedstatehandle-get) |
|  | [SavedStateHandle: set()](#savedstatehandle-set) |
| 7.4 | [Demonstration](#74-demonstration) |

<br />

## 7.1 [Problem: System-Initiated UI State Dismissal](https://developer.android.com/topic/libraries/architecture/saving-states#ui-dismissal-system)
- A user expects an activity's UI state to remain the same throughout a configuration change, such as rotation or switching into multi-window mode. However, by default the system destroys the activity when such a configuration change occurs, wiping away any UI state stored in the activity instance. To learn more about device configurations, see the Configuration reference page. Note, it is possible (though not recommended) to override the default behavior for configuration changes. See Handling the configuration change yourself for more details.

- A user also expects your activity's UI state to remain the same if they temporarily switch to a different app and then come back to your app later. For example, the user performs a search in your search activity and then presses the home button or answers a phone call - when they return to the search activity they expect to find the search keyword and results still there, exactly as before.

- In this scenario, your app is placed in the background the system does its best to keep your app process in memory. However, the system may destroy the application process while the user is away interacting with other apps. In such a case, the activity instance is destroyed, along with any state stored in it. When the user relaunches the app, the activity is unexpectedly in a clean state. To learn more about process death, see Processes and Application Lifecycle.

### [Options for Preserving UI State](https://developer.android.com/topic/libraries/architecture/saving-states#options)
|  | ViewModel | Saved instance state | Persistent storage |
| :-- | :-- | :-- | :-- |
| Storage location | in memory | in memory | on disk or network |
| Survives configuration change | Yes | Yes | Yes |
| Survives system-initiated process death | No | Yes | Yes |
| Survives user complete activity dismissal/onFinish() | No | No | Yes |
| Data limitations | complex objects are fine, but space is limited by available memory | only for primitive types and simple, small objects such as String | only limited by disk space or cost / time of retrieval from the network resource |
| Read/write time | quick (memory access only) | slow (requires serialization/deserialization) | slow (requires disk access or network transaction) |

<br />

## 7.2 Destroying Activity for Testing
Don't keep activities
![](../../images/Part%20I/image_7_1.png)

After started the app
![](../../images/Part%20I/image_7_2.png)

After clicked the next button
![](../../images/Part%20I/image_7_3.png)

After clicked the home button
![](../../images/Part%20I/image_7_4.png)

After clicked the app
![](../../images/Part%20I/image_7_5.png)

<br />

## 7.3 ViewModel (QuizViewModel.kt)
```kotlin
package com.example.geoquiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textRestId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}
```

### [SavedStateHandle: get()](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle#get(kotlin.String))
- Returns a value associated with the given key.
```kotlin
@MainThread
operator fun <T : Any?> get(key: String): T?
```

### [SavedStateHandle: set()](https://developer.android.com/reference/kotlin/androidx/lifecycle/SavedStateHandle#set(kotlin.String,kotlin.Any))
- Associate the given value with the key. The value must have a type that could be stored in android.os.Bundle
```kotlin
@MainThread
operator fun <T : Any?> set(key: String, value: T?): Unit
```

<br />

## 7.4 Demonstration
After started the app
![](../../images/Part%20I/image_7_6.png)

After clicked the next button
![](../../images/Part%20I/image_7_7.png)

After clicked the home button
![](../../images/Part%20I/image_7_8.png)

After clicked the app
![](../../images/Part%20I/image_7_9.png)

<br />
