# [Kotlin Note](../../README.md) - Chapter 8 Extensions
| Chapter | Title |
| :-: | :- |
| 8.1 | [Extension Method Declaration](#81-extension-method-declaration) |

<br />

## 8.1 Extension Method Declaration
```kotlin
operator fun String.times(num: Int): String {
    return this.repeat(num)
}
```
```kotlin
println("Hello" * 3)
```

<br />
