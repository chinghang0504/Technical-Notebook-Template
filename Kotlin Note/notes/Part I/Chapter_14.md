# [Kotlin Note](../../README.md) - Chapter 14 Scope Functions
| Chapter | Title |
| :-: | :- |
| 14.1 | [Scope Function Summary](#141-scope-function-summary) |
| 14.2 | [apply Scope Function](#142-apply-scope-function) |
| 14.3 | [run Scope Function](#143-run-scope-function) |
| 14.4 | [with Scope Function](#144-with-scope-function) |
| 14.5 | [also Scope Function](#145-also-scope-function) |
| 14.6 | [let Scope Function](#146-let-scope-function) |
| 14.7 | [takeIf Scope Function](#147-takeif-scope-function) |
| 14.8 | [takeUnless Scope Function](#148-takeunless-scope-function) |

<br />

## 14.1 Scope Function Summary
| Scope Function | Receiver | Return Value | Argument |
| :-- | :-- | :-- | :-- |
| apply | this | receiver | N |
| run | this | result | N |
| with | this | result | Y |
| also | it | receiver | N |
| let | it | result | N |
| takeIf | it | receiver/null | N |
| takeUnless | it | null/receiver | N |

<br />

## 14.2 apply Scope Function
- Passes **this** as a receiver
- Returns the receiver

```kotlin
val list: MutableList<Int> = mutableListOf(1, 2, 3).apply {
    add(4)
    add(5)
    add(6)
}
```

<br />

## 14.3 run Scope Function
- Passes **this** as a receiver
- Returns the result

```kotlin
val num: Int = mutableListOf(1, 2, 3).run {
    add(4)
    add(5)
    add(6)
    last()
}
```

<br />

## 14.4 with Scope Function
- Passes **this** as an argument
- Returns the result

```kotlin
val list: MutableList<Int> = mutableListOf(1, 2, 3)
val num: Int = with(list) {
    add(4)
    add(5)
    add(6)
    last()
}
```

<br />

## 14.5 also Scope Function
- Passes **it** as a receiver
- Returns the receiver

```kotlin
val list: MutableList<Int> = mutableListOf(1, 2, 3).also {
    it.add(4)
    it.add(5)
    it.add(6)
}
```

<br />

## 14.6 let Scope Function
- Passes **it** as a receiver
- Returns the result

```kotlin
val num: Int = mutableListOf(1, 2, 3).let {
    it.add(4)
    it.add(5)
    it.add(6)
    it.last()
}
```

<br />

## 14.7 takeIf Scope Function
- Passes **it** as a receiver
- Returns the receiver if the last expression is true, otherwise returns null

```kotlin
val list: MutableList<Int>? = mutableListOf(1, 2, 3).takeIf {
    it.add(4)
    it.add(5)
    it.add(6)
    it.size == 6
}
```

<br />

## 14.8 takeUnless Scope Function
- Passes **it** as a receiver
- Returns a receiver if the last expression is false, otherwise returns null

```kotlin
val list: MutableList<Int>? = mutableListOf(1, 2, 3).takeUnless {
    it.add(4)
    it.add(5)
    it.add(6)
    it.size == 6
}
```

<br />
