# [Kotlin Note](../../README.md) - Chapter 7 Fucntions
| Chapter | Title |
| :-: | :- |
| 7.1 | [Function Parameters](#71-function-parameters) |
|  | [Empty Parameter](#empty-parameter) |
|  | [Single Pararmeter](#single-pararmeter) |
|  | [Multiple Parameters](#multiple-parameters) |
| 7.2 | [Function Return Values](#72-function-return-values) |
|  | [Single Return Value](#single-return-value) |
|  | [Double Return Values (Using Pair)](#double-return-values-using-pair) |
|  | [Triple Return Values (Using Triple)](#triple-return-values-using-triple) |
| 7.3 | [Default Arguments](#73-default-arguments) |
| 7.4 | [Single-Expression Functions](#74-single-expression-functions) |
| 7.5 | [Unit Functions](#75-unit-functions) |
| 7.6 | [Named Function Arguments](#76-named-function-arguments) |
| 7.7 | [Function Overloading](#77-function-overloading) |
| 7.8 | [Function: TODO](#78-function-todo) |
| 7.9 | [Function Names in Backticks](#79-function-names-in-backticks) |
| 7.10 | [Function Visibility Modifiers](#710-function-visibility-modifiers) |
|  | [Default Visibility Modifier](#default-visibility-modifier) |
|  | [Public Visibility Modifier](#public-visibility-modifier) |
|  | [Private Visibility Modifier](#private-visibility-modifier) |
|  | [Internal Visibility Modifier](#internal-visibility-modifier) |

<br />

## 7.1 Function Parameters
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

## 7.2 Function Return Values
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

## 7.3 Default Arguments
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

## 7.4 Single-Expression Functions
```kotlin
fun getWarningMessage(message: String): String = "Warning: $message"
```
```kotlin
val warningMessage = getWarningMessage("System Failed")
```

- A function that can omit the return type, curly braces, and return keyword.
```kotlin
fun getWarningMessage(message: String) = "Warning: $message"
```

<br />

## 7.5 Unit Functions
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

## 7.6 Named Function Arguments
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

## 7.7 Function Overloading
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

## 7.8 [Function: TODO](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-t-o-d-o.html)
- Always throws NotImplementedError stating that operation is not implemented.
```kotlin
fun TODO(): Nothing
fun TODO(reason: String): Nothing
```

<br />

## 7.9 Function Names in Backticks
```kotlin
fun `@@@ Print Warning Message @@@`() {
    println("Warning")
}
```
```kotlin
`@@@ Print Warning Message @@@`()
```

<br />

## 7.10 Function Visibility Modifiers
- The default visibility modifier of functions is public.

| Visibility Modifier | Description |
| :-- | :-- |
| public | The function will be accessible by code outside the file. |
| private | The function will be accessible only within the same file. |
| internal | The function will be accessible within the same module. |

### Default Visibility Modifier
```kotlin
fun printWarningMessage1() {
    println("Warning")
}
```

### Public Visibility Modifier
```kotlin
public fun printWarningMessage2() {
    println("Warning")
}
```

### Private Visibility Modifier
```kotlin
private fun printWarningMessage3() {
    println("Warning")
}
```

### Internal Visibility Modifier
```kotlin
internal fun printWarningMessage4() {
    println("Warning")
}
```

<br />
