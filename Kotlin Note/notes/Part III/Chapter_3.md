# [Kotlin Note](../../README.md) - Chapter 3 Maps
| Chapter | Title |
| :-: | :- |
| 3.1 | [Map Types](#31-map-types) |
| 3.2 | [Creating a Map](#32-creating-a-map) |
|  | [Creating an Empty Mutable Map](#creating-an-empty-mutable-map) |
|  | [Creating a Non-Empty Mutable Map](#creating-a-non-empty-mutable-map) |
|  | [Creating an Empty Immutable Map](#creating-an-empty-immutable-map) |
|  | [Creating a Non-Empty Immutable Map](#creating-a-non-empty-immutable-map) |
| 3.3 | [Map Properties](#33-map-properties) |
|  | [Map: size](#map-size) |
|  | [Map: keys](#map-keys) |
|  | [Map: values](#map-values) |
| 3.4 | [Getting an Element](#34-getting-an-element) |
|  | [Map: get() or [] Operator](#map-get-or--operator) |
|  | [Map: getValue()](#map-getvalue) |
|  | [Map: getOrElse()](#map-getorelse) |
|  | [Map: getOrDefault()](#map-getordefault) |
| 3.5 | [Setting an Element (MutableMap)](#35-setting-an-element-mutablemap) |
|  | [MutableMap: set() or [] Operator](#mutablemap-set-or--operator) |
| 3.6 | [Adding an Element (MutableMap)](#36-adding-an-element-mutablemap) |
|  | [MutableMap: put()](#mutablemap-put) |
|  | [MutableMap: putAll()](#mutablemap-putall) |
| 3.7 | [Removing an Element (MutableMap)](#37-removing-an-element-mutablemap) |
|  | [MutableMap: remove()](#mutablemap-remove) |
| 3.8 | [Removing Elements (MutableMap)](#38-removing-elements-mutablemap) |
|  | [MutableMap: clear()](#mutablemap-clear) |
| 3.9 | [Checking Elements](#39-checking-elements) |
|  | [Map: contains() or in Keyword](#map-contains-or-in-keyword) |
|  | [Map: containsKey()](#map-containskey) |
|  | [Map: containsValue()](#map-containsvalue) |
| 3.10 | [Iterating over a Map](#310-iterating-over-a-map) |
|  | [Using forEach Function](#using-foreach-function) |
| 3.11 | [Converting between Collections](#311-converting-between-collections) |
|  | [Map: toMutableMap()](#map-tomutablemap) |
|  | [Map: toMap()](#map-tomap) |
|  | [Map: toList()](#map-tolist) |

<br />

## 3.1 Map Types
| Type | Description |
| :-- | :-- |
| MutableMap\<K, V> | Mutable Map |
| Map\<K, V> | Immutable Map |

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
### [Map: size](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/size.html)
- Returns the number of key/value pairs in the map.
```kotlin
abstract val size: Int
```

<br />

```kotlin
val size: Int = map.size
```

<br />

### [Map: keys](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/keys.html)
- Returns a read-only Set of all keys in this map.
```kotlin
abstract val keys: Set<K>
```

<br />

```kotlin
val keys: Set<Int> = map.keys
```

<br />

### [Map: values](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/values.html)
- Returns a read-only Collection of all values in this map. Note that this collection may contain duplicate values.
```kotlin
abstract val values: Collection<V>
```

<br />

```kotlin
val values: MutableCollection<Char> = map.values
```

<br />

## 3.4 Getting an Element
### [Map: get() or [] Operator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/get.html)
- Returns the value corresponding to the given key, or null if such a key is not present in the map.
```kotlin
abstract operator fun get(key: K): V?
```

<br />

```kotlin
val ch1: Char? = map[1]
val ch2: Char? = map.get(1)
```

### [Map: getValue()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/get-value.html)
- Returns the value for the given key or throws an exception if there is no such key in the map.
```kotlin
fun <K, V> Map<K, V>.getValue(key: K): V
```

<br />

```kotlin
val ch: Char = map.getValue(0)
```

### [Map: getOrElse()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/get-or-else.html)
- Returns the value for the given key if the value is present and not null. Otherwise, returns the result of the defaultValue function.
```kotlin
inline fun <K, V> Map<K, V>.getOrElse(
    key: K,
    defaultValue: () -> V
): V
```

<br />

```kotlin
val ch: Char = map.getOrElse(0, { 'Z' })
```

### [Map: getOrDefault()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/get-or-default.html)
- Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
```kotlin
fun <K, V> Map<out K, V>.getOrDefault(
    key: K,
    defaultValue: V
): V
```

<br />

```kotlin
val ch: Char = map.getOrDefault(0, 'Z')
```

<br />

## 3.5 Setting an Element (MutableMap)
### [MutableMap: set() or [] Operator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/set.html)
- Allows to use the index operator for storing values in a mutable map.
```kotlin 
operator fun <K, V> MutableMap<K, V>.set(key: K, value: V)
```

<br />

```kotlin
map[1] = 'Z'
map.set(1, 'Z')
```

<br />

## 3.6 Adding an Element (MutableMap)
### [MutableMap: put()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/put.html)
- Associates the specified value with the specified key in the map.
```kotlin
abstract fun put(key: K, value: V): V?
```

<br />

```kotlin
map.put(4, 'Z')
```

### [MutableMap: putAll()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/put-all.html)
- Updates this map with key/value pairs from the specified map from.
```kotlin
abstract fun putAll(from: Map<out K, V>)
```

<br />

```kotlin
map.putAll(listOf(4 to 'X', 5 to 'Y', 6 to 'Z'))
```

<br />

## 3.7 Removing an Element (MutableMap)
### [MutableMap: remove()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/remove.html)
- Removes the specified key and its corresponding value from this map.
```kotlin
abstract fun remove(key: K): V?
```

<br />

```kotlin
map.remove(1)
```

- Removes the entry for the specified key only if it is mapped to the specified value.
```kotlin
open fun remove(key: K, value: V): Boolean
```

<br />

```kotlin
map.remove(1, 'A')
```

<br />

## 3.8 Removing Elements (MutableMap)
### [MutableMap: clear()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/clear.html)
- Removes all elements from this map.
```kotlin
abstract fun clear()
```

<br />

```kotlin
map.clear()
```

<br />

## 3.9 Checking Elements
### [Map: contains() or in Keyword](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/contains.html)
- Checks if the map contains the given key.
```kotlin
operator fun <K, V> Map<out K, V>.contains(key: K): Boolean
```

<br />

```kotlin
val answer1: Boolean = 1 in map
val answer2: Boolean = map.contains(1)
```

### [Map: containsKey()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/contains-key.html)
- Returns true if the map contains the specified key.
```kotlin
fun <K> Map<out K, *>.containsKey(key: K): Boolean
```

<br />

```kotlin
val answer: Boolean = map.containsKey(1)
```

<br />

### [Map: containsValue()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/contains-value.html)
- Returns true if the map maps one or more keys to the specified value.
```kotlin
fun <K, V> Map<K, V>.containsValue(value: V): Boolean
```

<br />

```kotlin
val answer: Boolean = map.containsValue('A')
```

<br />

## 3.10 Iterating over a Map
### Using forEach Function
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
### [Map: toMutableMap()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-mutable-map.html)
- Returns a new mutable map containing all key-value pairs from the original map.
```kotlin
fun <K, V> Map<out K, V>.toMutableMap(): MutableMap<K, V>
```

<br />

```kotlin
val immutableMap: Map<Int, Char> = mapOf(1 to 'A', 2 to 'B', 3 to 'C')
val mutableMap: MutableMap<Int, Char> = immutableMap.toMutableMap()
```

### [Map: toMap()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-map.html)
- Returns a new read-only map containing all key-value pairs from the original map.
```kotlin
fun <K, V> Map<out K, V>.toMap(): Map<K, V>
```

<br />

```kotlin
val mutableMap: MutableMap<Int, Char> = mutableMapOf(1 to 'A', 2 to 'B', 3 to 'C')
val immutableMap: Map<Int, Char> = mutableMap.toMap()
```

### [Map: toList()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/to-list.html)
- Returns a List containing all key-value pairs.
```kotlin
fun <K, V> Map<out K, V>.toList(): List<Pair<K, V>>
```

<br />

```kotlin
val mutableMap: MutableMap<Int, Char> = mutableMapOf(1 to 'A', 2 to 'B', 3 to 'C')
val immutableList: List<Pair<Int, Char>> = mutableMap.toList()
```

<br />
