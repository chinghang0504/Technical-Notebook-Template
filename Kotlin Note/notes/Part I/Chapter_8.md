# [Kotlin Note](../../README.md) - Chapter 8 Numbers
| Chapter | Title |
| :-: | :- |
| 8.1 | [Number Types](#81-number-types) |
|  | [Integer Types](#integer-types) |
|  | [Unsigned Integer Types](#unsigned-integer-types) |
|  | [Floating-Point Types](#floating-point-types) |
| 8.2 | [Number Literals](#82-number-literals) |
|  | [Decimals](#decimals) |
|  | [Longs](#longs) |
|  | [Hexadecimals](#hexadecimals) |
|  | [Binaries](#binaries) |
|  | [Unsigned Integers](#unsigned-integers) |
|  | [Doubles](#doubles) |
|  | [Floats](#floats) |
| 8.3 | [Number Operators and Operations](#83-number-operators-and-operations) |
|  | [Integer Operators](#integer-operators) |
|  | [Floating-Point Operators](#floating-point-operators) |
|  | [Bitwise Operations](#bitwise-operations) |
| 8.4 | [Coverting Between Numeric Types](#84-coverting-between-numeric-types) |
|  | [Number: toByte()](#number-tobyte) |
|  | [Number: toShort()](#number-toshort) |
|  | [Number: toInt()](#number-toint) |
|  | [Number: toLong()](#number-tolong) |
|  | [Number: toFloat()](#number-tofloat) |
|  | [Number: toDouble()](#number-todouble) |
| 8.5 | [Rounding Between Numeric Types](#85-rounding-between-numeric-types) |
|  | [Double: roundToInt()](#double-roundtoint) |
|  | [Float: roundToInt()](#float-roundtoint) |
|  | [Double: roundToLong()](#double-roundtolong) |
|  | [Float: roundToLong()](#float-roundtolong) |
| 8.6 | [Numbers to Strings](#86-numbers-to-strings) |
|  | [Byte: toString()](#byte-tostring) |
|  | [Short: toString()](#short-tostring) |
|  | [Int: toString()](#int-tostring) |
|  | [Long: toString()](#long-tostring) |
|  | [Float: toString()](#float-tostring) |
|  | [Double: toString()](#double-tostring) |

<br />

## 8.1 [Number Types](https://kotlinlang.org/docs/numbers.html)
### [Integer Types](https://kotlinlang.org/docs/numbers.html#integer-types)
| Type | Size (bits) | Min Value | Max Value |
| :-- | :-- | :-- | :-- |
| Byte | 8 | -128 | 127 |
| Short | 16 | -32768 | 32767 |
| Int | 32 | -2,147,483,648 (-2^31) | 2,147,483,647 (2^31 - 1) |
| Long | 64 | -9,223,372,036,854,775,808 (-2^63) | 9,223,372,036,854,775,807 (2^63 - 1) |

### [Unsigned Integer Types](https://kotlinlang.org/docs/unsigned-integer-types.html)
| Type | Size (bits) | Min Value | Max Value |
| :-- | :-- | :-- | :-- |
| UByte | 8 | 0 | 255 |
| UShort | 16 | 0 | 65535 |
| UInt | 32 | 0 | 2^32 - 1 |
| ULong | 64 | 0 | 2^64 - 1 |

### [Floating-Point Types](https://kotlinlang.org/docs/numbers.html#floating-point-types)
| Type | Size (bits) | Significant Bits | Exponent Bits | Decimal Digits |
| :-- | :-- | :-- | :-- | :-- |
| Float | 32 | 24 | 8 | 6-7 |
| Double | 64 | 53 | 11 | 15-16 |

<br />

## 8.2 [Number Literals](https://kotlinlang.org/docs/numbers.html#literal-constants-for-numbers)
### Decimals
```kotlin
val num: Int = 100
```

### Longs
```kotlin
val num: Long = 100L
```

### Hexadecimals
```kotlin
val num: Int = 0x64
```
```kotlin
val num: Int = 0X64
```

### Binaries
```kotlin
val num: Int = 0b1100100
```
```kotlin
val num: Int = 0B1100100
```

### Unsigned Integers
```kotlin
val num: UInt = 100u
```

### Doubles
```kotlin
val num: Double = 100.0
```

### Floats
```kotlin
val num: Float = 100.0f
```
```kotlin
val num: Float = 100.0F
```

<br />

## 8.3 [Number Operators and Operations](https://kotlinlang.org/docs/numbers.html#operations-on-numbers)
### Integer Operators
| Operator | Description |
| :-- | :-- |
| + | Addition |
| - | Subtraction |
| * | Multiplication |
| / | Division |
| % | Remainder |

```kotlin
println(5 + 3)      // 8
println(5 - 3)      // 2
println(5 * 3)      // 15
println(5 / 3)      // 1
println(5 % 3)      // 2
```

### Floating-Point Operators
| Operator | Description |
| :-- | :-- |
| + | Addition |
| - | Subtraction |
| * | Multiplication |
| / | Division |
| % | Remainder |

```kotlin
println(5.2 + 3.1)      // 8.3
println(5.2 - 3.1)      // 2.1
println(5.2 * 3.1)      // 16.12
println(5.2 / 3.1)      // 1.6774193548387097
println(5.2 % 3.1)      // 2.1
```

### Bitwise Operations
| Function | Description |
| :-- | :-- |
| or | Bitwise or |
| and | Bitwise and |
| xor | Bitwise xor |
| inv | Bitwise inversion |
| shl | Signed shift left |
| shr | Signed shift right |
| ushr | Unsigned shift right |

```kotlin
println(Integer.toBinaryString(0b1100 or 0b0011))       // 1111
println(Integer.toBinaryString(0b1100.or(0b0011)))      // 1111

println(Integer.toBinaryString(0b1100 and 0b0011))      // 0
println(Integer.toBinaryString(0b1100.and(0b0011)))     // 0

println(Integer.toBinaryString(0b1100 xor 0b0011))      // 1111
println(Integer.toBinaryString(0b1100.xor(0b0011)))     // 1111

println(Integer.toBinaryString(0b1100.inv()))           // 11111111111111111111111111110011

println(Integer.toBinaryString(0b1100 shl 1))           // 11000
println(Integer.toBinaryString(0b1100.shl(1)))          // 11000

println(Integer.toBinaryString(0b1100 shr 1))           // 110
println(Integer.toBinaryString(0b1100.shr(1)))          // 110

println(Integer.toBinaryString(0b1100 ushr 1))          // 110
println(Integer.toBinaryString(0b1100.ushr(1)))         // 110
```

<br />

## 8.4 Coverting Between Numeric Types
### [Number: toByte()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/to-byte.html)
- Returns the value of this number as a Byte, which may involve rounding or truncation.
```kotlin
abstract fun toByte(): Byte
```

### [Number: toShort()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/to-short.html)
- Returns the value of this number as a Short, which may involve rounding or truncation.
```kotlin
abstract fun toShort(): Short
```

### [Number: toInt()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/to-int.html)
- Returns the value of this number as an Int, which may involve rounding or truncation.
```kotlin
abstract fun toInt(): Int
```

### [Number: toLong()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/to-long.html)
- Returns the value of this number as a Long, which may involve rounding or truncation.
```kotlin
abstract fun toLong(): Long
```

### [Number: toFloat()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/to-float.html)
- Returns the value of this number as a Float, which may involve rounding.
```kotlin
abstract fun toFloat(): Float
```

### [Number: toDouble()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/to-double.html)
- Returns the value of this number as a Double, which may involve rounding.
```kotlin
abstract fun toDouble(): Double
```

<br />

## 8.5 Rounding Between Numeric Types
### [Double: roundToInt()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/round-to-int.html)
- Rounds this Double value to the nearest integer and converts the result to Int. Ties are rounded towards positive infinity.
```kotlin
fun Double.roundToInt(): Int
```

### [Float: roundToInt()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/round-to-int.html)
- Rounds this Float value to the nearest integer and converts the result to Int. Ties are rounded towards positive infinity.
```kotlin
fun Float.roundToInt(): Int
```

### [Double: roundToLong()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/round-to-long.html)
- Rounds this Double value to the nearest integer and converts the result to Long. Ties are rounded towards positive infinity.
```kotlin
fun Double.roundToLong(): Long
```

### [Float: roundToLong()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/round-to-long.html)
- Rounds this Float value to the nearest integer and converts the result to Long. Ties are rounded towards positive infinity.
```kotlin
fun Float.roundToLong(): Long
```

<br />

## 8.6 Numbers to Strings
### [Byte: toString()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/to-string.html)
- Returns a string representation of the object.
```kotlin
fun toString(): String
```

### [Short: toString()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/to-string.html)
- Returns a string representation of the object.
```kotlin
fun toString(): String
```

### [Int: toString()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/to-string.html)
- Returns a string representation of the object.
```kotlin
fun toString(): String
```

### [Long: toString()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/to-string.html)
- Returns a string representation of the object.
```kotlin
fun toString(): String
```

### [Float: toString()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/to-string.html)
- Returns a string representation of the object.
```kotlin
fun toString(): String
```

### [Double: toString()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/to-string.html)
- Returns a string representation of the object.
```kotlin
fun toString(): String
```

<br />
