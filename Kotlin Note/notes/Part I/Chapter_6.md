# [Kotlin Note](../../README.md) - Chapter 6 Fucntions
| Chapter | Title |
| :-: | :- |
| 6.1 | [Function Parameters](#61-function-parameters) |
|  | [Empty Parameter](#empty-parameter) |
|  | [Single Pararmeter](#single-pararmeter) |
|  | [Multiple Parameters](#multiple-parameters) |
| 6.2 | [Function Return Values](#62-function-return-values) |
|  | [Single Return Value](#single-return-value) |
|  | [Double Return Values (Using Pair)](#double-return-values-using-pair) |
|  | [Triple Return Values (Using Triple)](#triple-return-values-using-triple) |
| 6.3 | [Default Arguments](#63-default-arguments) |
| 6.4 | [Single-Expression Functions](#64-single-expression-functions) |
| 6.5 | [Unit Functions](#65-unit-functions) |
| 6.6 | [Named Function Arguments](#66-named-function-arguments) |
| 6.7 | [Function Overloading](#67-function-overloading) |
| 6.8 | [TODO Function](#68-todo-function) |
| 6.9 | [Function Names in Backticks](#69-function-names-in-backticks) |
| 6.10 | [Function Visibility Modifiers](#610-function-visibility-modifiers) |

<br />

## 6.1 Function Parameters
### Empty Parameter
```kotlin
fun printWarningMessage() {
    println("Warning")
}
```
```kotlin
printWarningMessage()
```

### Single Pararmeter
```kotlin
fun printWarningMessage(message: String) {
    println("Warning: $message")
}
```
```kotlin
printWarningMessage("System Failed")
```

### Multiple Parameters
```kotlin
fun printWarningMessage(message: String, localDateTime: LocalDateTime) {
    println("Warning: $message [$localDateTime]")
}
```
```kotlin
printWarningMessage("System Failed", LocalDateTime.now())
```

<br />

## 6.2 Function Return Values
### Single Return Value
```kotlin
fun getWarningMessage(message: String): String {
    return "Warning: $message"
}
```
```kotlin
val warningMessage = getWarningMessage("System Failed")
```

### Double Return Values (Using Pair)
```kotlin
fun getWarningMessage(message: String): Pair<String, Int> {
    return Pair("Warning: $message", -1)
}
```
```kotlin
val warningMessage = getWarningMessage("System Failed")
```

### Triple Return Values (Using Triple)
```kotlin
fun getWarningMessage(message: String): Triple<String, Int, Int> {
    return Triple("Warning: $message", -1, -1)
}
```
```kotlin
val warningMessage = getWarningMessage("System Failed")
```

<br />

## 6.3 Default Arguments
```kotlin
fun printWarningMessage(message: String, localDateTime: LocalDateTime = LocalDateTime.now()) {
    println("Warning: $message [$localDateTime]")
}
```
```kotlin
printWarningMessage("System Failed")
printWarningMessage("System Failed", LocalDateTime.now())
```

<br />

## 6.4 Single-Expression Functions
- A function that can omit the return type, curly braces, and return keyword.

```kotlin
fun getWarningMessage(message: String) = "Warning: $message"
```
```kotlin
val warningMessage = getWarningMessage("System Failed")
```

<br />

## 6.5 Unit Functions
- All the functions that do not have return values are Unit Functions.
- Kotlin automatically returns a Unit type value to these functions.

```kotlin
fun printWarningMessage() {
    println("Warning")
}
```
```kotlin
fun printWarningMessage(): Unit {
    println("Warning")
}
```
- Both are the same.

<br />

## 6.6 Named Function Arguments
```kotlin
fun printWarningMessage(message: String, localDateTime: LocalDateTime) {
    println("Warning: $message [$localDateTime]")
}
```
```kotlin
printWarningMessage(
    message = "System Failed",
    localDateTime = LocalDateTime.now()
)
```

<br />

## 6.7 Function Overloading
```kotlin
fun printWarningMessage() {
    println("Warning")
}

fun printWarningMessage(message: String) {
    println("Warning: $message")
}

fun printWarningMessage(message: String, localDateTime: LocalDateTime) {
    println("Warning: $message [$localDateTime]")
}
```
```kotlin
printWarningMessage()
printWarningMessage("System Failed")
printWarningMessage("System Failed", LocalDateTime.now())
```

<br />

## 6.8 TODO Function
- TODO function throws a NotImplementedError exception.
```kotlin
fun printWarningMessage() {
    TODO()
}
```
```kotlin
fun printWarningMessage() {
    TODO("Not Implemented Yet")
}
```

<br />

## 6.9 Function Names in Backticks
```kotlin
fun `@@@ Print Warning Message @@@`() {
    println("Warning")
}
```
```kotlin
`@@@ Print Warning Message @@@`()
```

<br />

## 6.10 Function Visibility Modifiers
- The default visibility modifier of functions is public.

| Visibility Modifier | Description |
| :-- | :-- |
| public | The function will be accessible by code outside the file. |
| private | The function will be accessible only within the same file. |
| internal | The function will be accessible within the same module. |

```kotlin
fun printWarningMessage1() {
    println("Warning")
}

public fun printWarningMessage2() {
    println("Warning")
}

private fun printWarningMessage3() {
    println("Warning")
}

internal fun printWarningMessage4() {
    println("Warning")
}
```

<br />
