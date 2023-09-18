# [Kotlin Note](../../README.md) - Chapter 11 Exceptions
| Chapter | Title |
| :-: | :- |
| 10.1 | [Throwing an Exception](#101-throwing-an-exception) |
|  | [Using throw Keyword](#using-throw-keyword) |
| 10.2 | [Catching an Exception](#102-catching-an-exception) |
|  | [Using try-catch Statement](#using-try-catch-statement) |
|  | [Using try-catch Expression](#using-try-catch-expression) |
| 10.3 | [Precondition Functions](#103-precondition-functions) |
|  | [Using check Function](#using-check-function) |
|  | [Using checkNotNull Function](#using-checknotnull-function) |
|  | [Using require Function](#using-require-function) |
|  | [Using requireNotNull Function](#using-requirenotnull-function) |
|  | [Using error Function](#using-error-function) |
| 10.4 | [Custom Exception](#104-custom-exception) |

<br />

## 10.1 Throwing an Exception
### Using throw Keyword
```kotlin
val str: String? = null
if (str == null) {
    throw NullPointerException()
}
```

<br />

## 10.2 Catching an Exception
### Using try-catch Statement
```kotlin
val str: String? = null

try {
    if (str == null) {
        throw NullPointerException()
    }
} catch (e: NullPointerException) {
    println("The exception is caught")
}
```

### Using try-catch Expression
```kotlin
val str: String? = null

val message: String = try {
    if (str == null) {
        throw NullPointerException()
    }
    "Normal"
} catch (e: NullPointerException) {
    "Error"
}
```

<br />

## 10.3 Precondition Functions
- Procondition functions check the condidtion and throw an exception with a custom message if the codition is false.

| Function | Description |
| :-- | :-- |
| check | Throws an IllegalStateException if argument is false. |
| checkNotNull | Throws an IllegalStateException if argument is null. Otherwise returns the nonnull value. |
| require | Throws an IllegalArgumentException if argument is false. |
| requireNotNull | Throws an IllegalArgumentException if argument is null. Otherwise returns the non-null value. |
| error | Throws an IllegalStateException with a provided message. |

### Using check Function
```kotlin
val str: String? = null
check(str != null)
```
```kotlin
val str: String? = null
check(str != null) {
    "Null Value"
}
```

### Using checkNotNull Function
```kotlin
val str: String? = null
val message: String = checkNotNull(str)
```
```kotlin
val str: String? = null
val message: String = checkNotNull(str) {
    "Null Value"
}
```

### Using require Function
```kotlin
val str: String? = null
require(str != null)
```
```kotlin
val str: String? = null
require(str != null) {
    "Null Value"
}
```

### Using requireNotNull Function
```kotlin
val str: String? = null
val message: String = requireNotNull(str)
```
```kotlin
val str: String? = null
val message: String = requireNotNull(str) {
    "Null Value"
}
```

### Using error Function
```kotlin
error("Error Message")
```

<br />

## 10.4 Custom Exception
```kotlin
class IllegalValueException(message: String) : RuntimeException(message) {}
```
```kotlin
throw IllegalValueException("Illegal Value")
```

<br />
