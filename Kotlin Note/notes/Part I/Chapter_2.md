# [Kotlin Note](../../README.md) - Chapter 2 Basic Types
| Chapter | Title |
| :-: | :- |
| 2.1 | [Numbers](#21-numbers) |
|  | [Integer Types](#integer-types) |
|  | [Unsigned Integer Types](#unsigned-integer-types) |
|  | [Floating-Point Types](#floating-point-types) |
| 2.2 | [Booleans](#22-booleans) |
| 2.3 | [Characters](#23-characters) |
| 2.4 | [Strings](#24-strings) |
| 2.5 | [Arrays](#25-arrays) |

<br />

## 2.1 [Numbers](https://kotlinlang.org/docs/numbers.html)
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

## 2.2 [Booleans](https://kotlinlang.org/docs/booleans.html)
- Type: Boolean
```kotlin
val trueBool: Boolean = true
val falseBool: Boolean = false
```

<br />

## 2.3 [Characters](https://kotlinlang.org/docs/characters.html)
- Type: Char
```kotlin
val ch: Char = 'A'
```

<br />

## 2.4 [Strings](https://kotlinlang.org/docs/strings.html)
- Type: String
```kotlin
val str: String = "Hello World"
```

<br />

## 2.5 [Arrays](https://kotlinlang.org/docs/arrays.html)
- Type: Array\<T>
```kotlin
val arr: Array<Int> = arrayOf(1, 2, 3)
```

<br />
