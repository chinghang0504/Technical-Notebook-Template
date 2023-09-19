# [Kotlin Note](../../README.md) - Chapter 1 IO
| Chapter | Title |
| :-: | :- |
| 1.1 | [Console Output](#11-console-output) |
|  | [Function: print](#function-print) |
|  | [Function: println](#function-println) |
| 1.2 | [Console Input](#12-console-input) |
|  | [Function: readLine](#function-readline) |
|  | [Function: readln](#function-readln) |
|  | [Function: readlnOrNull](#function-readlnornull) |

<br />

## 1.1 Console Output
### [Function: print](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/print.html)
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

### [Function: println](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/println.html)
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
### [Function: readLine](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/read-line.html)
- Reads a line of input from the standard input stream.
```kotlin
fun readLine(): String?
```

### [Function: readln](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/readln.html)
- Reads a line of input from the standard input stream and returns it, or throws a RuntimeException if EOF has already been reached when readln is called.
```kotlin
fun readln(): String
```

### [Function: readlnOrNull](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/readln-or-null.html)
- Reads a line of input from the standard input stream and returns it, or return null if EOF has already been reached when readlnOrNull is called.
```kotlin
fun readlnOrNull(): String?
```

<br />
