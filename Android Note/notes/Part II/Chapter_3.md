# [Kotlin Note](../../README.md) - Chapter 3 Fragment Lifecycle
| Chapter | Title |
| :-: | :- |
| 3.1 | [Fragment Lifecycle](#31-fragment-lifecycle) |
| 3.2 | [Fragment Lifecycle States and Callbacks](#32-fragment-lifecycle-states-and-callbacks) |
|  | [Upward State: Fragment CREATED](#upward-state-fragment-created) |
|  | [Upward State: Fragment CREATED and View INITIALIZED](#upward-state-fragment-created-and-view-initialized) |
|  | [Upward State: Fragment and View CREATED](#upward-state-fragment-and-view-created) |
|  | [Upward State: Fragment and View STARTED](#upward-state-fragment-and-view-started) |
|  | [Upward State: Fragment and View RESUMED](#upward-state-fragment-and-view-resumed) |
|  | [Downward State: Fragment and View STARTED](#downward-state-fragment-and-view-started) |
|  | [Downward State: Fragment and View CREATED](#downward-state-fragment-and-view-created) |
|  | [Downward State: Fragment CREATED and View DESTROYED](#downward-state-fragment-created-and-view-destroyed) |
|  | [Downward State: Fragment DESTROYED](#downward-state-fragment-destroyed) |
| 3.3 | [Fragment Callbacks](#33-fragment-callbacks) |
|  | [Fragment: onCreate()](#fragment-oncreate) |
|  | [Fragment: onCreateView()](#fragment-oncreateview) |
|  | [Fragment: onViewCreated()](#fragment-onviewcreated) |
|  | [Fragment: onViewStateRestored()](#fragment-onviewstaterestored) |
|  | [Fragment: onStart()](#fragment-onstart) |
|  | [Fragment: onResume()](#fragment-onresume) |
|  | [Fragment: onPause()](#fragment-onpause) |
|  | [Fragment: onStop()](#fragment-onstop) |
|  | [Fragment: onSaveInstanceState()](#fragment-onsaveinstancestate) |
|  | [Fragment: onDestroyView()](#fragment-ondestroyview) |
|  | [Fragment: onDestroy()](#fragment-ondestroy) |

<br />

## 3.1 [Fragment Lifecycle](https://developer.android.com/guide/fragments/lifecycle)
- Each Fragment instance has its own lifecycle. When a user navigates and interacts with your app, your fragments transition through various states in their lifecycle as they are added, removed, and enter or exit the screen.

- To manage lifecycle, Fragment implements LifecycleOwner, exposing a Lifecycle object that you can access through the getLifecycle() method.

- Each possible Lifecycle state is represented in the Lifecycle.State enum.
    1. INITIALIZED
    2. CREATED
    3. STARTED
    4. RESUMED
    5. DESTROYED

<br />

## 3.2 [Fragment Lifecycle States and Callbacks](https://developer.android.com/guide/fragments/lifecycle#states)
![](../../images/Part%20II/image_3_1.png)

### [Upward State: Fragment CREATED](https://developer.android.com/guide/fragments/lifecycle#fragment_created)
- When your fragment reaches the CREATED state, it has been added to a FragmentManager and the onAttach() method has already been called.

### [Upward State: Fragment CREATED and View INITIALIZED](https://developer.android.com/guide/fragments/lifecycle#fragment_created_and_view_initialized)
- The fragment's view Lifecycle is created only when your Fragment provides a valid View instance. In most cases, you can use the fragment constructors that take a @LayoutId, which automatically inflates the view at the appropriate time. You can also override onCreateView() to programmatically inflate or create your fragment's view.

### [Upward State: Fragment and View CREATED](https://developer.android.com/guide/fragments/lifecycle#fragment_and_view_created)
- After the fragment's view has been created, the previous view state, if any, is restored, and the view's Lifecycle is then moved into the CREATED state. The view lifecycle owner also emits the ON_CREATE event to its observers. Here you should restore any additional state associated with the fragment's view.

### [Upward State: Fragment and View STARTED](https://developer.android.com/guide/fragments/lifecycle#fragment_and_view_started)
- It is strongly recommended to tie Lifecycle-aware components to the STARTED state of a fragment, as this state guarantees that the fragment's view is available, if one was created, and that it is safe to perform a FragmentTransaction on the child FragmentManager of the fragment. If the fragment's view is non-null, the fragment's view Lifecycle is moved to STARTED immediately after the fragment's Lifecycle is moved to STARTED.

### [Upward State: Fragment and View RESUMED](https://developer.android.com/guide/fragments/lifecycle#fragment_and_view_resumed)
- When the fragment is visible, all Animator and Transition effects have finished, and the fragment is ready for user interaction. The fragment's Lifecycle moves to the RESUMED state, and the onResume() callback is invoked.

### [Downward State: Fragment and View STARTED](https://developer.android.com/guide/fragments/lifecycle#fragment_and_view_started_2)
- As the user begins to leave the fragment, and while the fragment is still visible, the Lifecycles for the fragment and for its view are moved back to the STARTED state and emit the ON_PAUSE event to their observers. The fragment then invokes its onPause() callback.

### [Downward State: Fragment and View CREATED](https://developer.android.com/guide/fragments/lifecycle#fragment_and_view_created_2)
- Once the fragment is no longer visible, the Lifecycles for the fragment and for its view are moved into the CREATED state and emit the ON_STOP event to their observers. This state transition is triggered not only by the parent activity or fragment being stopped, but also by the saving of state by the parent activity or fragment. This behavior guarantees that the ON_STOP event is invoked before the fragment's state is saved. This makes the ON_STOP event the last point where it is safe to perform a FragmentTransaction on the child FragmentManager.

### [Downward State: Fragment CREATED and View DESTROYED](https://developer.android.com/guide/fragments/lifecycle#fragment_created_and_view_destroyed)
- After all of the exit animations and transitions have completed, and the fragment's view has been detached from the window, the fragment's view Lifecycle is moved into the DESTROYED state and emits the ON_DESTROY event to its observers. The fragment then invokes its onDestroyView() callback. At this point, the fragment's view has reached the end of its lifecycle and getViewLifecycleOwnerLiveData() returns a null value.

### [Downward State: Fragment DESTROYED](https://developer.android.com/guide/fragments/lifecycle#fragment_destroyed)
- If the fragment is removed, or if the FragmentManager is destroyed, the fragment's Lifecycle is moved into the DESTROYED state and sends the ON_DESTROY event to its observers. The fragment then invokes its onDestroy() callback. At this point, the fragment has reached the end of its lifecycle.

<br />

## 3.3 Fragment Callbacks
### [Fragment: onCreate()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onCreate(android.os.Bundle))
- Called to do initial creation of a fragment. This is called after onAttach and before onCreateView.
```kotlin
@MainThread
@CallSuper
fun onCreate(savedInstanceState: Bundle?): Unit
```

### [Fragment: onCreateView()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onCreateView(android.view.LayoutInflater,android.view.ViewGroup,android.os.Bundle))
- Called to have the fragment instantiate its user interface view. This is optional, and non-graphical fragments can return null. This will be called between onCreate and onViewCreated.
```kotlin
@MainThread
fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View?
```

### [Fragment: onViewCreated()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onViewCreated(android.view.View,android.os.Bundle))
- Called immediately after onCreateView has returned, but before any saved state has been restored in to the view. This gives subclasses a chance to initialize themselves once they know their view hierarchy has been completely created. The fragment's view hierarchy is not however attached to its parent at this point.
```kotlin
@MainThread
fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit
```

### [Fragment: onViewStateRestored()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onViewStateRestored(android.os.Bundle))
- Called when all saved state has been restored into the view hierarchy of the fragment. This can be used to do initialization based on saved state that you are letting the view hierarchy track itself, such as whether check box widgets are currently checked. This is called after onViewCreated and before onStart.
```kotlin
@MainThread
@CallSuper
fun onViewStateRestored(savedInstanceState: Bundle?): Unit
```

### [Fragment: onStart()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onStart())
- Called when the Fragment is visible to the user. This is generally tied to Activity.onStart of the containing Activity's lifecycle.
```kotlin
@MainThread
@CallSuper
fun onStart(): Unit
```

### [Fragment: onResume()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onResume())
- Called when the fragment is visible to the user and actively running. This is generally tied to Activity.onResume of the containing Activity's lifecycle.
```kotlin
@MainThread
@CallSuper
fun onResume(): Unit
```

### [Fragment: onPause()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onPause())
- Called when the Fragment is no longer resumed. This is generally tied to Activity.onPause of the containing Activity's lifecycle.
```kotlin
@MainThread
@CallSuper
fun onPause(): Unit
```

### [Fragment: onStop()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onStop())
- Called when the Fragment is no longer started. This is generally tied to Activity.onStop of the containing Activity's lifecycle.
```kotlin
@MainThread
@CallSuper
fun onStop(): Unit
```

### [Fragment: onSaveInstanceState()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onSaveInstanceState(android.os.Bundle))
- Called to ask the fragment to save its current dynamic state, so it can later be reconstructed in a new instance if its process is restarted. If a new instance of the fragment later needs to be created, the data you place in the Bundle here will be available in the Bundle given to onCreate, onCreateView, and onViewCreated.
```kotlin
@MainThread
fun onSaveInstanceState(outState: Bundle): Unit
```

### [Fragment: onDestroyView()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onDestroyView())
- Called when the view previously created by onCreateView has been detached from the fragment. The next time the fragment needs to be displayed, a new view will be created. This is called after onStop and before onDestroy. It is called regardless of whether onCreateView returned a non-null view. Internally it is called after the view's state has been saved but before it has been removed from its parent.
```kotlin
@MainThread
@CallSuper
fun onDestroyView(): Unit
```

### [Fragment: onDestroy()](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#onDestroy())
- Called when the fragment is no longer in use. This is called after onStop and before onDetach.
```kotlin
@MainThread
@CallSuper
fun onDestroy(): Unit
```

<br />
