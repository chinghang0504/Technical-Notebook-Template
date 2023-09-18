# [Kotlin Note](../../README.md) - Chapter 4 Conditions
| Chapter | Title |
| :-: | :- |
| 4.1 | [Comparsion Operators](#41-comparsion-operators) |
| 4.2 | [Logical Operators](#42-logical-operators) |
| 4.3 | [Operator Precedence](#43-operator-precedence) |
| 4.4 | [if Statments](#44-if-statments) |
|  | [if-else Statements](#if-else-statements) |
|  | [if-else if Statements](#if-else-if-statements) |
|  | [Nested if Statements](#nested-if-statements) |
| 4.5 | [if Expressions](#45-if-expressions) |
|  | [if-else Expressions](#if-else-expressions) |
|  | [if-else if-else Expressions](#if-else-if-else-expressions) |
| 4.6 | [when Statements](#46-when-statements) |
|  | [Multiple Cases for the Same Statements](#multiple-cases-for-the-same-statements) |
| 4.7 | [when Expressions](#47-when-expressions) |
|  | [when Expressions without Arguments](#when-expressions-without-arguments) |

<br />

## 4.1 Comparsion Operators
| Operator | Description |
| :--: | :-- |
| < | (Value) Less than |
| <= | (Value) Less than or equal to |
| > | (Value) Greater than |
| >= | (Value) Greater than or equal to |
| == | (Value) Equal to |
| != | (Value) Not equal to |
| === | (Reference) Equal to |
| !== | (Reference) Not equal to |
<br />

## 4.2 Logical Operators
| Operator | Description |
| :--: | :-- |
| && | Logical and |
| \|\| | Logical or |
| ! | Logical not |

<br />

## 4.3 Operator Precedence
| Precedence | Title | Symbols |
| :--: | :-- | :-- |
| Highest | Prefix | ! |
|  | Comparison | <, >, <=, >= |
|  | Equality | ==, !=, ===, !== |
|  | Conjunction | && |
| Lowest | Disjunction | \|\| |

<br />

## 4.4 if Statments
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

## 4.5 if Expressions
### if-else Expressions
```kotlin
val value = if (num == 100) {
    1000
} else {
    0
}
```

### if-else if-else Expressions
```kotlin
val value = if (num == 100) {
    1000
} else if (num == 200){
    2000
} else {
    0
}
```

<br />

## 4.6 when Statements
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
        println("Is 100")
    }
    200 -> {
        println("Is 200")
        println("Is 200")
    }
    else -> {
        println("Is not 100 or 200")
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

## 4.7 when Expressions
```kotlin
val value = when (num) {
    100 -> 1000
    200 -> 2000
    else -> 0
}
```
```kotlin
val value = when (num) {
    100 -> {
        println("Is 100")
        1000
    }
    200 -> {
        println("Is 200")
        2000
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
    num >= 100 && num < 200 -> 1000
    num >= 200 && num < 299 -> 2000
    else -> 0
}
```

<br />
