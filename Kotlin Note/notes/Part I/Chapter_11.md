# [Kotlin Note](../../README.md) - Chapter 11 Exceptions
| Chapter | Title |
| :-: | :- |
| 11.1 | [Throwing Exceptions](#111-throwing-exceptions) |
|  | [Using throw Keyword](#using-throw-keyword) |
| 11.2 | [Catching Exceptions](#112-catching-exceptions) |
|  | [Using try-catch Statements](#using-try-catch-statements) |
|  | [Using try-catch-finally Statments](#using-try-catch-finally-statments) |
|  | [Using try-catch Expressions](#using-try-catch-expressions) |
|  | [Using try-catch-finally Expressions](#using-try-catch-finally-expressions) |
| 11.3 | [Nothing](#113-nothing) |
| 11.4 | [Precondition Functions](#114-precondition-functions) |
|  | [Kotlin: check()](#kotlin-check) |
|  | [Kotlin: checkNotNull()](#kotlin-checknotnull) |
|  | [Kotlin: require()](#kotlin-require) |
|  | [Kotlin: requireNotNull()](#kotlin-requirenotnull) |
|  | [Kotlin: error()](#kotlin-error) |
|  | [Kotlin: assert()](#kotlin-assert) |
| 11.5 | [Custom Exceptions](#115-custom-exceptions) |

<br />

## 11.1 Throwing Exceptions
### Using throw Keyword
```kotlin
val str: String? = null
if (str == null) {
    throw NullPointerException()
}
```
```kotlin
val str: String? = null
str ?: throw NullPointerException()
```

<br />

## 11.2 Catching Exceptions
### Using try-catch Statements
```kotlin
val str: String? = null
try {
    str ?: throw NullPointerException()
} catch (e: NullPointerException) {
    println("Exception Block")
}
```

### Using try-catch-finally Statments
```kotlin
val str: String? = null
try {
    str ?: throw NullPointerException()
} catch (e: NullPointerException) {
    println("Exception Block")
} finally {
    println("Finally Block")
}
```

### Using try-catch Expressions
```kotlin
val str: String? = null
val message: String = try {
    str ?: throw NullPointerException()
    "Normal"
} catch (e: NullPointerException) {
    println("Exception Block")
    "Error"
}
```

### Using try-catch-finally Expressions
```kotlin
val str: String? = null
val message: String = try {
    str ?: throw NullPointerException()
    "Normal"
} catch (e: NullPointerException) {
    println("Exception Block")
    "Error"
} finally {
    println("Finally Block")
}
```

<br />

## 11.3 Nothing
- The throw expression has the type Nothing.
- This type has no values and is used to mark code locations that can never be reached.
```kotlin
fun systemFailed(): Nothing {
    throw RuntimeException("System Failed")
}
```

<br />

## 11.4 Precondition Functions
### [Kotlin: check()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/check.html)
- Throws an IllegalStateException if the value is false.
```kotlin
fun check(value: Boolean)
```

- Throws an IllegalStateException with the result of calling lazyMessage if the value is false.
```kotlin
inline fun check(value: Boolean, lazyMessage: () -> Any)
```

### [Kotlin: checkNotNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/check-not-null.html)
- Throws an IllegalStateException if the value is null. Otherwise returns the not null value.
```kotlin
fun <T : Any> checkNotNull(value: T?): T
```

- Throws an IllegalStateException with the result of calling lazyMessage if the value is null. Otherwise returns the not null value.
```kotlin
inline fun <T : Any> checkNotNull(
    value: T?,
    lazyMessage: () -> Any
): T
```

### [Kotlin: require()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html)
- Throws an IllegalArgumentException if the value is false.
```kotlin
fun require(value: Boolean)
```

- Throws an IllegalArgumentException with the result of calling lazyMessage if the value is false.
```kotlin
inline fun require(value: Boolean, lazyMessage: () -> Any)
```

### [Kotlin: requireNotNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require-not-null.html)
- Throws an IllegalArgumentException if the value is null. Otherwise returns the not null value.
```kotlin
fun <T : Any> requireNotNull(value: T?): T
```

- Throws an IllegalArgumentException with the result of calling lazyMessage if the value is null. Otherwise returns the not null value.
```kotlin
inline fun <T : Any> requireNotNull(
    value: T?,
    lazyMessage: () -> Any
): T
```

### [Kotlin: error()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/error.html)
- Throws an IllegalStateException with the given message.
```kotlin
fun error(message: Any): Nothing
```

### [Kotlin: assert()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/assert.html)
- Throws an AssertionError if the value is false and runtime assertions have been enabled on the JVM using the -ea JVM option.
```kotlin
fun assert(value: Boolean)
```

- Throws an AssertionError calculated by lazyMessage if the value is false and runtime assertions have been enabled on the JVM using the -ea JVM option.
```kotlin
inline fun assert(value: Boolean, lazyMessage: () -> Any)
```

<br />

## 11.5 Custom Exceptions
```kotlin
class IllegalValueException(message: String) : RuntimeException(message) {}
```
```kotlin
throw IllegalValueException("Illegal Value")
```

<br />
