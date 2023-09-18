# [Kotlin Note](../../README.md) - Chapter 11 Lambda Expressions
| Chapter | Title |
| :-: | :- |
| 11.1 | [Lambda Expression Parameters](#111-lambda-expression-parameters) |
|  | [Empty Parameter](#empty-parameter) |
|  | [Single Parameter](#single-parameter) |
|  | [Multiple Parameters](#multiple-parameters) |
| 11.2 | [Lambda Expression Return Values](#112-lambda-expression-return-values) |
|  | [Single Return Value](#single-return-value) |
|  | [Double Return Values (Using Pair)](#double-return-values-using-pair) |
|  | [Triple Return Values (Using Triple)](#triple-return-values-using-triple) |
| 11.3 | [it Identifier](#113-it-identifier) |
| 11.4 | [Lambda Expressions as Arguments](#114-lambda-expressions-as-arguments) |
| 11.5 | [Trailing Lambda Expressions](#115-trailing-lambda-expressions) |
| 11.6 | [Inline Functions](#116-inline-functions) |
| 11.7 | [Function References](#117-function-references) |

<br />

## 11.1 Lambda Expression Parameters
### Empty Parameter
```kotlin
val lambdaExpression: () -> Unit = {
    println("Hello World".uppercase())
}

lambdaExpression()
```

### Single Parameter
```kotlin
val lambdaExpression: (String) -> Unit = { str: String ->
    println(str.uppercase())
}

lambdaExpression("Hello World")
```

### Multiple Parameters
```kotlin
val lambdaExpression: (String, String) -> Unit = { str1: String, str2: String ->
    val str: String = "$str1 $str2"
    println(str.uppercase())
}

lambdaExpression("Hello", "World")
```

<br />

## 11.2 Lambda Expression Return Values
### Single Return Value
```kotlin
val lambdaExpression: () -> String = {
    "Hello World".uppercase()
}

val value: String = lambdaExpression()
```

### Double Return Values (Using Pair)
```kotlin
val lambdaExpression: () -> Pair<String, Int> = {
    Pair("Hello World".uppercase(), -1)
}

val value: Pair<String, Int> = lambdaExpression()
```

### Triple Return Values (Using Triple)
```kotlin
val lambdaExpression: () -> Triple<String, Int, Int> = {
    Triple("Hello World".uppercase(), -1, -1)
}

val value: Triple<String, Int, Int> = lambdaExpression()
```

<br />

## 11.3 it Identifier
- it Identifier is available when there is exactly one parameter.

```kotlin
val lambdaExpression: (String) -> Unit = {
    println(it.uppercase())
}

lambdaExpression("Hello World")
```

<br />

## 11.4 Lambda Expressions as Arguments
```kotlin
fun printModifiedString(modifyFunction: (String) -> String) {
    println(modifyFunction("Hello World"))
}
```
```kotlin
val stringToUpper: (String) -> String = { it.uppercase() }
val stringToLower: (String) -> String = { it.lowercase() }

printModifiedString(stringToUpper)
printModifiedString(stringToLower)
```
```kotlin
printModifiedString({ it.uppercase() })
printModifiedString({ it.lowercase() })
```

<br />

## 11.5 Trailing Lambda Expressions
- You can omit the parentheses of a function if there is exactly one parameter for a lambda expression.

```kotlin
fun printModifiedString(modifyFunction: (String) -> String) {
    println(modifyFunction("Hello World"))
}
```
```kotlin
printModifiedString{ it.uppercase() }
printModifiedString{ it.lowercase() }
```

<br />

## 11.6 Inline Functions
- Inlines the function which accepts the lambda expression as arguments

```kotlin
inline fun doSomething(makeFunction: (String) -> String) {

}
```

<br />

## 11.7 Function References
- Converts a function to a lambda expression

```kotlin
fun printModifiedString(modifyFunction: (String) -> String) {
    println(modifyFunction("Hello World"))
}

fun stringToUpper(str: String): String {
    return str.uppercase()
}
```
```kotlin
printModifiedString(::stringToUpper)
```

<br />
