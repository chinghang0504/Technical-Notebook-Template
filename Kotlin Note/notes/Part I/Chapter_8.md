# [Kotlin Note](../../README.md) - Chapter 8 Strings
| Chapter | Title |
| :-: | :- |
| 8.1 | [Escape Sequences](#81-escape-sequences) |
| 8.2 | [String Concatenation](#82-string-concatenation) |
| 8.3 | [String Interpolation](#83-string-interpolation) |
|  | [Interpolating a Variable](#interpolating-a-variable) |
|  | [Interpolating an Expression](#interpolating-an-expression) |
| 8.4 | [Raw Strings](#84-raw-strings) |
|  | [Using Pipe Character and trimMargin Method](#using-pipe-character-and-trimmargin-method) |
|  | [Using trimIndent Method](#using-trimindent-method) |
| 8.5 | [Coverting Strings to Numbers](#85-coverting-strings-to-numbers) |
|  | [String to Byte](#string-to-byte) |
|  | [String to Short](#string-to-short) |
|  | [String to Int](#string-to-int) |
|  | [String to Long](#string-to-long) |
|  | [String to Float](#string-to-float) |
|  | [String to Double](#string-to-double) |
| 8.6 | [Formatting Numbers](#86-formatting-numbers) |
|  | [Using format Method](#using-format-method) |
| 8.7 | [Regular Expressions](#87-regular-expressions) |
|  | [Using matches Method](#using-matches-method) |
| 8.8 | [String Manipulation](#88-string-manipulation) |
|  | [Using replace Method](#using-replace-method) |
| 8.9 | [String Comparsion](#89-string-comparsion) |
| 8.10 | [String Searching](#810-string-searching) |
|  | [Using contains Method](#using-contains-method) |
| 8.11 | [Unicode](#811-unicode) |

<br />

## 8.1 Escape Sequences
| Symbol | Description |
| :--: | :-- |
| \\t | Tab |
| \\b | Backspace |
| \\n | Newline |
| \\r | Carriage return |
| \\" | Double quotation mark |
| \\' | Single quotation mark |
| \\\\ | Backslash |
| \\$ | Dollar sign |
| \\u | Unicode |

<br />

## 8.2 String Concatenation
```kotlin
val str: String = "Hello" + " World"
```
<br />

## 8.3 String Interpolation
### Interpolating a Variable
```kotlin
val world: String = "World"
val str: String = "Hello $world"
```

### Interpolating an Expression
```kotlin
val str: String = "Hello ${"world".uppercase()}"
```

<br />

## 8.4 Raw Strings
```kotlin
val str: String =
        """Hello
World"""
```

### Using Pipe Character and trimMargin Method
- The pipe character \| defines the start of each line of the string.
- The trimMargin method removes the pipe character and all the indents on the left of the pipe character.

```kotlin
val str: String =
    """
    |Hello
    |World
    """.trimMargin()
```

### Using trimIndent Method
- The trimIndent method calculates the minimal indent of all the input lines and removes minimal indents of each line.

```kotlin
val str: String =
    """
    Hello
    World
    """.trimIndent()
```

<br />

## 8.5 Coverting Strings to Numbers
### String to Byte
```kotlin
val str: String = "100"
val num: Byte = str.toByte()
```

### String to Short
```kotlin
val str: String = "100"
val num: Short = str.toShort()
```

### String to Int
```kotlin
val str: String = "100"
val num: Int = str.toInt()
```

### String to Long
```kotlin
val str: String = "100"
val num: Long = str.toLong()
```

### String to Float
```kotlin
val str: String = "99.9"
val num: Float = str.toFloat()
```

### String to Double
```kotlin
val str: String = "99.9"
val num: Double = str.toDouble()
```

<br />

## 8.6 Formatting Numbers
### Using format Method
```kotlin
val num: Double = 5.2 / 3.1
val str: String = String.format("%.2f", num)    // 1.68
```

<br />

## 8.7 Regular Expressions
### Using matches Method
```kotlin
val str: String = "100"
val isInteger: Boolean = str.matches("""\d+""".toRegex())
```
<br />

## 8.8 String Manipulation
### Using replace Method
```kotlin
val helloWorld: String = "Hello World"
val str: String = helloWorld.replace("World", "Hello")
```

<br />

## 8.9 String Comparsion
| Operator | Description |
| :--: | :-- |
| < | (String Value) Less than |
| <= | (String Value) Less than or equal to |
| > | (String Value) Greater than |
| >= | (String Value) Greater than or equal to |
| == | (String Value) Equal to |
| != | (String Value) Not equal to |
| === | (String Reference) Equal to |
| !== | (String Reference) Not equal to |

```kotlin
val hello: String = "Hello"
val world: String = "World"

println(hello < world)      // true
println(hello <= world)     // true
println(hello > world)      // false
println(hello >= world)     // false
println(hello == world)     // false
println(hello != world)     // true
println(hello === world)    // false
println(hello !== world)    // true
```

<br />

## 8.10 String Searching
### Using contains Method
```kotlin
val str: String = "Hello World"
println(str.contains("e"))
println(str.contains("He"))
```

<br />

## 8.11 Unicode
```kotlin
val str: String = "\u0041\u0042\u0043"
```

<br />
