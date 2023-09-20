# [Kotlin Note](../../README.md) - Chapter 8 Numbers
| Chapter | Title |
| :-: | :- |
| 8.1 | [Number Data Types](#81-number-data-types) |
|  | [Signed Integer Data Types](#signed-integer-data-types) |
|  | [Unsigned Integer Data Types](#unsigned-integer-data-types) |
|  | [Floating Point Number Data Types](#floating-point-number-data-types) |
| 8.2 | [Number Literals](#82-number-literals) |
|  | [Decimals](#decimals) |
|  | [Long Integers](#long-integers) |
|  | [Hexadecimals](#hexadecimals) |
|  | [Binaries](#binaries) |
|  | [Unsigned Integers](#unsigned-integers) |
|  | [Float Numbers](#float-numbers) |
|  | [Double Numbers](#double-numbers) |
| 8.3 | [Number Operators and Operations](#83-number-operators-and-operations) |
|  | [Integer Operators](#integer-operators) |
|  | [Floating Point Operators](#floating-point-operators) |
|  | [Bitwise Operations](#bitwise-operations) |
| 8.4 | [Coverting Between Numeric Types](#84-coverting-between-numeric-types) |
|  | [Coverting Byte to Other Numeric Types](#coverting-byte-to-other-numeric-types) |
|  | [Coverting Short to Other Numeric Types](#coverting-short-to-other-numeric-types) |
|  | [Coverting Int to Other Numeric Types](#coverting-int-to-other-numeric-types) |
|  | [Coverting Long to Other Numeric Types](#coverting-long-to-other-numeric-types) |
|  | [Coverting Float to Other Numeric Types](#coverting-float-to-other-numeric-types) |
|  | [Coverting Double to Other Numeric Types](#coverting-double-to-other-numeric-types) |
| 8.5 | [Rounding Between Numeric Types](#85-rounding-between-numeric-types) |
|  | [Rounding Float to Other Numeric Types](#rounding-float-to-other-numeric-types) |
|  | [Rounding Double to Other Numeric Types](#rounding-double-to-other-numeric-types) |
| 8.6 | [Numbers to Strings](#86-numbers-to-strings) |

<br />

## 8.1 Number Data Types
### Signed Integer Data Types
| Type | Bytes |
| :-- | :-- |
| Byte | 1 |
| Short | 2 |
| Int | 4 |
| Long | 8 |

### Unsigned Integer Data Types
| Type | Bytes |
| :-- | :-- |
| UByte | 1 |
| UShort | 2 |
| UInt | 4 |
| ULong | 8 |

### Floating Point Number Data Types
| Type | Bytes |
| :-- | :-- |
| Float | 4 |
| Double | 8 |

<br />

## 8.2 Number Literals
### Decimals
```kotlin
val num: Int = 100
```

### Long Integers
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

### Float Numbers
```kotlin
val num: Float = 100.0f
```
```kotlin
val num: Float = 100.0F
```

### Double Numbers
```kotlin
val num: Double = 100.0
```

<br />

## 8.3 Number Operators and Operations
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

### Floating Point Operators
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
| inv | Inverts bits |
| shl | Left shift |
| shr | Right shift |
| ushr | Unsigned right shift |

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
### Coverting Byte to Other Numeric Types
```kotlin
val num: Byte = 100
val short: Short = num.toShort()
val int: Int = num.toInt()
val long: Long = num.toLong()
val float: Float = num.toFloat()
val double: Double = num.toDouble()
```

### Coverting Short to Other Numeric Types
```kotlin
val num: Short = 100
val byte: Byte = num.toByte()
val int: Int = num.toInt()
val long: Long = num.toLong()
val float: Float = num.toFloat()
val double: Double = num.toDouble()
```

### Coverting Int to Other Numeric Types
```kotlin
val num: Int = 100
val byte: Byte = num.toByte()
val short: Short = num.toShort()
val long: Long = num.toLong()
val float: Float = num.toFloat()
val double: Double = num.toDouble()
```

### Coverting Long to Other Numeric Types
```kotlin
val num: Long = 100
val byte: Byte = num.toByte()
val short: Short = num.toShort()
val int: Int = num.toInt()
val float: Float = num.toFloat()
val double: Double = num.toDouble()
```

### Coverting Float to Other Numeric Types
```kotlin
val num: Float = 100.0F
val int: Int = num.toInt()
val long: Long = num.toLong()
val double: Double = num.toDouble()
```

### Coverting Double to Other Numeric Types
```kotlin
val num: Double = 100.0
val int: Int = num.toInt()
val long: Long = num.toLong()
val float: Float = num.toFloat()
```

<br />

## 8.5 Rounding Between Numeric Types
### Rounding Float to Other Numeric Types
```kotlin
val double1: Float = 9.1F
val int1: Int = double1.roundToInt()        // 9
val long1: Long = double1.roundToLong()     // 9

val double2: Float = 9.9F
val int2: Int = double2.roundToInt()        // 10
val long2: Long = double2.roundToLong()     // 10
```

### Rounding Double to Other Numeric Types
```kotlin
val double1: Double = 9.1
val int1: Int = double1.roundToInt()        // 9
val long1: Long = double1.roundToLong()     // 9

val double2: Double = 9.9
val int2: Int = double2.roundToInt()        // 10
val long2: Long = double2.roundToLong()     // 10
```

<br />

## 8.6 Numbers to Strings
```kotlin
val byte: Byte = 100
val short: Short = 100
val int: Int = 100
val long: Long = 100
val float: Float = 100F
val double: Double = 100.0

println(byte.toString())
println(short.toString())
println(int.toString())
println(long.toString())
println(float.toString())
println(double.toString())
```

<br />
