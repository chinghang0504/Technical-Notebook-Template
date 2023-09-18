# [Kotlin Note](../../README.md) - Chapter 13 Scope Functions
| Chapter | Title |
| :-: | :- |
| 13.1 | [Scope Function Summary](#131-scope-function-summary) |
| 13.2 | [apply Scope Function](#132-apply-scope-function) |
| 13.3 | [run Scope Function](#133-run-scope-function) |
| 13.4 | [with Scope Function](#134-with-scope-function) |
| 13.5 | [also Scope Function](#135-also-scope-function) |
| 13.6 | [let Scope Function](#136-let-scope-function) |
| 13.7 | [takeIf Scope Function](#137-takeif-scope-function) |
| 13.8 | [takeUnless Scope Function](#138-takeunless-scope-function) |

<br />

## 13.1 Scope Function Summary
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

## 13.2 apply Scope Function
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

## 13.3 run Scope Function
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

## 13.4 with Scope Function
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

## 13.5 also Scope Function
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

## 13.6 let Scope Function
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

## 13.7 takeIf Scope Function
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

## 13.8 takeUnless Scope Function
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
