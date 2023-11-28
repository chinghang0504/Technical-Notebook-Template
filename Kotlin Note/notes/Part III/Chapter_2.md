# [Kotlin Note](../../README.md) - Chapter 2 Sets
| Chapter | Title |
| :-: | :- |
| 2.1 | [Set Types](#21-set-types) |
| 2.2 | [Creating a Set](#22-creating-a-set) |
|  | [Creating an Empty Mutable Set](#creating-an-empty-mutable-set) |
|  | [Creating a Non-Empty Mutable Set](#creating-a-non-empty-mutable-set) |
|  | [Creating an Empty Immutable Set](#creating-an-empty-immutable-set) |
|  | [Creating a Non-Empty Immutable Set](#creating-a-non-empty-immutable-set) |
| 2.3 | [Set Properties](#23-set-properties) |
|  | [Set: size](#set-size) |
| 2.4 | [Adding an Element (MutableSet)](#24-adding-an-element-mutableset) |
|  | [MutableSet: add()](#mutableset-add) |
|  | [MutableSet: addAll()](#mutableset-addall) |
| 2.5 | [Removing an Element (MutableSet)](#25-removing-an-element-mutableset) |
|  | [MutableSet: remove()](#mutableset-remove) |
| 2.6 | [Removing Elements (MutableSet)](#26-removing-elements-mutableset) |
|  | [MutableSet: clear()](#mutableset-clear) |
|  | [MutableSet: removeAll()](#mutableset-removeall) |
| 2.7 | [Checking Elements](#27-checking-elements) |
|  | [Set: contains() or in Keyword](#set-contains-or-in-keyword) |
|  | [Set: containsAll()](#set-containsall) |
| 2.8 | [Iterating over a Set](#28-iterating-over-a-set) |
|  | [Using forEach Function](#using-foreach-function) |
|  | [forEachIndexed Function](#using-foreachindexed-function) |
| 2.9 | [Converting between Collections](#29-converting-between-collections) |
|  | [Iterable: toMutableList()](#iterable-tomutablelist) |
|  | [Iterable: toList()](#iterable-tolist) |
|  | [Iterable: toMutableSet()](#iterable-tomutableset) |
|  | [Iterable: toSet()](#iterable-toset) |

<br />

## 2.1 Set Types
| Type | Description |
| :-- | :-- |
| MutableSet\<T> | Mutable Set |
| Set\<T> | Immutable Set |

<br />

## 2.2 Creating a Set
### Creating an Empty Mutable Set
```kotlin
val set: MutableSet<Int> = mutableSetOf()
```

### Creating a Non-Empty Mutable Set
```kotlin
val set: MutableSet<Int> = mutableSetOf(1, 2, 3)
```

### Creating an Empty Immutable Set
```kotlin
val set: Set<Int> = setOf()
```

### Creating a Non-Empty Immutable Set
```kotlin
val set: Set<Int> = setOf(1, 2, 3)
```

<br />

## 2.3 Set Properties
### [Set: size](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/size.html)
- Returns the size of the collection.
```kotlin
abstract val size: Int
```

<br />

```kotlin
val size: Int = set.size
```

<br />

## 2.4 Adding an Element (MutableSet)
### [MutableSet: add()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/add.html)
- Adds the specified element to the set.
```kotlin
abstract fun add(element: E): Boolean
```

<br />

```kotlin
set.add(100)
```

### [MutableSet: addAll()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/add-all.html)
- Adds all of the elements of the specified collection to this collection.
```kotlin
abstract fun addAll(elements: Collection<E>): Boolean
```

<br />

```kotlin
set.addAll(listOf(4, 5, 6))
```

<br />

## 2.5 Removing an Element (MutableSet)
### [MutableSet: remove()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/remove.html)
- Removes a single instance of the specified element from this collection, if it is present.
```kotlin
abstract fun remove(element: E): Boolean
```

<br />

```kotlin
set.remove(1)
```

<br />

## 2.6 Removing Elements (MutableSet)
### [MutableSet: clear()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/clear.html)
- Removes all elements from this collection.
```kotlin
abstract fun clear()
```

<br />

```kotlin
set.clear()
```

### [MutableSet: removeAll()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/remove-all.html)
- Removes all of this collection's elements that are also contained in the specified collection.
```kotlin
abstract fun removeAll(elements: Collection<E>): Boolean
```

<br />

```kotlin
set.removeAll(listOf(1, 2, 3))
```

<br />

## 2.7 Checking Elements
### [Set: contains() or in Keyword](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/contains.html)
- Checks if the specified element is contained in this collection.
```kotlin
abstract fun contains(element: @UnsafeVariance E): Boolean
```

<br />

```kotlin
val answer1: Boolean = 1 in set
val answer2: Boolean = set.contains(1)
```

### [Set: containsAll()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/contains-all.html)
- Checks if all elements in the specified collection are contained in this collection.
```kotlin
abstract fun containsAll(
    elements: Collection<@UnsafeVariance E>
): Boolean
```

<br />

```kotlin
val answer: Boolean = set.containsAll(listOf(1, 2, 3))
```

<br />

## 2.8 Iterating over a Set
### Using forEach Function
```kotlin
set.forEach {
    println(it)
}
```

### Using forEachIndexed Function
```kotlin
set.forEachIndexed { index, i ->
    println(i)
}
```

<br />

## 2.9 Converting between Collections
### [Iterable: toMutableList()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-mutable-list.html)
- Returns a new MutableList filled with all elements of this collection.
```kotlin
fun <T> Iterable<T>.toMutableList(): MutableList<T>
```

<br />

```kotlin
val mutableSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
val mutableList: MutableList<Int> = mutableSet.toMutableList()
```

### [Iterable: toList()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-list.html)
- Returns a List containing all elements.
```kotlin
fun <T> Iterable<T>.toList(): List<T>
```

<br />

```kotlin
val mutableSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
val immMutableList: List<Int> = mutableSet.toList()
```

### [Iterable: toMutableSet()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-mutable-set.html)
- Returns a new MutableSet containing all distinct elements from the given collection.
```kotlin
fun <T> Iterable<T>.toMutableSet(): MutableSet<T>
```

<br />

```kotlin
val immutableSet: Set<Int> = setOf(1, 2, 3)
val mutableSet: MutableSet<Int> = immutableSet.toMutableSet()
```

### [Iterable: toSet()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-set.html)
- Returns a Set of all elements.
```kotlin
fun <T> Iterable<T>.toSet(): Set<T>
```

<br />

```kotlin
val mutableSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
val immutableSet: Set<Int> = mutableSet.toSet()
```

<br />
