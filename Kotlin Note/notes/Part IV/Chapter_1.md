# [Kotlin Note](../../README.md) - Chapter 1 IO
| Chapter | Title |
| :-: | :- |
| 1.1 | [Console Output](#11-console-output) |
|  | [Global: print()](#global-print) |
|  | [Global: println()](#global-println) |
| 1.2 | [Console Input](#12-console-input) |
|  | [Global: readLine()](#global-readline) |
|  | [Global: readln()](#global-readln) |
|  | [Global: readlnOrNull()](#global-readlnornull) |

<br />

## 1.1 Console Output
### [Global: print()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/print.html)
- Prints the given message to the standard output stream.
```kotlin
fun print(message: Any?)
```

<br />

```kotlin
print("Hello World")
```

### [Global: println()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/println.html)
- Prints the line separator to the standard output stream.
```kotlin
fun println()
```

- Prints the given message and the line separator to the standard output stream.
```kotlin
fun println(message: Any?)
```

<br />

```kotlin
println()
println("Hello World")
```

<br />

## 1.2 Console Input
### [Global: readLine()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/read-line.html)
- Reads a line of input from the standard input stream.
```kotlin
fun readLine(): String?
```

<br />

```kotlin
val input: String? = readLine()
```

### [Global: readln()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/readln.html)
- Reads a line of input from the standard input stream and returns it, or throws a RuntimeException if EOF has already been reached when readln is called.
```kotlin
fun readln(): String
```

<br />

```kotlin
val input: String = readln()
```

### [Global: readlnOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/readln-or-null.html)
- Reads a line of input from the standard input stream and returns it, or return null if EOF has already been reached when readlnOrNull is called.
```kotlin
fun readlnOrNull(): String?
```

<br />

```kotlin
val input: String? = readlnOrNull()
```

<br />
