# [Kotlin Note](../../README.md) - Chapter 4 Ranges and Progressions
| Chapter | Title |
| :-: | :- |
| 4.1 | [Ranges](#41-ranges) |
|  | [Int: rangeTo() and .. Operator](#int-rangeto-and--operator) |
|  | [Int: rangeUntil() and ..< Operator](#int-rangeuntil-and--operator) |
|  | [Int: until()](#int-until) |
|  | [Iterable: toList()](#iterable-tolist) |
| 4.2 | [Progressions](#42-progressions) |
|  | [Int: downTo()](#int-downto) |
|  | [IntRange: step()](#intrange-step) |
|  | [Iterable: toList()](#iterable-tolist-1) |

<br />

## 4.1 Ranges
### [Int: rangeTo() and .. Operator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/range-to.html)
- Creates a range from this value to the specified other value.
```kotlin
operator fun rangeTo(other: Int): IntRange
```

<br />

```kotlin
val intRange: IntRange = 1.rangeTo(3)       // 1, 2, 3
```
```kotlin
val intRange: IntRange = 1 .. 3             // 1, 2, 3
```

### [Int: rangeUntil() and ..< Operator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/range-until.html)
- Creates a range from this value up to but excluding the specified other value.
```kotlin
operator fun rangeUntil(other: Int): IntRange
```

<br />

```kotlin
val intRange: IntRange = 1.rangeUntil(3)    // 1, 2
```
```kotlin
val intRange: IntRange = 1 ..< 3            // 1, 2
```

### [Int: until()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/until.html)
- Returns a range from this value up to but excluding the specified to value.
```kotlin
infix fun Int.until(to: Int): IntRange
```

<br />

```kotlin
val intRange: IntRange = 1 until 3          // 1, 2
```
```kotlin
val intRange: IntRange = 1.until(3)         // 1, 2
```

### [Iterable: toList()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-list.html)
- Returns a List containing all elements.
```kotlin
fun <T> Iterable<T>.toList(): List<T>
```

<br />

```kotlin
val intRange: IntRange = 1 .. 3
val list: List<Int> = intRange.toList()     // [1, 2, 3]
```

<br />

## 4.2 Progressions
### [Int: downTo()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/down-to.html)
- Returns a progression from this value down to the specified to value with the step -1.
```kotlin
infix fun Int.downTo(to: Int): IntProgression
```

<br />

```kotlin
val intProgression: IntProgression = 3 downTo 1             // 3, 2, 1
```
```kotlin
val intProgression: IntProgression = 3.downTo(1)            // 3, 2, 1
```

### [IntRange: step()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/step.html)
- Returns a progression that goes over the same range with the given step.
```kotlin
infix fun IntProgression.step(step: Int): IntProgression
```

<br />

```kotlin
val intProgression: IntProgression = 1 .. 10 step 3         // 1, 4, 7, 10
```
```kotlin
val intProgression: IntProgression = (1 .. 10).step(3)      // 1, 4, 7, 10
```

### [Iterable: toList()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-list.html)
- Returns a List containing all elements.
```kotlin
fun <T> Iterable<T>.toList(): List<T>
```

<br />

```kotlin
val intProgression: IntProgression = 3 downTo 1
val list: List<Int> = intProgression.toList()               // [3, 2, 1]
```

<br />
