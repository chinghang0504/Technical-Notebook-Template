# [Kotlin Note](../../README.md) - Chapter 1 IO
| Chapter | Title |
| :-: | :- |
| 1.1 | [Console Output](#11-console-output) |
|  | [Kotlin: print()](#kotlin-print) |
|  | [Kotlin: println()](#kotlin-println) |
| 1.2 | [Console Input](#12-console-input) |
|  | [Kotlin: readLine()](#kotlin-readline) |
|  | [Kotlin: readln()](#kotlin-readln) |
|  | [Kotlin: readlnOrNull()](#kotlin-readlnornull) |

<br />

## 1.1 Console Output
### [Kotlin: print()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/print.html)
- Prints the given message to the standard output stream.
```kotlin
fun print(message: Any?)
```

- Prints the given message to the standard output stream.
```kotlin
fun print(message: Int)
fun print(message: Long)
fun print(message: Byte)
fun print(message: Short)
fun print(message: Char)
fun print(message: Boolean)
fun print(message: Float)
fun print(message: Double)
fun print(message: CharArray)
```

### [Kotlin: println()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/println.html)
- Prints the line separator to the standard output stream.
```kotlin
fun println()
```

- Prints the given message and the line separator to the standard output stream.
```kotlin
fun println(message: Any?)
```

- Prints the given message and the line separator to the standard output stream.
```kotlin
fun println(message: Int)
fun println(message: Long)
fun println(message: Byte)
fun println(message: Short)
fun println(message: Char)
fun println(message: Boolean)
fun println(message: Float)
fun println(message: Double)
fun println(message: CharArray)
```

<br />

## 1.2 Console Input
### [Kotlin: readLine()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/read-line.html)
- Reads a line of input from the standard input stream.
```kotlin
fun readLine(): String?
```

### [Kotlin: readln()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/readln.html)
- Reads a line of input from the standard input stream and returns it, or throws a RuntimeException if EOF has already been reached when readln is called.
```kotlin
fun readln(): String
```

### [Kotlin: readlnOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/readln-or-null.html)
- Reads a line of input from the standard input stream and returns it, or return null if EOF has already been reached when readlnOrNull is called.
```kotlin
fun readlnOrNull(): String?
```

<br />
