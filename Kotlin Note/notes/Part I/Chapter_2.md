# [Kotlin Note](../../README.md) - Chapter 2 Built-In Data Types
| Chapter | Title |
| :-: | :- |
| 2.1 | [Numbers](#21-numbers) |
|  | [Signed Integers](#signed-integers) |
|  | [Unsigned Integers](#unsigned-integers) |
|  | [Floating Point Numbers](#floating-point-numbers) |
| 2.2 | [Booleans](#22-booleans) |
| 2.3 | [Characters](#23-characters) |
| 2.4 | [Strings](#24-strings) |
| 2.5 | [Collections](#25-collections) |
|  | [Mutable Collections](#mutable-collections) |
|  | [Immutable Collections](#immutable-collections) |

<br />

## 2.1 Numbers
### Signed Integers
| Type | Description | Bytes | Example |
| :-- | :-- | :-- | :-- |
| Byte | Signed integer | 1 | 100 |
| Short | Signed integer | 2 | 100 |
| Int | Signed integer | 4 | 100 |
| Long | Signed integer | 8 | 100 |

### Unsigned Integers
| Type | Description | Bytes | Example |
| :-- | :-- | :-- | :-- |
| UByte | Unsigned integer | 1 | 100u |
| UShort | Unsigned integer | 2 | 100u |
| UInt | Unsigned integer | 4 | 100u |
| ULong | Unsigned integer | 8 | 100u |

### Floating Point Numbers
| Type | Description | Bytes | Example |
| :-- | :-- | :-- | :-- |
| Float | Floating point number | 4 | 100.0F |
| Double | Floating point number | 8 | 100.0 |

<br />

## 2.2 Booleans
| Type | Description | Example |
| :-- | :-- | :-- |
| Boolean | Boolean Value | true |
|  |  | false |

<br />

## 2.3 Characters
| Type | Description | Example |
| :-- | :-- | :-- |
| Char | Character | 'A' |

<br />

## 2.4 Strings
| Type | Description | Example |
| :-- | :-- | :-- |
| String | Sequence of characters | "Hello World" |

<br />

## 2.5 Collections
### Mutable Collections
| Type | Description | Change Size | Change Element though Index/Key | Example |
| :-- | :-- | :--: | :--: | :-- |
| MutableList\<Int> | Mutable list | Y | Y | mutableListOf(1, 2, 3) |
| MutableSet\<Int> | Mutable Set | Y | - | mutableSetOf(1, 2, 3) |
| MutableMap\<Int, Char> | Mutable Map | Y | Y | mutableMapOf(1 to 'A', 2 to 'B', 3 to 'C') |

### Immutable Collections
| Type | Description | Change Size | Change Element though Index/Key | Example |
| :-- | :-- | :--: | :--: | :-- |
| List\<Int> | Immutable list | N | N | listOf(1, 2, 3) |
| Set\<Int> | Immutable Set | N | - | setOf(1, 2, 3) |
| Map\<Int, Char> | Immutable Map | N | N | mapOf(1 to 'A', 2 to 'B', 3 to 'C') |

<br />
