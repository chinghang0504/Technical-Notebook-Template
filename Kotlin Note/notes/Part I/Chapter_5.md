# [Kotlin Note](../../README.md) - Chapter 5 Ranges, Progressions, Conditions, and Loops
| Chapter | Title |
| :-: | :- |
| 5.1 | [Ranges](#51-ranges) |
|  | [.. Operator or rangeTo Function](#operator-or-rangeto-function) |
|  | [..< Operator or rangeUntil Function](#operator-or-rangeuntil-function) |
|  | [until Function](#until-function) |
|  | [IntRange: toList](#intrange-tolist) |
| 5.2 | [Progressions](#52-progressions) |
|  | [downTo Function](#downto-function) |
|  | [step Function](#step-function) |
|  | [IntProgression: toList](#intprogression-tolist) |
| 5.3 | [Conditions with Ranges](#53-conditions-with-ranges) |
|  | [if Statements with Ranges and in Keyword](#if-statements-with-ranges-and-in-keyword) |
|  | [if Statements with Ranges and !in Keyword](#if-statements-with-ranges-and-in-keyword-1) |
|  | [when Statements with Ranges and in Keyword](#when-statements-with-ranges-and-in-keyword) |
|  | [when Statements with Ranges and !in Keyword](#when-statements-with-ranges-and-in-keyword-1) |
| 5.4 | [Conditions with Progressions](#54-conditions-with-progressions) |
|  | [if Statements with Progressions and in Keyword](#if-statements-with-progressions-and-in-keyword) |
|  | [if Statements with Progressions and !in Keyword](#if-statements-with-progressions-and-in-keyword-1) |
|  | [when Statements with Progressions and in Keyword](#when-statements-with-progressions-and-in-keyword) |
|  | [when Statements with Progressions and !in Keyword](#when-statements-with-progressions-and-in-keyword-1) |
| 5.5 | [Loops](#55-loops) |
|  | [for Loop](#for-loop) |
|  | [while Loop](#while-loop) |
|  | [do-while Loop](#do-while-loop) |
| 5.6 | [Jump Statements](#56-jump-statements) |
|  | [break Statement](#break-statement) |
|  | [break Statment with Label](#break-statment-with-label) |
|  | [continue Statement](#continue-statement) |

<br />

## 5.1 Ranges
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

## 5.2 Progressions
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

## 5.3 Conditions with Ranges
### if Statements with Ranges and in Keyword
```kotlin
if (num in 1 .. 3) {
    println("In the range")
} else {
    println("Not in the range")
}
```

### if Statements with Ranges and !in Keyword
```kotlin
if (num !in 1 .. 3) {
    println("Not in the range")
} else {
    println("In the range")
}
```

### when Statements with Ranges and in Keyword
```kotlin
when (num) {
    in 1 .. 3 -> println("In the range")
    else -> println("Not in the range")
}
```

### when Statements with Ranges and !in Keyword
```kotlin
when (num) {
    !in 1 .. 3 -> println("Not in the range")
    else -> println("In the range")
}
```

<br />

## 5.4 Conditions with Progressions
### if Statements with Progressions and in Keyword
```kotlin
if (num in 3 downTo 1) {
    println("In the range")
} else {
    println("Not in the range")
}
```

### if Statements with Progressions and !in Keyword
```kotlin
if (num !in 3 downTo 1) {
    println("Not in the range")
} else {
    println("In the range")
}
```

### when Statements with Progressions and in Keyword
```kotlin
when (num) {
    in 3 downTo 1 -> println("In the range")
    else -> println("Not in the range")
}
```

### when Statements with Progressions and !in Keyword
```kotlin
when (num) {
    !in 3 downTo 1 -> println("Not in the range")
    else -> println("In the range")
}
```

<br />

## 5.5 Loops
### for Loop
```kotlin
for (i in 1 .. 3) {
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

## 5.6 Jump Statements
### break Statement
```kotlin
for (i in 1 .. 3) {
    if (i == 2) {
        break
    }
    println(i)
}
```

### break Statment with Label
```kotlin
loop@ for (i in 1 .. 3) {
    for (j in 1 .. 3) {
        if (i == 2 && j == 2) {
            break@loop
        }
        println("i: $i, j: $j")
    }
}
```

### continue Statement
```kotlin
for (i in 1 .. 3) {
    if (i == 2) {
        continue
    }
    println(i)
}
```

<br />
