# [Kotlin Note](../../README.md) - Chapter 2 Fragment Lifecycle
| Chapter | Title |
| :-: | :- |
| 12.1 | [Fragment Lifecycle]() |
| 12.2 | [Fragment Public Methods]() |
|  | [Fragment: onCreate]() |
|  | [Fragment: onCreateView]() |
|  | [Fragment: onViewCreated]() |
|  | [Fragment: onViewStateRestored]() |
|  | [Fragment: onStart]() |
|  | [Fragment: onResume]() |
|  | [Fragment: onPause]() |
|  | [Fragment: onStop]() |
|  | [Fragment: onSaveInstanceState]() |
|  | [Fragment: onDestroyView]() |
|  | [Fragment: onDestroy]() |

<br />

## 12.1 [Fragment Lifecycle](https://developer.android.com/guide/fragments/lifecycle)
![](../../images/Part%20I/image_12_1.png)
- Each Fragment instance has its own lifecycle. When a user navigates and interacts with your app, your fragments transition through various states in their lifecycle as they are added, removed, and enter or exit the screen.

<br />

## 12.2 [Fragment Public Methods](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#public-functions_1)
### [Fragment: onCreate](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onCreate(android.os.Bundle))
```kotlin
@MainThread
@CallSuper
fun onCreate(savedInstanceState: Bundle?): Unit
```
- Called to do initial creation of a fragment. This is called after onAttach and before onCreateView.

### [Fragment: onCreateView](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle))
```kotlin
@MainThread
fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View?
```
- Called to have the fragment instantiate its user interface view. This is optional, and non-graphical fragments can return null. This will be called between onCreate and onViewCreated.

### [Fragment: onViewCreated](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onViewCreated(android.view.View,android.os.Bundle))
```kotlin
@MainThread
fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit
```
- Called immediately after onCreateView has returned, but before any saved state has been restored in to the view. This gives subclasses a chance to initialize themselves once they know their view hierarchy has been completely created. The fragment's view hierarchy is not however attached to its parent at this point.

### [Fragment: onViewStateRestored](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onViewStateRestored(android.os.Bundle))
```kotlin
@MainThread
@CallSuper
fun onViewStateRestored(savedInstanceState: Bundle?): Unit
```
- Called when all saved state has been restored into the view hierarchy of the fragment. This can be used to do initialization based on saved state that you are letting the view hierarchy track itself, such as whether check box widgets are currently checked. This is called after onViewCreated and before onStart.

### [Fragment: onStart](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onStart())
```kotlin
@MainThread
@CallSuper
fun onStart(): Unit
```
- Called when the Fragment is visible to the user. This is generally tied to Activity.onStart of the containing Activity's lifecycle.

### [Fragment: onResume](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onResume())
```kotlin
@MainThread
@CallSuper
fun onResume(): Unit
```
- Called when the fragment is visible to the user and actively running. This is generally tied to Activity.onResume of the containing Activity's lifecycle.

### [Fragment: onPause](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onPause())
```kotlin
@MainThread
@CallSuper
fun onPause(): Unit
```
- Called when the Fragment is no longer resumed. This is generally tied to Activity.onPause of the containing Activity's lifecycle.

### [Fragment: onStop](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onStop())
```kotlin
@MainThread
@CallSuper
fun onStop(): Unit
```
- Called when the Fragment is no longer started. This is generally tied to Activity.onStop of the containing Activity's lifecycle.

### [Fragment: onSaveInstanceState](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onSaveInstanceState(android.os.Bundle))
```kotlin
@MainThread
fun onSaveInstanceState(outState: Bundle): Unit
```
- Called to ask the fragment to save its current dynamic state, so it can later be reconstructed in a new instance if its process is restarted. If a new instance of the fragment later needs to be created, the data you place in the Bundle here will be available in the Bundle given to onCreate, onCreateView, and onViewCreated.

### [Fragment: onDestroyView](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onDestroyView())
```kotlin
@MainThread
@CallSuper
fun onDestroyView(): Unit
```
- Called when the view previously created by onCreateView has been detached from the fragment. The next time the fragment needs to be displayed, a new view will be created. This is called after onStop and before onDestroy. It is called regardless of whether onCreateView returned a non-null view. Internally it is called after the view's state has been saved but before it has been removed from its parent.

### [Fragment: onDestroy](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onDestroy())
```kotlin
@MainThread
@CallSuper
fun onDestroy(): Unit
```
- Called when the fragment is no longer in use. This is called after onStop and before onDetach.

<br />
