# [Kotlin Note](../../README.md) - Chapter 3 Enum Classes
| Chapter | Title |
| :-: | :- |
| 3.1 | [Enum Class Declaration](#31-enum-class-declaration) |
| 3.2 | [Provided Enum Class Properties and Functions](#32-provided-enum-class-properties-and-functions) |
|  | [Provided Property: name](#provided-property-name) |
|  | [Provided Property: ordinal](#provided-property-ordinal) |
|  | [Provided Function: equals()](#provided-function-equals) |
|  | [Provided Function: hashCode()](#provided-function-hashcode) |
|  | [Provided Function: toString()](#provided-function-tostring) |
|  | [Provided Function: compareTo()](#provided-function-compareto) |
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

## 3.2 Provided Enum Class Properties and Functions
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

### Provided Property: name
```kotlin
val name: String = foodType1.name
```

### Provided Property: ordinal
```kotlin
val ordinal: Int = foodType1.ordinal                // 0
```

### Provided Function: equals()
```kotlin
val equal: Boolean = foodType1.equals(foodType2)
```

### Provided Function: hashCode()
```kotlin
val hashCode: Int = foodType1.hashCode()
```

### Provided Function: toString()
```kotlin
val name: String = foodType1.toString()             // Meat
```

### Provided Function: compareTo()
```kotlin
var compare: Boolean = foodType1 < foodType2
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
