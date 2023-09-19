# [Kotlin Note](../../README.md) - Chapter 7 Generics
| Chapter | Title |
| :-: | :- |
| 7.1 | [Generic Declaration](#71-generic-declaration) |
| 7.2 | [Generic Constraints](#72-generic-constraints) |

<br />

## 7.1 Generic Declaration
```kotlin
class Cage<T>(var item: T?) {
}
```
```kotlin
val cage: Cage<Int> = Cage<Int>(null)
```

<br />

## 7.2 Generic Constraints
```kotlin
class Cage<T: Animal>(var item: T?) {
}
```
```kotlin
val cage1: Cage<Animal> = Cage<Animal>(Animal())
val cage2: Cage<Fish> = Cage<Fish>(Fish())
```

<br />
