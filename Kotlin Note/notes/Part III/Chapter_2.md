# [Kotlin Note](../../README.md) - Chapter 2 Sets
| Chapter | Title |
| :-: | :- |
| 2.1 | [Set Data Types](#21-set-data-types) |
| 2.2 | [Creating a Set](#22-creating-a-set) |
|  | [Creating an Empty Mutable Set](#creating-an-empty-mutable-set) |
|  | [Creating a Non-Empty Mutable Set](#creating-a-non-empty-mutable-set) |
|  | [Creating an Empty Immutable Set](#creating-an-empty-immutable-set) |
|  | [Creating a Non-Empty Immutable Set](#creating-a-non-empty-immutable-set) |
| 2.3 | [Set Properties](#23-set-properties) |
|  | [size](#size) |
| 2.4 | [Adding an Element (MutableSet)](#24-adding-an-element-mutableset) |
|  | [Using add Method](#using-add-method) |
|  | [Using addAll Method](#using-addall-method) |
| 2.5 | [Removing an Element (MutableSet)](#25-removing-an-element-mutableset) |
|  | [Using remove Method](#using-remove-method) |
| 2.6 | [Removing Elements (MutableSet)](#26-removing-elements-mutableset) |
|  | [Using clear Method](#using-clear-method) |
|  | [Using removeAll Method](#using-removeall-method) |
| 2.7 | [Checking Elements](#27-checking-elements) |
|  | [Using in Operator or contains Method](#using-in-operator-or-contains-method) |
|  | [Using containsAll Method](#using-containsall-method) |
| 2.8 | [Iterating over a Set](#28-iterating-over-a-set) |
|  | [Using forEach Method](#using-foreach-method) |
|  | [Using forEachIndexed Function](#using-foreachindexed-function) |
| 2.9 | [Converting between Collections](#29-converting-between-collections) |
|  | [Using toMutableList Method](#using-tomutablelist-method) |
|  | [Using toList Method](#using-tolist-method) |
|  | [Using toMutableSet Method](#using-tomutableset-method) |
|  | [Using toSet Method](#using-toset-method) |

<br />

## 2.1 Set Data Types
| Type | Description | Change Size | Change Element though Index/Key | Example |
| :-- | :-- | :--: | :--: | :-- |
| MutableSet\<Int> | Mutable Set | Y | - | mutableSetOf(1, 2, 3) |
| Set\<Int> | Immutable Set | N | - | setOf(1, 2, 3) |

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
### size
- Returns the size of the collection.

```kotlin
val num: Int = set.size
```

<br />

## 2.4 Adding an Element (MutableSet)
### Using add Method
- Adds the specified element to the set.
```kotlin
set.add(100)
```

### Using addAll Method
- Adds all of the elements of the specified collection to this collection.
```kotlin
set.addAll(listOf(4, 5, 6))
```

<br />

## 2.5 Removing an Element (MutableSet)
### Using remove Method
- Removes a single instance of the specified element from this collection, if it is present.
```kotlin
set.remove(1)
```

<br />

## 2.6 Removing Elements (MutableSet)
### Using clear Method
- Removes all elements from this collection.
```kotlin
set.clear()
```

### Using removeAll Method
- Removes all of this collection's elements that are also contained in the specified collection.
```kotlin
set.removeAll(listOf(1, 2, 3))
```
<br />

## 2.7 Checking Elements
### Using in Operator or contains Method
- Returns true if element is found in the collection.
```kotlin
val answer: Boolean = 1 in set
```
```kotlin
val answer: Boolean = set.contains(1)
```

### Using containsAll Method
- Checks if all elements in the specified collection are contained in this collection.
```kotlin
val answer: Boolean = set.containsAll(listOf(1, 2, 3))
```

<br />

## 2.8 Iterating over a Set
### Using forEach Method
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
### Using toMutableList Method
```kotlin
val mutableSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
val mutableList: MutableList<Int> = mutableSet.toMutableList()
```

### Using toList Method
```kotlin
val mutableSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
val immMutableList: List<Int> = mutableSet.toList()
```

### Using toMutableSet Method
```kotlin
val immutableSet: Set<Int> = setOf(1, 2, 3)
val mutableSet: MutableSet<Int> = immutableSet.toMutableSet()
```

### Using toSet Method
```kotlin
val mutableSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
val immutableSet: Set<Int> = mutableSet.toSet()
```

<br />
