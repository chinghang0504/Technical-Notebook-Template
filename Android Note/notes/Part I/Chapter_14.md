# [Kotlin Note](../../README.md) - Chapter 14 Single Fragment (FragmentManager)
| Chapter | Title |
| :-: | :- |
| 14.1 | [FragmentManager](#141-fragmentmanager) |
| 14.2 | [Activity Layout (activity_main.xml)](#142-activity-layout-activity_mainxml) |
| 14.3 | [Activity Class (MainActivity.kt)](#143-activity-class-mainactivitykt) |
|  | [FragmentActivity: getSupportFragmentManager](#fragmentactivity-getsupportfragmentmanager) |
|  | [FragmentManager: beginTransaction](#fragmentmanager-begintransaction) |
|  | [FragmentTransaction: add](#fragmenttransaction-add) |
|  | [FragmentTransaction: commit](#fragmenttransaction-commit) |

<br />

## 14.1 [FragmentManager](https://developer.android.com/guide/fragments/fragmentmanager)
- FragmentManager is the class responsible for performing actions on your app's fragments, such as adding, removing, or replacing them and adding them to the back stack.

<br />

## 14.2 Activity Layout (activity_main.xml)
![](../../images/Part%20I/image_14_1.png)

```xml
<androidx.fragment.app.FragmentContainerView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"/>
```

<br />

## 14.3 Activity Class (MainActivity.kt)
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

### [FragmentActivity: getSupportFragmentManager](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity#getSupportFragmentManager())
```kotlin
fun getSupportFragmentManager(): FragmentManager
```
- Return the FragmentManager for interacting with fragments associated with this activity.

### [FragmentManager: beginTransaction](https://developer.android.com/reference/kotlin/android/app/FragmentManager#begintransaction)
Deprecated in API level 28
```kotlin
abstract fun beginTransaction(): FragmentTransaction!
```
- Start a series of edit operations on the Fragments associated with this FragmentManager.

### [FragmentTransaction: add](https://developer.android.com/reference/kotlin/android/app/FragmentTransaction#add_1)
Deprecated in API level 28
```kotlin
abstract fun add(
    containerViewId: Int, 
    fragment: Fragment!
): FragmentTransaction!
```
- Add a fragment to the activity state. This fragment may optionally also have its view (if Fragment.onCreateView returns non-null) inserted into a container view of the activity.

### [FragmentTransaction: commit](https://developer.android.com/reference/kotlin/android/app/FragmentTransaction#commit)
Deprecated in API level 28
```kotlin
abstract fun commit(): Int
```
- Schedules a commit of this transaction. The commit does not happen immediately; it will be scheduled as work on the main thread to be done the next time that thread is ready.

<br />
