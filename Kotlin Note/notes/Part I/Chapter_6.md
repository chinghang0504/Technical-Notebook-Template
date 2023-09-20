# [Kotlin Note](../../README.md) - Chapter 6 Loops
| Chapter | Title |
| :-: | :- |
| 6.1 | [Loops](#61-loops) |
|  | [for Loop](#for-loop) |
|  | [while Loop](#while-loop) |
|  | [do-while Loop](#do-while-loop) |
| 6.2 | [Jump Statements](#62-jump-statements) |
|  | [break Statement](#break-statement) |
|  | [break Statment with Label](#break-statment-with-label) |
|  | [continue Statement](#continue-statement) |

<br />

## 6.1 Loops
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

## 6.2 Jump Statements
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
