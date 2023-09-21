# [Kotlin Note](../../README.md) - Chapter 5 Enum Classes
| Chapter | Title |
| :-: | :- |
| 5.1 | [Enum Class Declaration](#51-enum-class-declaration) |
| 5.2 | [Provided Enum Class Properties and Functions](#52-provided-enum-class-properties-and-functions) |
|  | [Provided Propertie: name](#provided-propertie-name) |
|  | [Provided Propertie: ordinal](#provided-propertie-ordinal) |
|  | [Provided Function: equals](#provided-function-equals) |
|  | [Provided Function: hashCode](#provided-function-hashcode) |
|  | [Provided Function: toString](#provided-function-tostring) |
|  | [Provided Function: compareTo](#provided-function-compareto) |
| 5.3 | [Enum Class Properties and Functions](#53-enum-class-properties-and-functions) |
|  | [Enum Class Properties](#enum-class-properties) |
|  | [Enum Class Functions](#enum-class-functions) |

<br />

## 5.1 Enum Class Declaration
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

## 5.2 Provided Enum Class Properties and Functions
```kotlin
enum class FoodType {

    Meat,
    Fruit,
    Vegetables
}
```

### Provided Propertie: name
```kotlin
val foodType: FoodType = FoodType.Meat
val name: String = foodType.name
```

### Provided Propertie: ordinal
```kotlin
val foodType: FoodType = FoodType.Meat
val ordinal: Int = foodType.ordinal
println(ordinal)                            // 0
```

### Provided Function: equals
```kotlin
val foodType1: FoodType = FoodType.Meat
val foodType2: FoodType = FoodType.Fruit
println(foodType1.equals(foodType2))
```

### Provided Function: hashCode
```kotlin
val foodType: FoodType = FoodType.Meat
println(foodType.hashCode())
```

### Provided Function: toString
```kotlin
val foodType: FoodType = FoodType.Meat
println(foodType.toString())                // Meat
```

### Provided Function: compareTo
```kotlin
val foodType1: FoodType = FoodType.Meat
val foodType2: FoodType = FoodType.Fruit
println(foodType1 < foodType2)
```

<br />

## 5.3 Enum Class Properties and Functions
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
enum class FoodType(var energy: Int) {

    Meat(100),
    Fruit(30),
    Vegetables(10);

    fun eaten() {
        energy = 0
    }
}
```
```kotlin
val foodType: FoodType = FoodType.Meat
foodType.eaten()
```

<br />
