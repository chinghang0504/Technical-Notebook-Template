# [Kotlin Note](../../README.md) - Chapter 10 Null Safety
| Chapter | Title |
| :-: | :- |
| 10.1 | [Checking for Null](#101-checking-for-null) |
|  | [Using if Statement](#using-if-statement) |
|  | [Using Safe Call Operator ?.](#using-safe-call-operator) |
|  | [Using Safe Call Operator ?. and let Scope Function](#using-safe-call-operator--and-let-scope-function) |
| 10.2 | [Assigning Default Value for Null Value](#102-assigning-default-value-for-null-value) |
|  | [Using if Statement](#using-if-statement-1) |
|  | [Using Elvis Operator ?:](#using-elvis-operator) |
| 10.3 | [Ignoring Null Safety](#103-ignoring-null-safety) |
|  | [Using Not-Null Assertion Operator !! to Call a Function](#using-not-null-assertion-operator--to-call-a-function) |
|  | [Using Not-Null Assertion Operator !! to Convert to a Non-Nullable Type](#using-not-null-assertion-operator--to-convert-to-a-non-nullable-type) |

<br />

## 10.1 Checking for Null
### Using if Statement
```kotlin
val str: String? = null
if (str != null) {
    str.uppercase()
}
```

### Using Safe Call Operator ?.
```kotlin
val str: String? = null
str?.uppercase()
```

### Using Safe Call Operator ?. and let Scope Function
```kotlin
val str: String? = null
str?.let {
    it.uppercase()
}
```

<br />

## 10.2 Assigning Default Value for Null Value
### Using if Statement
```kotlin
val str: String? = null
val message: String = if (str != null) str else "Unknown"
```

### Using Elvis Operator ?:
```kotlin
val str: String? = null
val message: String = str ?: "Unknown"
```

<br />

## 10.3 Ignoring Null Safety
### Using Not-Null Assertion Operator !! to Call a Function
```kotlin
val str: String? = "Hello World"
str!!.uppercase()
```

### Using Not-Null Assertion Operator !! to Convert to a Non-Nullable Type
```kotlin
val str: String? = "Hello World"
val message: String = str!!
```

<br />
