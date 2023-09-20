# [Kotlin Note](../../README.md) - Chapter 13 Collection Functions
| Chapter | Title |
| :-: | :- |
| 13.1 | [Transforming Data](#131-transforming-data) |
|  | [Iterable: map](#iterable-map) |
|  | [Iterable: associate](#iterable-associate) |
|  | [Iterable: flatMap](#iterable-flatmap) |
| 13.2 | [Filtering Data](#132-filtering-data) |
|  | [Iterable: filter](#iterable-filter) |
| 13.3 | [Combining Data](#133-combining-data) |
|  | [Iterable: zip](#iterable-zip) |
| 13.4 | [Aggregating Data](#134-aggregating-data) |
|  | [Iterable: reduce](#iterable-reduce) |
|  | [Iterable: fold](#iterable-fold) |
|  | [Iterable: sumOf](#iterable-sumof) |

<br />

## 13.1 Transforming Data
### [Iterable: map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html)
- Returns a list containing the results of applying the given transform function to each element in the original collection.
```kotlin
inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R>
```

```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val stringList: List<String> = intList.map {
    it.toString()
}
```

### [Iterable: associate](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/associate.html)
- Returns a Map containing key-value pairs provided by transform function applied to elements of the given collection.
```kotlin
inline fun <T, K, V> Iterable<T>.associate(
    transform: (T) -> Pair<K, V>
): Map<K, V>
```

```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val map: Map<Int, String> = intList.associate {
    it to it.toString()
}
```

### [Iterable: flatMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/flat-map.html)
- Returns a single list of all elements yielded from results of transform function being invoked on each element of original collection.
```kotlin
inline fun <T, R> Iterable<T>.flatMap(
    transform: (T) -> Iterable<R>
): List<R>
```

```kotlin
val nestedList: List<List<Int>> = listOf(
    listOf(1, 2, 3),
    listOf(4, 5, 6),
    listOf(7, 8, 9)
)
val intList: List<Int> = nestedList.flatMap {
    it
}
```

<br />

## 13.2 Filtering Data
### [Iterable: filter](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/filter.html)
- Returns a list containing only elements matching the given predicate.
```kotlin
inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T>
```

```kotlin
val intList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val oddList: List<Int> = intList.filter {
    it % 2 == 1
}
```

<br />

## 13.3 Combining Data
### [Iterable: zip](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/zip.html)
- Returns a list of pairs built from the elements of this collection and the other array with the same index. The returned list has length of the shortest collection.
```kotlin
infix fun <T, R> Iterable<T>.zip(
    other: Array<out R>
): List<Pair<T, R>>
```

- Returns a list of values built from the elements of this collection and the other array with the same index using the provided transform function applied to each pair of elements. The returned list has length of the shortest collection.
```kotlin
inline fun <T, R, V> Iterable<T>.zip(
    other: Array<out R>,
    transform: (a: T, b: R) -> V
): List<V>
```

- Returns a list of pairs built from the elements of this collection and other collection with the same index. The returned list has length of the shortest collection.
```kotlin
infix fun <T, R> Iterable<T>.zip(
    other: Iterable<R>
): List<Pair<T, R>>
```

- Returns a list of values built from the elements of this collection and the other collection with the same index using the provided transform function applied to each pair of elements. The returned list has length of the shortest collection.
```kotlin
inline fun <T, R, V> Iterable<T>.zip(
    other: Iterable<R>,
    transform: (a: T, b: R) -> V
): List<V>
```

```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val charList: List<Char> = listOf('A', 'B', 'C')
val stringList: List<String> = intList.zip(charList) { a: Int, b: Char ->
    "$a and $b"
}
```

<br />

## 13.4 Aggregating Data
### [Iterable: reduce](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/reduce.html)
- Accumulates value starting with the first element and applying operation from left to right to current accumulator value and each element.
```kotlin
inline fun <S, T : S> Iterable<T>.reduce(
    operation: (acc: S, T) -> S
): S
```

```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val num: Int = intList.reduce { acc, i ->
    acc + i
}
```

### [Iterable: fold](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/fold.html)
- Accumulates value starting with initial value and applying operation from left to right to current accumulator value and each element.
```kotlin
inline fun <T, R> Iterable<T>.fold(
    initial: R,
    operation: (acc: R, T) -> R
): R
```

```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val num: Int = intList.reduce { acc: Int, i: Int ->
    acc + i
}
```

### [Iterable: sumOf](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sum-of.html)
- Returns the sum of all values produced by selector function applied to each element in the collection.
```kotlin
@JvmName("sumOfDouble") inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> Double
): Double

@JvmName("sumOfInt") inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> Int
): Int

@JvmName("sumOfLong") inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> Long
): Long

@JvmName("sumOfUInt") inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> UInt
): UInt

@JvmName("sumOfULong") inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> ULong
): ULong

@JvmName("sumOfBigDecimal") inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> BigDecimal
): BigDecimal

@JvmName("sumOfBigInteger") inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> BigInteger
): BigInteger
```

```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val num: Int = intList.sumOf {
    it
}
```

<br />
