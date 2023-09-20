# [Kotlin Note](../../README.md) - Chapter 13 Functional Programming
| Chapter | Title |
| :-: | :- |
| 13.1 | [Transforming Data](#131-transforming-data) |
|  | [Using map Method](#using-map-method) |
|  | [Using associate Method](#using-associate-method) |
|  | [Using flatMap Method](#using-flatmap-method) |
| 13.2 | [Filtering Data](#132-filtering-data) |
|  | [Using filter Method](#using-filter-method) |
| 13.3 | [Combining Data](#133-combining-data) |
|  | [Using zip Method](#using-zip-method) |
| 13.4 | [Aggregating Data](#134-aggregating-data) |
|  | [Using reduce Method](#using-reduce-method) |
|  | [Using fold Method](#using-fold-method) |
|  | [Using sumBy Method](#using-sumby-method) |

<br />

## 13.1 Transforming Data
### Using map Method
```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val stringList: List<String> = intList.map {
    it.toString()
}
```

### Using associate Method
```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val map: Map<Int, String> = intList.associate {
    it to it.toString()
}
```

### Using flatMap Method
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
### Using filter Method
```kotlin
val intList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val oddList: List<Int> = intList.filter {
    it % 2 == 1
}
```

<br />

## 13.3 Combining Data
### Using zip Method
```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val charList: List<Char> = listOf('A', 'B', 'C')
val stringList: List<String> = intList.zip(charList) { a: Int, b: Char ->
    "$a and $b"
}
```

<br />

## 13.4 Aggregating Data
### Using reduce Method
```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val num: Int = intList.reduce { acc, i ->
    acc + i
}
```

### Using fold Method
```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val num: Int = intList.reduce { acc: Int, i: Int ->
    acc + i
}
```

### Using sumBy Method
```kotlin
val intList: List<Int> = listOf(1, 2, 3)
val num: Int = intList.sumBy {
    it
}
```

<br />
