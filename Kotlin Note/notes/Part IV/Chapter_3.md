# [Kotlin Note](../../README.md) - Chapter 3 Enum Classes
| Chapter | Title |
| :-: | :- |
| 3.1 | [Enum Class Declaration](#31-enum-class-declaration) |
| 3.2 | [Enum Class Provided Properties and Functions](#32-enum-class-provided-properties-and-functions) |
|  | [Enum Class Provided: name](#enum-class-provided-name) |
|  | [Enum Class Provided: ordinal](#enum-class-provided-ordinal) |
|  | [Enum Class Provided: equals()](#enum-class-provided-equals) |
|  | [Enum Class Provided: hashCode()](#enum-class-provided-hashcode) |
|  | [Enum Class Provided: toString()](#enum-class-provided-tostring) |
|  | [Enum Class Provided: compareTo()](#enum-class-provided-compareto) |
| 3.3 | [Enum Class Properties and Functions](#33-enum-class-properties-and-functions) |
|  | [Enum Class Properties](#enum-class-properties) |
|  | [Enum Class Functions](#enum-class-functions) |

<br />

## 3.1 Enum Class Declaration
```kotlin
enum class FoodType {

    Meat,
    Fruit,
    Vegetables
}
```
```kotlin
val foodType: FoodType = FoodType.Meat
```

<br />

## 3.2 Enum Class Provided Properties and Functions
```kotlin
enum class FoodType {

    Meat,
    Fruit,
    Vegetables
}
```
```kotlin
val foodType1: FoodType = FoodType.Meat
val foodType2: FoodType = FoodType.Fruit
```

### Enum Class Provided: name
```kotlin
val name: String = foodType1.name
```

### Enum Class Provided: ordinal
```kotlin
val ordinal: Int = foodType1.ordinal                // 0
```

### Enum Class Provided: equals()
```kotlin
val equal: Boolean = foodType1.equals(foodType2)
```

### Enum Class Provided: hashCode()
```kotlin
val hashCode: Int = foodType1.hashCode()
```

### Enum Class Provided: toString()
```kotlin
val name: String = foodType1.toString()             // Meat
```

### Enum Class Provided: compareTo()
```kotlin
val compare1: Boolean = foodType1 < foodType2
val compare2: Boolean = foodType1 > foodType2
val compare3: Boolean = foodType1 <= foodType2
val compare4: Boolean = foodType1 >= foodType2
```

<br />

## 3.3 Enum Class Properties and Functions
### Enum Class Properties
```kotlin
enum class FoodType(val energy: Int) {

    Meat(100),
    Fruit(30),
    Vegetables(10)
}
```
```kotlin
val foodType: FoodType = FoodType.Meat
val energy: Int = foodType.energy
```

### Enum Class Functions
```kotlin
enum class FoodType {

    Meat,
    Fruit,
    Vegetables;

    fun printHelloWorld() {
        println("Hello World")
    }
}
```
```kotlin
val foodType: FoodType = FoodType.Meat
foodType.printHelloWorld()
```

<br />
