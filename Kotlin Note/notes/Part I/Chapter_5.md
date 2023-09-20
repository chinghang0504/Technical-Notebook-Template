# [Kotlin Note](../../README.md) - Chapter 5 Conditions
| Chapter | Title |
| :-: | :- |
| 5.1 | [Comparsion Operators](#51-comparsion-operators) |
| 5.2 | [Equality Operators](#52-equality-operators) |
| 5.3 | [Referential Equality Operators](#53-referential-equality-operators) |
| 5.4 | [Logical Operators](#54-logical-operators) |
| 5.5 | [Operator Precedence](#55-operator-precedence) |
| 5.6 | [if Statments](#56-if-statments) |
|  | [if-else Statements](#if-else-statements) |
|  | [if-else if Statements](#if-else-if-statements) |
|  | [Nested if Statements](#nested-if-statements) |
| 5.7 | [if Statements with Ranges and Progressions](#57-if-statements-with-ranges-and-progressions) |
|  | [if Statements with Ranges and in Keyword](#if-statements-with-ranges-and-in-keyword) |
|  | [if Statements with Ranges and !in Keyword](#if-statements-with-ranges-and-in-keyword-1) |
|  | [if Statements with Progressions and in Keyword](#if-statements-with-progressions-and-in-keyword) |
|  | [if Statements with Progressions and !in Keyword](#if-statements-with-progressions-and-in-keyword-1) |
| 5.8 | [if Expressions](#58-if-expressions) |
|  | [if-else Expressions](#if-else-expressions) |
|  | [if-else if-else Expressions](#if-else-if-else-expressions) |
| 5.9 | [when Statements](#59-when-statements) |
|  | [Multiple Cases for the Same Statements](#multiple-cases-for-the-same-statements) |
| 5.10 | [when Statements with Ranges and Progressions](#510-when-statements-with-ranges-and-progressions) |
|  | [when Statements with Ranges and in Keyword](#when-statements-with-ranges-and-in-keyword) |
|  | [when Statements with Ranges and !in Keyword](#when-statements-with-ranges-and-in-keyword-1) |
|  | [when Statements with Progressions and in Keyword](#when-statements-with-progressions-and-in-keyword) |
|  | [when Statements with Progressions and !in Keyword](#when-statements-with-progressions-and-in-keyword-1) |
| 5.11 | [when Expressions](#511-when-expressions) |
|  | [when Expressions without Arguments](#when-expressions-without-arguments) |

<br />

## 5.1 Comparsion Operators
| Operator | Target | Description |
| :--: | :-- | :-- |
| < | Value | Less than |
| <= | Value | Less than or equal to |
| > | Value | Greater than |
| >= | Value | Greater than or equal to |

<br />

## 5.2 Equality Operators
| Operator | Target | Description |
| :--: | :-- | :-- |
| == | Value | Equal to |
| != | Value | Not equal to |

<br />

## 5.3 Referential Equality Operators
| Operator | Target | Description |
| :--: | :-- | :-- |
| === | Reference | Equal to |
| !== | Reference | Not equal to |

<br />

## 5.4 Logical Operators
| Operator | Description |
| :--: | :-- |
| && | Logical and |
| \|\| | Logical or |
| ! | Logical not |

<br />

## 5.5 [Operator Precedence](https://kotlinlang.org/docs/reference/grammar.html#expressions)
| Precedence | Title | Symbols |
| :--: | :-- | :-- |
| Highest | Prefix | ! |
|  | Comparison | <, >, <=, >= |
|  | Equality | ==, !=, ===, !== |
|  | Conjunction | && |
| Lowest | Disjunction | \|\| |

<br />

## 5.6 if Statments
```kotlin
if (num == 100) {
    println("Is 100")
}
```

- Kotlin allows if statements to omit braces, but only the first expression is evaluated.
```kotlin
if (num == 100)
    println("Is 100")
```

### if-else Statements
```kotlin
if (num == 100) {
    println("Is 100")
} else {
    println("Is not 100")
}
```

### if-else if Statements
```kotlin
if (num == 100) {
    println("Is 100")
} else if (num == 200) {
    println("Is 200")
} else {
    println("Is not 100 or 200")
}
```

### Nested if Statements
```kotlin
if (num >= 100) {
    if (num == 100) {
        println("Is 100")
    } else {
        println("Greater than 100")
    }
} else {
    println("Less than 100")
}
```

<br />

## 5.7 if Statements with Ranges and Progressions
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

<br />

## 5.8 if Expressions
### if-else Expressions
```kotlin
val value = if (num == 100) {
    100
} else {
    0
}
```
```kotlin
val value = if (num == 100) 100 else 0
```

### if-else if-else Expressions
```kotlin
val value = if (num == 100) {
    100
} else if (num == 200){
    200
} else {
    0
}
```

<br />

## 5.9 when Statements
```kotlin
when (num) {
    100 -> println("Is 100")
    200 -> println("Is 200")
    else -> println("Is not 100 or 200")
}
```
```kotlin
when (num) {
    100 -> {
        println("Is 100")
    }
    200 -> {
        println("Is 200")
    }
    else -> {
        println("Is not 100 or 200")
    }
}
```

### Multiple Cases for the Same Statements
```kotlin
when (num) {
    100, 200 -> println("Is 100 or 200")
    else -> println("Is not 100 or 200")
}
```

<br />

## 5.10 when Statements with Ranges and Progressions
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

## 5.11 when Expressions
```kotlin
val value = when (num) {
    100 -> 100
    200 -> 200
    else -> 0
}
```
```kotlin
val value = when (num) {
    100 -> {
        println("Is 100")
        100
    }
    200 -> {
        println("Is 200")
        200
    }
    else -> {
        println("Is not 100 or 200")
        0
    }
}
```

### when Expressions without Arguments
```kotlin
val value = when {
    num >= 100 && num < 200 -> 100
    num >= 200 && num < 299 -> 200
    else -> 0
}
```

<br />
