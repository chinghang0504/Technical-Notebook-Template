# [Kotlin Note](../../README.md) - Chapter 3 Variables and Constants
| Chapter | Title |
| :-: | :- |
| 3.1 | [Variables](#31-variables) |
|  | [Variable Declaration](#variable-declaration) |
|  | [Variable Declaration with Type Inference](#variable-declaration-with-type-inference) |
|  | [Variable Declaration without Initializing](#variable-declaration-without-initializing) |
|  | [Assignment Operator](#assignment-operator) |
| 3.2 | [Constants](#32-constants) |
|  | [Run-Time Constant Declaration](#run-time-constant-declaration) |
|  | [Run-Time Constant Declaration with Type Inference](#run-time-constant-declaration-with-type-inference) |
|  | [Compile-Time Constants](#compile-time-constants) |
|  | [Compile-Time Constant Declaration](#compile-time-constant-declaration) |
|  | [Compile-Time Constant Declaration with Type Inference](#compile-time-constant-declaration-with-type-inference) |

<br />

## 3.1 Variables
### Variable Declaration
```kotlin
var num: Int = 100
```

### Variable Declaration with Type Inference
```kotlin
var num = 100
```

### Variable Declaration without Initializing
```kotlin
var num: Int
```

### Assignment Operator
```kotlin
num = 100
```

<br />

## 3.2 Constants
- There are two types of constants:
    1. Run-Time Constants
    2. Compile-Time Constants

### Run-Time Constant Declaration
```kotlin
val num: Int = 100
```

### Run-Time Constant Declaration with Type Inference
```kotlin
val num = 100
```

### Compile-Time Constants
- Kotlin supports primitives and String for a compile-time constant.

| Signed Integers | Unsigned Integers | Floating Point Numbers | Booleans | Characters | Strings |
| :-- | :-- | :-- | :-- | :-- | :-- |
| Byte | UByte | Float | Boolean | Char | String |
| Short | UShort | Double |  |  |  |
| Int | UInt |  |  |  |  |
| Long | ULong |  |  |  |  |

### Compile-Time Constant Declaration
```kotlin
const val num: Int = 100
```

### Compile-Time Constant Declaration with Type Inference
```kotlin
const val num = 100
```

<br />
