# [Kotlin Note](../../README.md) - Chapter 9 Strings
| Chapter | Title |
| :-: | :- |
| 9.1 | [String Literals](#91-string-literals) |
|  | [Escaped Strings](#escaped-strings) |
|  | [Multiline Strings](#multiline-strings) |
| 9.2 | [Escape Characters](#92-escape-characters) |
| 9.3 | [Unicode](#93-unicode) |
| 9.4 | [Multiline Strings](#94-multiline-strings) |
|  | [String: trimIndent()](#string-trimindent) |
|  | [String: trimMargin()](#string-trimmargin) |
| 9.5 | [String Properties](#95-string-properties) |
|  | [String: length](#string-length) |
| 9.6 | [String Concatenation](#96-string-concatenation) |
|  | [Using Plus Operator +](#using-plus-operator) |
| 9.7 | [String Interpolation](#97-string-interpolation) |
|  | [Interpolating Variables](#interpolating-variables) |
|  | [Interpolating Expressions](#interpolating-expressions) |
| 9.8 | [Coverting Strings to Numbers](#98-coverting-strings-to-numbers) |
|  | [String: toByte()](#string-tobyte) |
|  | [String: toShort()](#string-toshort) |
|  | [String: toInt()](#string-toint) |
|  | [String: toLong()](#string-tolong) |
|  | [String: toFloat()](#string-tofloat) |
|  | [String: toDouble()](#string-todouble) |
|  | [String: toByteOrNull()](#string-tobyteornull) |
|  | [String: toShortOrNull()](#string-toshortornull) |
|  | [String: toIntOrNull()](#string-tointornull) |
|  | [String: toLongOrNull()](#string-tolongornull) |
|  | [String: toFloatOrNull()](#string-tofloatornull) |
|  | [String: toDoubleOrNull()](#string-todoubleornull) |
| 9.9 | [Formatting Numbers](#99-formatting-numbers) |
|  | [String: format()](#string-format) |
| 9.10 | [Regular Expressions](#910-regular-expressions) |
|  | [String: matches()](#string-matches) |
| 9.11 | [String Manipulation](#911-string-manipulation) |
|  | [String: replace()](#string-replace) |
| 9.12 | [String Searching](#912-string-searching) |
|  | [String: contains() or in Keyword](#string-contains-or-in-keyword) |
| 9.13 | [String Comparsion](#913-string-comparsion) |


<br />

## 9.1 [String Literals](https://kotlinlang.org/docs/strings.html#string-literals)
### Escaped Strings
- Escaped strings can contain escaped characters.
```kotlin
val str: String = "Hello World\n"
```

### Multiline Strings
- Multiline strings can contain newlines and arbitrary text. It is delimited by a triple quote ("""), contains no escaping and can contain newlines and any other characters:
```kotlin
val str: String = """
    Hello
    World
"""
```

<br />

## 9.2 [Escape Characters](https://kotlinlang.org/docs/characters.html)
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

## 9.3 Unicode
```kotlin
val str: String = "\u0041\u0042\u0043"
```

<br />

## 9.4 Multiline Strings
### [String: trimIndent()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim-indent.html) 
- Detects a common minimal indent of all the input lines, removes it from every line and also removes the first and the last lines if they are blank (notice difference blank vs empty).
```kotlin
fun String.trimIndent(): String
```

<br />

```kotlin
val str: String = """
    Hello
    World
""".trimIndent()
```

### [String: trimMargin()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/trim-margin.html)
- Trims leading whitespace characters followed by marginPrefix from every line of a source string and removes the first and the last lines if they are blank (notice difference blank vs empty).
```kotlin
fun String.trimMargin(marginPrefix: String = "|"): String
```

<br />

```kotlin
val str: String = """
    |Hello
    |World
""".trimMargin()
```

<br />

## 9.5 String Properties
### [String: length](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/length.html)
- Returns the length of this character sequence.
```kotlin
val length: Int
```

<br />

## 9.6 String Concatenation
### Using Plus Operator +
```kotlin
val str: String = "Hello" + " World"
```

<br />

## 9.7 String Interpolation
### Interpolating Variables
```kotlin
val world: String = "World"
val str: String = "Hello $world"
```

### Interpolating Expressions
```kotlin
val str: String = "Hello ${"world".uppercase()}"
```

<br />

## 9.8 Coverting Strings to Numbers
### [String: toByte()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-byte.html)
- Parses the string as a signed Byte number and returns the result.
```kotlin
fun String.toByte(): Byte
fun String.toByte(radix: Int): Byte
```

### [String: toShort()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-short.html)
- Parses the string as a Short number and returns the result.
```kotlin
fun String.toShort(): Short
fun String.toShort(radix: Int): Short
```

### [String: toInt()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-int.html)
- Parses the string as an Int number and returns the result.
```kotlin
fun String.toInt(): Int
fun String.toInt(radix: Int): Int
```

### [String: toLong()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-long.html)
- Parses the string as a Long number and returns the result.
```kotlin
fun String.toLong(): Long
fun String.toLong(radix: Int): Long
```

### [String: toFloat()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-float.html)
- Parses the string as a Float number and returns the result.
```kotlin
fun String.toFloat(): Float
```

### [String: toDouble()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-double.html)
- Parses the string as a Double number and returns the result.
```kotlin
fun String.toDouble(): Double
```

### [String: toByteOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-byte-or-null.html)
- Parses the string as a signed Byte number and returns the result or null if the string is not a valid representation of a number.
```kotlin
fun String.toByteOrNull(): Byte?
fun String.toByteOrNull(radix: Int): Byte?
```

### [String: toShortOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-short-or-null.html)
- Parses the string as a Short number and returns the result or null if the string is not a valid representation of a number.
```kotlin
fun String.toShortOrNull(): Short?
fun String.toShortOrNull(radix: Int): Short?
```

### [String: toIntOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-int-or-null.html)
- Parses the string as an Int number and returns the result or null if the string is not a valid representation of a number.
```kotlin
fun String.toIntOrNull(): Int?
fun String.toIntOrNull(radix: Int): Int?
```

### [String: toLongOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-long-or-null.html)
- Parses the string as a Long number and returns the result or null if the string is not a valid representation of a number.
```kotlin
fun String.toLongOrNull(): Long?
fun String.toLongOrNull(radix: Int): Long?
```

### [String: toFloatOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-float-or-null.html)
- Parses the string as a Float number and returns the result or null if the string is not a valid representation of a number.
```kotlin
fun String.toFloatOrNull(): Float?
```

### [String: toDoubleOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-double-or-null.html)
- Parses the string as a Double number and returns the result or null if the string is not a valid representation of a number.
```kotlin
fun String.toDoubleOrNull(): Double?
```

<br />

## 9.9 Formatting Numbers
### [String: format()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/format.html)
- Uses the provided format as a format string and returns a string obtained by substituting the specified arguments, using the default locale.
```kotlin
fun String.Companion.format(
    format: String,
    vararg args: Any?
): String
```

<br />

```kotlin
val num: Double = 5.2 / 3.1
val string: String = String.format("%.2f", num)     // 1.68
```

<br />

## 9.10 Regular Expressions
### [String: matches()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/matches.html)
- Returns true if this char sequence matches the given regular expression.
```kotlin
infix fun CharSequence.matches(regex: Regex): Boolean
```

<br />

```kotlin
val str: String = "100"
val isInteger: Boolean = str.matches("""\d+""".toRegex())
```

<br />

## 9.11 String Manipulation
### [String: replace()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/replace.html)
- Returns a new string obtained by replacing all occurrences of the oldValue substring in this string with the specified newValue string.
```kotlin
fun String.replace(
    oldValue: String,
    newValue: String,
    ignoreCase: Boolean = false
): String
```

<br />

```kotlin
val helloWorld: String = "Hello World"
val string: String = helloWorld.replace("World", "Hello")
```

<br />

## 9.12 String Searching
### [String: contains() or in Keyword](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/contains.html)
- Returns true if this char sequence contains the specified other sequence of characters as a substring.
```kotlin
operator fun CharSequence.contains(
    other: CharSequence,
    ignoreCase: Boolean = false
): Boolean
```

- Returns true if this char sequence contains the specified character char.
```kotlin
operator fun CharSequence.contains(
    char: Char,
    ignoreCase: Boolean = false
): Boolean
```

<br />

```kotlin
val string: String = "Hello World"

println(string.contains('e'))
println('e' in string)

println(string.contains("He"))
println("He" in string)
```

<br />

## 9.13 String Comparsion
| Operator | Target | Description |
| :--: | :-- | :-- |
| < | Value | Less than |
| <= | Value | Less than or equal to |
| > | Value | Greater than |
| >= | Value | Greater than or equal to |
| == | Value | Equal to |
| != | Value | Not equal to |
| === | Reference | Equal to |
| !== | Reference | Not equal to |

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
