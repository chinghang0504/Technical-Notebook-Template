# [Kotlin Note](../../README.md) - Chapter 3 Variables and Constants
| Chapter | Title |
| :-: | :- |
| 3.1 | [Variables](#31-variables) |
|  | [Variable Declaration without Type Inference](#variable-declaration-without-type-inference) |
|  | [Variable Declaration with Type Inference](#variable-declaration-with-type-inference) |
|  | [Variable Declaration without Initializing](#variable-declaration-without-initializing) |
| 3.2 | [Assigning Value to a Variable](#32-assigning-value-to-a-variable) |
|  | [Using Assignment Operator =](#using-assignment-operator) |
| 3.3 | [Constants](#33-constants) |
|  | [Run-Time Constant Declaration without Type Inference](#run-time-constant-declaration-without-type-inference) |
|  | [Run-Time Constant Declaration with Type Inference](#run-time-constant-declaration-with-type-inference) |
|  | [Compile-Time Constants](#compile-time-constants) |
|  | [Compile-Time Constant Declaration without Type Inference](#compile-time-constant-declaration-without-type-inference) |
|  | [Compile-Time Constant Declaration with Type Inference](#compile-time-constant-declaration-with-type-inference) |

<br />

## 3.1 Variables
### Variable Declaration without Type Inference
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

<br />

## 3.2 Assigning Value to a Variable
### Using Assignment Operator =
```kotlin
num = 100
```

<br />

## 3.3 Constants
- There are two types of constants:
    1. Run-time constants
    2. Compile-time constants

### Run-Time Constant Declaration without Type Inference
```kotlin
val num: Int = 100
```

### Run-Time Constant Declaration with Type Inference
```kotlin
val num = 100
```

### Compile-Time Constants
- Kotlin only supports primitives and String for a compile-time constant.

| Integer Types | Unsigned Integer Types | Floating-Point Types | Booleans | Characters | Strings |
| :-- | :-- | :-- | :-- | :-- | :-- |
| Byte | UByte | Float | Boolean | Char | String |
| Short | UShort | Double |  |  |  |
| Int | UInt |  |  |  |  |
| Long | ULong |  |  |  |  |

### Compile-Time Constant Declaration without Type Inference
```kotlin
const val num: Int = 100
```

### Compile-Time Constant Declaration with Type Inference
```kotlin
const val num = 100
```

<br />
