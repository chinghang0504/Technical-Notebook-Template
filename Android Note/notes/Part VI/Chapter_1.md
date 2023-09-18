# [Kotlin Note](../../README.md) - Chapter 1 Log
| Chapter | Title |
| :-: | :- |
| 1.1 | [Log Class](#11log-class) |
| 1.2 | [Public Methods](#12-public-methods) |
|  | [d](#d) |
|  | [e](#e) |
|  | [i](#i) |
|  | [v](#v) |
|  | [w](#w) |
|  | [wtf](#wtf) |

<br />

## 1.1 [Log Class](https://developer.android.com/reference/kotlin/android/util/Log)
- API for sending log output.

<br />

## 1.2 [Public Methods](https://developer.android.com/reference/kotlin/android/util/Log#public-methods)
### [d](https://developer.android.com/reference/kotlin/android/util/Log#d)
```kotlin
static fun d(
    tag: String?, 
    msg: String
): Int
```
- Send a DEBUG log message.

### [e](https://developer.android.com/reference/kotlin/android/util/Log#e)
```kotlin
static fun e(
    tag: String?, 
    msg: String
): Int
```
- Send an ERROR log message.

### [i](https://developer.android.com/reference/kotlin/android/util/Log#i)
```kotlin
static fun i(
    tag: String?, 
    msg: String
): Int
```
- Send an INFO log message.

### [v](https://developer.android.com/reference/kotlin/android/util/Log#v)
```kotlin
static fun v(
    tag: String?, 
    msg: String
): Int
```
- Send a VERBOSE log message.

### [w](https://developer.android.com/reference/kotlin/android/util/Log#w)
```kotlin
static fun w(
    tag: String?, 
    msg: String
): Int
```
- Send a WARN log message.

### [wtf](https://developer.android.com/reference/kotlin/android/util/Log#wtf)
```kotlin
static fun wtf(
    tag: String?, 
    msg: String?
): Int
```
- What a Terrible Failure: Report a condition that should never happen. The error will always be logged at level ASSERT with the call stack. Depending on system configuration, a report may be added to the android.os.DropBoxManager and/or the process may be terminated immediately with an error dialog.

<br />
