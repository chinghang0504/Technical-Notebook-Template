# [Kotlin Note](../../README.md) - Chapter 1 Lists
| Chapter | Title |
| :-: | :- |
| 1.1 | [List Types](#11-list-types) |
| 1.2 | [Creating a List](#12-creating-a-list) |
|  | [Creating an Empty Mutable List](#creating-an-empty-mutable-list) |
|  | [Creating a Non-Empty Mutable List](#creating-a-non-empty-mutable-list) |
|  | [Creating an Empty Immutable List](#creating-an-empty-immutable-list) |
|  | [Creating a Non-Empty Immutable List](#creating-a-non-empty-immutable-list) |
| 1.3 | [List Properties](#13-list-properties) |
|  | [List: size](#list-size) |
|  | [List: lastIndex](#list-lastindex) |
| 1.4 | [Getting an Element](#14-getting-an-element) |
|  | [List: get() or [] Operator](#list-get-or--operator) |
|  | [List: getOrElse()](#list-getorelse) |
|  | [List: getOrNull()](#list-getornull) |
|  | [List: first()](#list-first) |
|  | [List: firstOrNull()](#list-firstornull) |
|  | [List: last()](#list-last) |
|  | [List: lastOrNull()](#list-lastornull) |
| 1.5 | [Setting an Element (MutableList)](#15-setting-an-element-mutablelist) |
|  | [MutableList: set() or [] Operator](#mutablelist-set-or--operator) |
| 1.6 | [Adding an Element (MutableList)](#16-adding-an-element-mutablelist) |
|  | [MutableList: add()](#mutablelist-add) |
|  | [MutableList: addAll()](#mutablelist-addall) |
| 1.7 | [Removing an Element (MutableList)](#17-removing-an-element-mutablelist) |
|  | [MutableList: remove()](#mutablelist-remove) |
|  | [MutableList: removeAt()](#mutablelist-removeat) |
| 1.8 | [Removing Elements (MutableList)](#18-removing-elements-mutablelist) |
|  | [MutableList: clear()](#mutablelist-clear) |
|  | [MutableList: removeAll()](#mutablelist-removeall) |
| 1.9 | [Checking Elements](#19-checking-elements) |
|  | [List: contains() or in Keyword](#list-contains-or-in-keyword) |
|  | [List: containsAll()](#list-containsall) |
| 1.10 | [Iterating over a List](#110-iterating-over-a-list) |
|  | [Using for Loop and in Keyword](#using-for-loop-and-in-keyword) |
|  | [Using for Loop and size](#using-for-loop-and-size) |
|  | [Using forEach Function](#using-foreach-function) |
|  | [Using forEachIndexed Function](#using-foreachindexed-function) |
| 1.11 | [Converting between Collections](#111-converting-between-collections) |
|  | [Iterable: toMutableList()](#iterable-tomutablelist) |
|  | [Iterable: toList()](#iterable-tolist) |
|  | [Iterable: toMutableSet()](#iterable-tomutableset) |
|  | [Iterable: toSet()](#iterable-toset) |

<br />

## 1.1 List Types
| Type | Description |
| :-- | :-- |
| MutableList\<T> | Mutable list |
| List\<T> | Immutable list |

<br />

## 1.2 Creating a List
### Creating an Empty Mutable List
```kotlin
val list: MutableList<Int> = mutableListOf()
```

### Creating a Non-Empty Mutable List
```kotlin
val list: MutableList<Int> = mutableListOf(1, 2, 3)
```

### Creating an Empty Immutable List
```kotlin
val list: List<Int> = listOf()
```

### Creating a Non-Empty Immutable List
```kotlin
val list: List<Int> = listOf(1, 2, 3)
```

<br />

## 1.3 List Properties
### [List: size](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/size.html)
- Returns the size of the collection.
```kotlin
abstract val size: Int
```

<br />

```kotlin
val size: Int = list.size
```

### [List: lastIndex](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/last-index.html)
- Returns the index of the last item in the list or -1 if the list is empty.
```kotlin
val <T> List<T>.lastIndex: Int
```

<br />

```kotlin
val lastIndex: Int = list.lastIndex
```

<br />

## 1.4 Getting an Element
### [List: get() or [] Operator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/get.html)
- Returns the element at the specified index in the list.
```kotlin
abstract operator fun get(index: Int): E
```

<br />

```kotlin
val num1: Int = list[0]
val num2: Int = list.get(0)
```

### [List: getOrElse()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/get-or-else.html)
- Returns an element at the given index or the result of calling the defaultValue function if the index is out of bounds of this list.
```kotlin
inline fun <T> List<T>.getOrElse(
    index: Int,
    defaultValue: (Int) -> T
): T
```

<br />

```kotlin
val num: Int = list.getOrElse(100, { -1 })
```

### [List: getOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/get-or-null.html)
- Returns an element at the given index or null if the index is out of bounds of this list.
```kotlin
fun <T> List<T>.getOrNull(index: Int): T?
```

<br />

```kotlin
val num: Int? = list.getOrNull(100)
```

### [List: first()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/first.html)
- Returns the first element.
```kotlin
fun <T> List<T>.first(): T
```

<br />

```kotlin
val num: Int = list.first()
```

### [List: firstOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/first-or-null.html)
- Returns the first element, or null if the list is empty.
```kotlin
fun <T> List<T>.firstOrNull(): T?
```

<br />

```kotlin
val num: Int? = list.firstOrNull()
```

<br />

### [List: last()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/last.html)
- Returns the last element.
```kotlin
fun <T> List<T>.last(): T
```

<br />

```kotlin
val num: Int = list.last()
```

<br />

### [List: lastOrNull()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/last-or-null.html)
- Returns the last element, or null if the list is empty.
```kotlin
fun <T> List<T>.lastOrNull(): T?
```

<br />

```kotlin
val num: Int? = list.lastOrNull()
```

<br />

## 1.5 Setting an Element (MutableList)
### [MutableList: set() or [] Operator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/set.html)
- Replaces the element at the specified position in this list with the specified element.
```kotlin
abstract operator fun set(index: Int, element: E): E
```

<br />

```kotlin
list[0] = 100
list.set(0, 100)
```

<br />

## 1.6 Adding an Element (MutableList)
### [MutableList: add()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/add.html)
- Adds the specified element to the end of this list.
```kotlin
abstract fun add(element: E): Boolean
```
- Inserts an element into the list at the specified index.
```kotlin
abstract fun add(index: Int, element: E)
```

<br />

```kotlin
list.add(100)
list.add(0, 100)
```

### [MutableList: addAll()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/add-all.html)
- Adds all of the elements of the specified collection to the end of this list.
```kotlin
abstract fun addAll(elements: Collection<E>): Boolean
```

- Inserts all of the elements of the specified collection elements into this list at the specified index.
```kotlin
abstract fun addAll(
    index: Int,
    elements: Collection<E>
): Boolean
```

<br />

```kotlin
list.addAll(listOf(4, 5, 6))
```

<br />

## 1.7 Removing an Element (MutableList)
### [MutableList: remove()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/remove.html)
- Removes a single instance of the specified element from this collection, if it is present.
```kotlin
abstract fun remove(element: E): Boolean
```

<br />

```kotlin
list.remove(1)
```

### [MutableList: removeAt()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/remove-at.html)
- Removes an element at the specified index from the list.
```kotlin
abstract fun removeAt(index: Int): E
```

<br />

```kotlin
list.removeAt(0)
```

<br />

## 1.8 Removing Elements (MutableList)
### [MutableList: clear()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/clear.html)
- Removes all elements from this collection.
```kotlin
abstract fun clear()
```

<br />

```kotlin
list.clear()
```

### [MutableList: removeAll()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/remove-all.html)
- Removes all of this collection's elements that are also contained in the specified collection.
```kotlin
abstract fun removeAll(elements: Collection<E>): Boolean
```

<br />

```kotlin
list.removeAll(listOf(1, 2, 3))
```
<br />

## 1.9 Checking Elements
### [List: contains() or in Keyword](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/contains.html)
- Checks if the specified element is contained in this collection.
```kotlin
abstract fun contains(element: @UnsafeVariance E): Boolean
```

<br />

```kotlin
val answer1: Boolean = 1 in list
val answer2: Boolean = list.contains(1)
```

### [List: containsAll()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/contains-all.html)
- Checks if all elements in the specified collection are contained in this collection.
```kotlin
abstract fun containsAll(
    elements: Collection<@UnsafeVariance E>
): Boolean
```

<br />

```kotlin
val answer: Boolean = list.containsAll(listOf(1, 2, 3))
```

<br />

## 1.10 Iterating over a List
### Using for Loop and in Keyword
```kotlin
for (item in list) {
    println(item)
}
```

### Using for Loop and size
```kotlin
for (i in 0 ..< list.size) {
    println(list[i])
}
```

### Using forEach Function
```kotlin
list.forEach {
    println(it)
}
```

### Using forEachIndexed Function
```kotlin
list.forEachIndexed { index, i ->
    println(i)
}
```

<br />

## 1.11 Converting between Collections
### [Iterable: toMutableList()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-mutable-list.html)
- Returns a new MutableList filled with all elements of this collection.
```kotlin
fun <T> Iterable<T>.toMutableList(): MutableList<T>
```

<br />

```kotlin
val immutableList: List<Int> = listOf(1, 2, 3)
val mutableList: MutableList<Int> = immutableList.toMutableList()
```

### [Iterable: toList()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-list.html)
- Returns a List containing all elements.
```kotlin
fun <T> Iterable<T>.toList(): List<T>
```

<br />

```kotlin
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
val immMutableList: List<Int> = mutableList.toList()
```

### [Iterable: toMutableSet()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-mutable-set.html)
- Returns a new MutableSet containing all distinct elements from the given collection.
```kotlin
fun <T> Iterable<T>.toMutableSet(): MutableSet<T>
```

<br />

```kotlin
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
val mutableSet: MutableSet<Int> = mutableList.toMutableSet()
```

### [Iterable: toSet()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-set.html)
- Returns a Set of all elements.
```kotlin
fun <T> Iterable<T>.toSet(): Set<T>
```

<br />

```kotlin
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
val immutableSet: Set<Int> = mutableList.toSet()
```

<br />
