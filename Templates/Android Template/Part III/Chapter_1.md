# [Kotlin Note](../../README.md) - Chapter 1 Activity
| Chapter | Title |
| :-: | :- |
| 1.1 | [Activity Class](#11-activity-class) |
| 1.2 | [Public Methods](#12-public-methods) |
|  | [setContentView](#setcontentview) |
|  | [findViewById](#findviewbyid) |
| 1.3 | [Protected Methods](#13-protected-methods) |
|  | [onCreate](#oncreate) |
|  | [onStart](#onstart) |
|  | [onResume](#onresume) |
|  | [onPause](#onpause) |
|  | [onStop](#onstop) |
|  | [onDestroy](#ondestroy) |
|  | [onRestart](#onrestart) |

<br />

## 1.1 [Activity Class](https://developer.android.com/reference/kotlin/android/app/Activity)
- An activity is a single, focused thing that the user can do. Almost all activities interact with the user, so the Activity class takes care of creating a window for you in which you can place your UI with #setContentView. While activities are often presented to the user as full-screen windows, they can also be used in other ways: as floating windows (via a theme with android.R.attr#windowIsFloating set), Multi-Window mode or embedded into other windows. There are two methods almost all subclasses of Activity will implement:
    1. #onCreate is where you initialize your activity. Most importantly, here you will usually call setContentView(int) with a layout resource defining your UI, and using findViewById to retrieve the widgets in that UI that you need to interact with programmatically.
    2. onPause is where you deal with the user pausing active interaction with the activity. Any changes made by the user should at this point be committed (usually to the android.content.ContentProvider holding the data). In this state the activity is still visible on screen.

<br />

## 1.2 [Public Methods](https://developer.android.com/reference/kotlin/android/app/Activity#public-methods)
### [setContentView](https://developer.android.com/reference/kotlin/android/app/Activity#setcontentview)
```kotlin
open fun setContentView(layoutResID: Int): Unit
```
- Set the activity content from a layout resource. The resource will be inflated, adding all top-level views to the activity.

```kotlin
open fun setContentView(view: View!): Unit
```
- Set the activity content to an explicit view. This view is placed directly into the activity's view hierarchy. It can itself be a complex view hierarchy. When calling this method, the layout parameters of the specified view are ignored. Both the width and the height of the view are set by default to ViewGroup.LayoutParams#MATCH_PARENT. To use your own layout parameters, invoke setContentView(android.view.View,android.view.ViewGroup.LayoutParams) instead.

### [findViewById](https://developer.android.com/reference/kotlin/android/app/Activity#findviewbyid)
```kotlin
open fun <T : View!> findViewById(id: Int): T
```
- Finds a view that was identified by the android:id XML attribute that was processed in #onCreate.

<br />

## 1.3 [Protected Methods](https://developer.android.com/reference/kotlin/android/app/Activity#protected-methods)
### [onCreate](https://developer.android.com/reference/kotlin/android/app/Activity#oncreate_1)
```kotlin
protected open fun onCreate(savedInstanceState: Bundle?): Unit
```
- Called when the activity is starting. This is where most initialization should go: calling setContentView(int) to inflate the activity's UI, using findViewById to programmatically interact with widgets in the UI, calling managedQuery(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String) to retrieve cursors for data being displayed, etc.

### [onStart](https://developer.android.com/reference/kotlin/android/app/Activity#onstart)
```kotlin
protected open fun onStart(): Unit
```
- Called after #onCreate — or after onRestart when the activity had been stopped, but is now again being displayed to the user. It will usually be followed by onResume. This is a good place to begin drawing visual elements, running animations, etc.

### [onResume](https://developer.android.com/reference/kotlin/android/app/Activity#onresume)
```kotlin
protected open fun onResume(): Unit
```
- Called after #onRestoreInstanceState, onRestart, or onPause. This is usually a hint for your activity to start interacting with the user, which is a good indicator that the activity became active and ready to receive input. This sometimes could also be a transit state toward another resting state. For instance, an activity may be relaunched to onPause due to configuration changes and the activity was visible, but wasn’t the top-most activity of an activity task. onResume is guaranteed to be called before onPause in this case which honors the activity lifecycle policy and the activity eventually rests in onPause.

### [onPause](https://developer.android.com/reference/kotlin/android/app/Activity#onpause)
```kotlin
protected open fun onPause(): Unit
```
- Called as part of the activity lifecycle when the user no longer actively interacts with the activity, but it is still visible on screen. The counterpart to onResume.

### [onStop](https://developer.android.com/reference/kotlin/android/app/Activity#onstop)
```kotlin
protected open fun onStop(): Unit
```
- Called when you are no longer visible to the user. You will next receive either onRestart, onDestroy, or nothing, depending on later user activity. This is a good place to stop refreshing UI, running animations and other visual things.

### [onDestroy](https://developer.android.com/reference/kotlin/android/app/Activity#ondestroy)
```kotlin
protected open fun onDestroy(): Unit
```
- Perform any final cleanup before an activity is destroyed. This can happen either because the activity is finishing (someone called finish on it), or because the system is temporarily destroying this instance of the activity to save space. You can distinguish between these two scenarios with the isFinishing method.

### [onRestart](https://developer.android.com/reference/kotlin/android/app/Activity#onrestart)
```kotlin
protected open fun onRestart(): Unit
```
- Called after onStop when the current activity is being re-displayed to the user (the user has navigated back to it). It will be followed by onStart and then onResume.

<br />
