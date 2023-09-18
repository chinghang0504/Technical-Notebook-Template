# [Kotlin Note](../../README.md) - Chapter 5 Loops, Ranges, and Progressions
| Chapter | Title |
| :-: | :- |
| 5.1 | [Ranges](#51-ranges) |
|  | [.. Operator or rangeTo Method](#operator-or-rangeto-method) |
|  | [..< Operator, rangeUntil, until Method](#operator-rangeuntil-until-method) |
| 5.2 | [Progressions](#52-progressions) |
|  | [downTo Method](#downto-method) |
|  | [step Method](#step-method) |
| 5.3 | [Loops](#53-loops) |
|  | [for Loop](#for-loop) |
|  | [while Loop](#while-loop) |
|  | [do-while Loop](#do-while-loop) |
| 5.4 | [Loop Expressions](#54-loop-expressions) |
|  | [break Expression](#break-expression) |
|  | [continue Expression](#continue-expression) |

<br />

## 5.1 Ranges
### .. Operator or rangeTo Method
- This range includes the last number

```kotlin
val intRange: IntRange = 1 .. 3
```
```kotlin
val intRange: IntRange = 1.rangeTo(3)
```

### ..< Operator, rangeUntil, until Method
- This range does not include the last number

```kotlin
val intRange: IntRange = 1 ..< 3
```
```kotlin
val intRange: IntRange = 1.rangeUntil(3)
```
```kotlin
val intRange: IntRange = 1 until 3
```

<br />

## 5.2 Progressions
### downTo Method
```kotlin
val intProgression: IntProgression = 3 downTo 1
```

### step Method
```kotlin
val intProgression: IntProgression = 1 .. 10 step 2
```

<br />

## 5.3 Loops
### for Loop
```kotlin
for (i in 1..3) {
    println(i)
}
```

### while Loop
```kotlin
var i = 1
while (i <= 3) {
    println(i)
    i++
}
```

### do-while Loop
```kotlin
var i = 1
do {
    println(i)
    i++
} while (i <= 3)
```

<br />

## 5.4 Loop Expressions
### break Expression
```kotlin
for (i in 1 .. 3) {
    if (i == 2) {
        break;
    }
    println(i)
}
```

### continue Expression
```kotlin
for (i in 1 .. 3) {
    if (i == 2) {
        continue;
    }
    println(i)
}
```

<br />
