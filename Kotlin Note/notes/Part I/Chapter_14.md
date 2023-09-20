# [Kotlin Note](../../README.md) - Chapter 14 Scope Functions
| Chapter | Title |
| :-: | :- |
| 14.1 | [Scope Function Summary](#141-scope-function-summary) |
|  | [Short Guide for Choosing Scope Functions](#short-guide-for-choosing-scope-functions) |
| 14.2 | [let Scope Function](#142-let-scope-function) |
| 14.3 | [with Scope Function](#143-with-scope-function) |
| 14.4 | [run Scope Function](#144-run-scope-function) |
| 14.5 | [apply Scope Function](#145-apply-scope-function) |
| 14.6 | [also Scope Function](#146-also-scope-function) |
| 14.7 | [takeIf Scope Function](#147-takeif-scope-function) |
| 14.8 | [takeUnless Scope Function](#148-takeunless-scope-function) |

<br />

## 14.1 [Scope Function Summary](https://kotlinlang.org/docs/scope-functions.html#function-selection)
| Scope Function | Context Object | Return Value |
| :-- | :-- | :-- |
| let | Lambda argument (it) | Lambda result |
| with | Lambda receiver (this) | Lambda result |
| run | Lambda receiver (this) | Lambda result |
| apply | Lambda receiver (this) | Context object |
| also | Lambda argument (it) | Context object |
| takeIf | Lambda argument (it) | Context object / null |
| takeUnless | Lambda argument (it) | null / Context object |

### Short Guide for Choosing Scope Functions
1. Executing a lambda on non-nullable objects: let
2. Introducing an expression as a variable in local scope: let
3. Object configuration: apply
4. Object configuration and computing the result: run
5. Running statements where an expression is required: non-extension run
6. Additional effects: also
7. Grouping function calls on an object: with

<br />

## 14.2 [let Scope Function](https://kotlinlang.org/docs/scope-functions.html#let)
- Context Object: Lambda argument (it)
- Return Value: Lambda result

```kotlin
val num: Int = mutableListOf(1, 2, 3).let {
    it.add(4)
    it.add(5)
    it.add(6)
    it.last()
}
```

<br />

## 14.3 [with Scope Function](https://kotlinlang.org/docs/scope-functions.html#with)
- Context Object: Lambda receiver (this)
- Return Value: Lambda result

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

## 14.4 [run Scope Function](https://kotlinlang.org/docs/scope-functions.html#run)
- Context Object: Lambda receiver (this)
- Return Value: Lambda result

```kotlin
val num: Int = mutableListOf(1, 2, 3).run {
    add(4)
    add(5)
    add(6)
    last()
}
```

<br />

## 14.5 [apply Scope Function](https://kotlinlang.org/docs/scope-functions.html#apply)
- Context Object: Lambda receiver (this)
- Return Value: Context object

```kotlin
val list: MutableList<Int> = mutableListOf(1, 2, 3).apply {
    add(4)
    add(5)
    add(6)
}
```

<br />

## 14.6 [also Scope Function](https://kotlinlang.org/docs/scope-functions.html#also)
- Context Object: Lambda argument (it)
- Return Value: Context object

```kotlin
val list: MutableList<Int> = mutableListOf(1, 2, 3).also {
    it.add(4)
    it.add(5)
    it.add(6)
}
```

<br />

## 14.7 [takeIf Scope Function](https://kotlinlang.org/docs/scope-functions.html#takeif-and-takeunless)
- Context Object: Lambda argument (it)
- Return Value: 
    - Context object if the condition is true
    - null if the condition is false

```kotlin
val list: MutableList<Int>? = mutableListOf(1, 2, 3).takeIf {
    it.add(4)
    it.add(5)
    it.add(6)
    it.size == 6
}
```

<br />

## 14.8 [takeUnless Scope Function](https://kotlinlang.org/docs/scope-functions.html#takeif-and-takeunless)
- Context Object: Lambda argument (it)
- Return Value: 
    - null if the condition is true
    - Context object if the condition is false

```kotlin
val list: MutableList<Int>? = mutableListOf(1, 2, 3).takeUnless {
    it.add(4)
    it.add(5)
    it.add(6)
    it.size == 6
}
```

<br />
