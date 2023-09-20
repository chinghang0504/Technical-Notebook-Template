# [Kotlin Note](../../README.md) - Chapter 10 Null Safety
| Chapter | Title |
| :-: | :- |
| 10.1 | [Nullable Data Types](#101-nullable-data-types) |
| 10.2 | [Checking Null Value](#102-checking-null-value) |
|  | [Using if Statement](#using-if-statement) |
|  | [Using Safe Call Operator](#using-safe-call-operator) |
|  | [Using Safe Call Operator and let Scope Function](#using-safe-call-operator-and-let-scope-function) |
| 10.3 | [Assigning Default Value for Null Value](#103-assigning-default-value-for-null-value) |
|  | [Using Null Coalesing Operator](#using-null-coalesing-operator) |
| 10.4 | [Forcibly Removing Null Safety](#104-forcibly-removing-null-safety) |
|  | [Using Non-Null Assertion Operator to Call a Function](#using-non-null-assertion-operator-to-call-a-function) |
|  | [Using Non-Null Assertion Operator to Become a Non-Nullable Value](#using-non-null-assertion-operator-to-become-a-non-nullable-value) |

<br />

## 10.1 Nullable Data Types
```kotlin
val num: Int? = null
val str: String? = null
```

<br />

## 10.2 Checking Null Value
### Using if Statement
```kotlin
val str: String? = null
if (str != null) {
    str.uppercase()
}
```

### Using Safe Call Operator
```kotlin
val str: String? = null
str?.uppercase()
```

### Using Safe Call Operator and let Scope Function
```kotlin
val str: String? = null
str?.let {
    it.uppercase()
}
```

## 10.3 Assigning Default Value for Null Value
### Using Null Coalesing Operator
```kotlin
val str: String? = null
val message: String = str ?: "Unknown"
```

<br />

## 10.4 Forcibly Removing Null Safety
### Using Non-Null Assertion Operator to Call a Function
```kotlin
val str: String? = "Hello World"
str!!.uppercase()
```

### Using Non-Null Assertion Operator to Become a Non-Nullable Value
```kotlin
val str: String? = "Hello World"
val message: String = str!!
```

<br />
