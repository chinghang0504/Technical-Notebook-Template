# [Kotlin Note](../../README.md) - Chapter 1 Toast
| Chapter | Title |
| :-: | :- |
| 1.1 | [Toast Class](#11-toast-class) |
| 1.2 | [Public Methods](#12-public-methods) |
|  | [makeText](#maketext) |
|  | [show](#show) |

<br />

## 1.1 [Toast Class](https://developer.android.com/reference/kotlin/android/widget/Toast)
- A toast is a view containing a quick little message for the user. The toast class helps you create and show those.

<br />

## 1.2 [Public Methods](https://developer.android.com/reference/kotlin/android/widget/Toast#public-methods)
### [makeText](https://developer.android.com/reference/kotlin/android/widget/Toast#maketext_1)
```kotlin
open static fun makeText(
    context: Context!, 
    resId: Int, 
    duration: Int
): Toast!
```
- Make a standard toast that just contains text from a resource.

### [show](https://developer.android.com/reference/kotlin/android/widget/Toast#show)
```kotlin
open fun show(): Unit
```
- Show the view for the specified duration.

<br />
