# [Kotlin Note](../../README.md) - Chapter 1 View
| Chapter | Title |
| :-: | :- |
| 1.1 | [View Class](#11-view-class) |
| 1.2 | [Public Methods](#12-public-methods) |
|  | [setOnClickListener](#setonclicklistener) |

<br />

## 1.1 [View Class](https://developer.android.com/reference/kotlin/android/view/View)
- This class represents the basic building block for user interface components. A View occupies a rectangular area on the screen and is responsible for drawing and event handling. View is the base class for widgets, which are used to create interactive UI components (buttons, text fields, etc.). The android.view.ViewGroup subclass is the base class for layouts, which are invisible containers that hold other Views (or other ViewGroups) and define their layout properties.

<br />

## 1.2 [Public Methods](https://developer.android.com/reference/kotlin/android/view/View#public-methods)
### [setOnClickListener](https://developer.android.com/reference/kotlin/android/view/View#setonclicklistener)
```kotlin
open fun setOnClickListener(l: View.OnClickListener?): Unit
```
- Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.

<br />
