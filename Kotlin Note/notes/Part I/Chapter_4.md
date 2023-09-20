# [Kotlin Note](../../README.md) - Chapter 4 Conditions
| Chapter | Title |
| :-: | :- |
| 4.1 | [Comparsion Operators](#41-comparsion-operators) |
| 4.2 | [Equality Operators](#42-equality-operators) |
| 4.3 | [Referential Equality Operators](#43-referential-equality-operators) |
| 4.4 | [Logical Operators](#44-logical-operators) |
| 4.5 | [Operator Precedence](#45-operator-precedence) |
| 4.6 | [if Statments](#46-if-statments) |
|  | [if-else Statements](#if-else-statements) |
|  | [if-else if Statements](#if-else-if-statements) |
|  | [Nested if Statements](#nested-if-statements) |
| 4.7 | [if Expressions](#47-if-expressions) |
|  | [if-else Expressions](#if-else-expressions) |
|  | [if-else if-else Expressions](#if-else-if-else-expressions) |
| 4.8 | [when Statements](#48-when-statements) |
|  | [Multiple Cases for the Same Statements](#multiple-cases-for-the-same-statements) |
| 4.9 | [when Expressions](#49-when-expressions) |
|  | [when Expressions without Arguments](#when-expressions-without-arguments) |

<br />

## 4.1 Comparsion Operators
| Operator | Target | Description |
| :--: | :-- | :-- |
| < | Value | Less than |
| <= | Value | Less than or equal to |
| > | Value | Greater than |
| >= | Value | Greater than or equal to |

<br />

## 4.2 Equality Operators
| Operator | Target | Description |
| :--: | :-- | :-- |
| == | Value | Equal to |
| != | Value | Not equal to |

<br />

## 4.3 Referential Equality Operators
| Operator | Target | Description |
| :--: | :-- | :-- |
| === | Reference | Equal to |
| !== | Reference | Not equal to |

<br />

## 4.4 Logical Operators
| Operator | Description |
| :--: | :-- |
| && | Logical and |
| \|\| | Logical or |
| ! | Logical not |

<br />

## 4.5 [Operator Precedence](https://kotlinlang.org/docs/reference/grammar.html#expressions)
| Precedence | Title | Symbols |
| :--: | :-- | :-- |
| Highest | Prefix | ! |
|  | Comparison | <, >, <=, >= |
|  | Equality | ==, !=, ===, !== |
|  | Conjunction | && |
| Lowest | Disjunction | \|\| |

<br />

## 4.6 if Statments
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

## 4.7 if Expressions
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

## 4.8 when Statements
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

## 4.9 when Expressions
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
