# [Kotlin Note](../../README.md) - Chapter 3 Maps
| Chapter | Title |
| :-: | :- |
| 3.1 | [Map Data Types](#31-map-data-types) |
| 3.2 | [Creating a Map](#32-creating-a-map) |
|  | [Creating an Empty Mutable Map](#creating-an-empty-mutable-map) |
|  | [Creating a Non-Empty Mutable Map](#creating-a-non-empty-mutable-map) |
|  | [Creating an Empty Immutable Map](#creating-an-empty-immutable-map) |
|  | [Creating a Non-Empty Immutable Map](#creating-a-non-empty-immutable-map) |
| 3.3 | [Map Properties](#33-map-properties) |
| 3.4 | [Getting an Element](#34-getting-an-element) |
|  | [Using [] Operator or get Method (Non-Throwable)](#using--operator-or-get-method-non-throwable) |
|  | [Using getValue Method](#using-getvalue-method) |
|  | [Using getOrElse Method (Non-Throwable)](#using-getorelse-method-non-throwable) |
|  | [Using getOrDefault Method (Non-Throwable)](#using-getordefault-method-non-throwable) |
| 3.5 | [Setting an Element (MutableMap)](#35-setting-an-element-mutablemap) |
|  | [Using [] Operator or set Method](#using--operator-or-set-method) |
| 3.6 | [Adding an Element (MutableMap)](#36-adding-an-element-mutablemap) |
|  | [Using put Method](#using-put-method) |
|  | [Using putAll Method](#using-putall-method) |
| 3.7 | [Removing an Element (MutableMap)](#37-removing-an-element-mutablemap) |
|  | [Using remove Method](#using-remove-method) |
| 3.8 | [Removing Elements (MutableMap)](#38-removing-elements-mutablemap) |
|  | [Using clear Method](#using-clear-method) |
| 3.9 | [Checking Elements](#39-checking-elements) |
|  | [Using in Operator or contains Method](#using-in-operator-or-contains-method) |
|  | [Using containsValue Method](#using-containsvalue-method) |
| 3.10 | [Iterating over a Map](#310-iterating-over-a-map) |
|  | [Using forEach Method](#using-foreach-method) |
| 3.11 | [Converting between Collections](#311-converting-between-collections) |
|  | [Using toMutableMap Method](#using-tomutablemap-method) |
|  | [Using toMap Method](#using-tomap-method) |
|  | [Using toList Method](#using-tolist-method) |

<br />

## 3.1 Map Data Types
| Type | Description | Change Size | Change Element though Index/Key | Example |
| :-- | :-- | :--: | :--: | :-- |
| MutableMap\<Int, Char> | Mutable Map | Y | Y | mutableMapOf(1 to 'A', 2 to 'B', 3 to 'C') |
| Map\<Int, Char> | Immutable Map | N | N | mapOf(1 to 'A', 2 to 'B', 3 to 'C') |

<br />

## 3.2 Creating a Map
### Creating an Empty Mutable Map
```kotlin
val map: MutableMap<Int, Char> = mutableMapOf()
```

### Creating a Non-Empty Mutable Map
```kotlin
val map: MutableMap<Int, Char> = mutableMapOf(1 to 'A', 2 to 'B', 3 to 'C')
```

### Creating an Empty Immutable Map
```kotlin
val map: Map<Int, Char> = mapOf()
```

### Creating a Non-Empty Immutable Map
```kotlin
val map: Map<Int, Char> = mapOf(1 to 'A', 2 to 'B', 3 to 'C')
```

<br />

## 3.3 Map Properties
### size
- Returns the number of key/value pairs in the map.

```kotlin
val num: Int = map.size
```

<br />

## 3.4 Getting an Element
### Using [] Operator or get Method (Non-Throwable)
```kotlin
val ch: Char? = map[1]
```
```kotlin
val ch: Char? = map.get(1)
```

### Using getValue Method
```kotlin
val ch: Char = map.getValue(0)
```

### Using getOrElse Method (Non-Throwable)
```kotlin
val ch: Char = map.getOrElse(0, { 'Z' })
```

### Using getOrDefault Method (Non-Throwable)
```kotlin
val ch: Char = map.getOrDefault(0, 'Z')
```

<br />

## 3.5 Setting an Element (MutableMap)
### Using [] Operator or set Method
```kotlin
map[1] = 'Z'
```
```kotlin
map.set(1, 'Z')
```

<br />

## 3.6 Adding an Element (MutableMap)
### Using put Method
- Associates the specified value with the specified key in the map.
```kotlin
map.put(4, 'Z')
```

### Using putAll Method
- Adds all of the elements of the specified collection to the end of this list.
```kotlin
map.putAll(listOf(4 to 'X', 5 to 'Y', 6 to 'Z'))
```

<br />

## 3.7 Removing an Element (MutableMap)
### Using remove Method
- Removes the specified key and its corresponding value from this map.
```kotlin
map.remove(1)
```

- Removes the entry for the specified key only if it is mapped to the specified value.
```kotlin
map.remove(1, 'A')
```

<br />

## 3.8 Removing Elements (MutableMap)
### Using clear Method
- Removes all elements from this map.
```kotlin
map.clear()
```

<br />

## 3.9 Checking Elements
### Using in Operator or contains Method
- Checks if the map contains the given key.
```kotlin
val answer: Boolean = 1 in map
```
```kotlin
val answer: Boolean = map.contains(1)
```

### Using containsValue Method
- Returns true if the map maps one or more keys to the specified value.
```kotlin
val answer: Boolean = map.containsValue('A')
```

<br />

## 3.10 Iterating over a Map
### Using forEach Method
```kotlin
map.forEach {
    println("Key: ${it.key}, Value: ${it.value}")
}
```

```kotlin
map.forEach { t, u ->
    println("Key: $t, Value: $u")
}
```

<br />

## 3.11 Converting between Collections
### Using toMutableMap Method
```kotlin
val immutableMap: Map<Int, Char> = mapOf(1 to 'A', 2 to 'B', 3 to 'C')
val mutableMap: MutableMap<Int, Char> = immutableMap.toMutableMap()
```

### Using toMap Method
```kotlin
val mutableMap: MutableMap<Int, Char> = mutableMapOf(1 to 'A', 2 to 'B', 3 to 'C')
val immutableMap: Map<Int, Char> = mutableMap.toMap()
```

### Using toList Method
```kotlin
val mutableMap: MutableMap<Int, Char> = mutableMapOf(1 to 'A', 2 to 'B', 3 to 'C')
val immutableList: List<Pair<Int, Char>> = mutableMap.toList()
```

<br />
