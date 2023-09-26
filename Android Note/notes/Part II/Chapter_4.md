# [Kotlin Note](../../README.md) - Chapter 4 Single Fragment with FragmentManager
| Chapter | Title |
| :-: | :- |
| 4.1 | [FragmentManager](#41-fragmentmanager) |
| 4.2 | [Activity Layout (activity_main.xml)](#42-activity-layout-activity_mainxml) |
| 4.3 | [Activity Class (MainActivity.kt)](#43-activity-class-mainactivitykt) |
|  | [FragmentActivity: supportFragmentManager](#fragmentactivity-supportfragmentmanager) |
|  | [FragmentManager: beginTransaction()](#fragmentmanager-begintransaction) |
|  | [FragmentTransaction: add()](#fragmenttransaction-add) |
|  | [FragmentTransaction: commit()](#fragmenttransaction-commit) |

<br />

## 4.1 [FragmentManager](https://developer.android.com/guide/fragments/fragmentmanager)
- FragmentManager is the class responsible for performing actions on your app's fragments, such as adding, removing, or replacing them and adding them to the back stack.

<br />

## 4.2 Activity Layout (activity_main.xml)
![](../../images/Part%20II/image_4_1.png)

```xml
<androidx.fragment.app.FragmentContainerView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"/>
```

<br />

## 4.3 Activity Class (MainActivity.kt)
```kotlin
package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = CrimeDetailFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }
}
```

### [FragmentActivity: supportFragmentManager](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity#getSupportFragmentManager())
- Return the FragmentManager for interacting with fragments associated with this activity.
```kotlin
fun getSupportFragmentManager(): FragmentManager
```

### [FragmentManager: beginTransaction()](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentManager#beginTransaction())
- Start a series of edit operations on the Fragments associated with this FragmentManager.
```kotlin
fun beginTransaction(): FragmentTransaction
```

### [FragmentTransaction: add()](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentTransaction#add(int,androidx.fragment.app.Fragment))
- Add a fragment to the activity state. This fragment may optionally also have its view (if Fragment.onCreateView returns non-null) into a container view of the activity.
```kotlin
fun add(containerViewId: @IdRes Int, fragment: Fragment): FragmentTransaction
```

### [FragmentTransaction: commit()](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentTransaction#commit())
- Schedules a commit of this transaction. The commit does not happen immediately; it will be scheduled as work on the main thread to be done the next time that thread is ready.
```kotlin
abstract fun commit(): Int
```

<br />
