# [Kotlin Note](../../README.md) - Chapter 1 Lists
| Chapter | Title |
| :-: | :- |
| 1.1 | [List Data Types](#11-list-data-types) |
| 1.2 | [Creating a List](#12-creating-a-list) |
|  | [Creating an Empty Mutable List](#creating-an-empty-mutable-list) |
|  | [Creating a Non-Empty Mutable List](#creating-a-non-empty-mutable-list) |
|  | [Creating an Empty Immutable List](#creating-an-empty-immutable-list) |
|  | [Creating a Non-Empty Immutable List](#creating-a-non-empty-immutable-list) |
| 1.3 | [List Properties](#13-list-properties) |
|  | [size](#size) |
|  | [lastIndex](#lastindex) |
| 1.4 | [Getting an Element](#14-getting-an-element) |
|  | [Using [] Operator or get Method](#using--operator-or-get-method) |
|  | [Using getOrElse Method (Non-Throwable)](#using-getorelse-method-non-throwable) |
|  | [Using getOrNull Method (Non-Throwable)](#using-getornull-method-non-throwable) |
|  | [Using first Method](#using-first-method) |
|  | [Using last Method](#using-last-method) |
| 1.5 | [Setting an Element (MutableList)](#15-setting-an-element-mutablelist) |
|  | [Using [] Operator or set Method](#using--operator-or-set-method) |
| 1.6 | [Adding an Element (MutableList)](#16-adding-an-element-mutablelist) |
|  | [Using add Method](#using-add-method) |
|  | [Using addAll Method](#using-addall-method) |
| 1.7 | [Removing an Element (MutableList)](#17-removing-an-element-mutablelist) |
|  | [Using remove Method](#using-remove-method) |
|  | [Using removeAt Method](#using-removeat-method) |
| 1.8 | [Removing Elements (MutableList)](#18-removing-elements-mutablelist) |
|  | [Using clear Method](#using-clear-method) |
|  | [Using removeAll Method](#using-removeall-method) |
| 1.9 | [Checking Elements](#19-checking-elements) |
|  | [Using in Operator or contains Method](#using-in-operator-or-contains-method) |
|  | [Using containsAll Method](#using-containsall-method) |
| 1.10 | [Iterating over a List](#110-iterating-over-a-list) |
|  | [Using for Loop and in Keyword](#using-for-loop-and-in-keyword) |
|  | [Using for Loop and size](#using-for-loop-and-size) |
|  | [Using forEach Method](#using-foreach-method) |
|  | [Using forEachIndexed Function](#using-foreachindexed-function) |
| 1.11 | [Converting between Collections](#111-converting-between-collections) |
|  | [Using toMutableList Method](#using-tomutablelist-method) |
|  | [Using toList Method](#using-tolist-method) |
|  | [Using toMutableSet Method](#using-tomutableset-method) |
|  | [Using toSet Method](#using-toset-method) |

<br />

## 1.1 List Data Types
| Type | Description | Change Size | Change Element though Index/Key | Example |
| :-- | :-- | :--: | :--: | :-- |
| MutableList\<Int> | Mutable list | Y | Y | mutableListOf(1, 2, 3) |
| List\<Int> | Immutable list | N | N | listOf(1, 2, 3) |

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
### size
- Returns the size of the collection.

```kotlin
val num: Int = list.size
```

### lastIndex
- Returns the index of the last item in the list or -1 if the list is empty.

```kotlin
val num: Int = list.lastIndex
```

<br />

## 1.4 Getting an Element
### Using [] Operator or get Method
```kotlin
val num: Int = list[0]
```
```kotlin
val num: Int = list.get(0)
```

### Using getOrElse Method (Non-Throwable)
```kotlin
val num: Int = list.getOrElse(100, { -1 })
```

### Using getOrNull Method (Non-Throwable)
```kotlin
val num: Int? = list.getOrNull(100)
```

### Using first Method
```kotlin
val num: Int = list.first()
```

### Using last Method
```kotlin
val num: Int = list.last()
```

<br />

## 1.5 Setting an Element (MutableList)
### Using [] Operator or set Method
```kotlin
list[0] = 100
```
```kotlin
list.set(0, 100)
```

<br />

## 1.6 Adding an Element (MutableList)
### Using add Method
- Adds the specified element to the end of this list.
```kotlin
list.add(100)
```

- Inserts an element into the list at the specified index.
```kotlin
list.add(0, 100)
```

### Using addAll Method
- Adds all of the elements of the specified collection to the end of this list.
```kotlin
list.addAll(listOf(4, 5, 6))
```

<br />

## 1.7 Removing an Element (MutableList)
### Using remove Method
- Removes a single instance of the specified element from this collection, if it is present.
```kotlin
list.remove(1)
```

### Using removeAt Method
- Removes an element at the specified index from the list.
```kotlin
list.removeAt(0)
```

<br />

## 1.8 Removing Elements (MutableList)
### Using clear Method
- Removes all elements from this collection.
```kotlin
list.clear()
```

### Using removeAll Method
- Removes all of this collection's elements that are also contained in the specified collection.
```kotlin
list.removeAll(listOf(1, 2, 3))
```
<br />

## 1.9 Checking Elements
### Using in Operator or contains Method
- Returns true if element is found in the collection.
```kotlin
val answer: Boolean = 1 in list
```
```kotlin
val answer: Boolean = list.contains(1)
```

### Using containsAll Method
- Checks if all elements in the specified collection are contained in this collection.
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

### Using forEach Method
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
### Using toMutableList Method
```kotlin
val immutableList: List<Int> = listOf(1, 2, 3)
val mutableList: MutableList<Int> = immutableList.toMutableList()
```

### Using toList Method
```kotlin
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
val immMutableList: List<Int> = mutableList.toList()
```

### Using toMutableSet Method
```kotlin
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
val mutableSet: MutableSet<Int> = mutableList.toMutableSet()
```

### Using toSet Method
```kotlin
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
val immutableSet: Set<Int> = mutableList.toSet()
```

<br />
