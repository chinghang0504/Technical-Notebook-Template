# [Kotlin Note](../../README.md) - Chapter 4 Ranges and Progressions
| Chapter | Title |
| :-: | :- |
| 4.1 | [Ranges](#41-ranges) |
|  | [.. Operator or rangeTo Function](#operator-or-rangeto-function) |
|  | [..< Operator or rangeUntil Function](#operator-or-rangeuntil-function) |
|  | [until Function](#until-function) |
|  | [IntRange: toList](#intrange-tolist) |
| 4.2 | [Progressions](#42-progressions) |
|  | [downTo Function](#downto-function) |
|  | [step Function](#step-function) |
|  | [IntProgression: toList](#intprogression-tolist) |

<br />

## 4.1 Ranges
### .. Operator or rangeTo Function
```kotlin
val intRange: IntRange = 1 .. 3             // 1, 2, 3
```
```kotlin
val intRange: IntRange = 1.rangeTo(3)       // 1, 2, 3
```

### ..< Operator or rangeUntil Function
```kotlin
val intRange: IntRange = 1 ..< 3            // 1, 2
```
```kotlin
val intRange: IntRange = 1.rangeUntil(3)    // 1, 2
```

### until Function
```kotlin
val intRange: IntRange = 1 until 3          // 1, 2
```
```kotlin
val intRange: IntRange = 1.until(3)         // 1, 2
```

### IntRange: toList
```kotlin
val intRange: IntRange = 1 .. 3
println(intRange.toList())                  // [1, 2, 3]
```

<br />

## 4.2 Progressions
### downTo Function
```kotlin
val intProgression: IntProgression = 3 downTo 1         // 3, 2, 1
```
```kotlin
val intProgression: IntProgression = 3.downTo(1)        // 3, 2, 1
```

### step Function
```kotlin
val intProgression: IntProgression = 1 .. 10 step 3     // 1, 4, 7, 10
```
```kotlin
val intProgression: IntProgression = (1 .. 10).step(3)  // 1, 4, 7, 10
```

### IntProgression: toList
```kotlin
val intProgression: IntProgression = 3 downTo 1
println(intProgression.toList())                        // [3, 2, 1]
```

<br />
