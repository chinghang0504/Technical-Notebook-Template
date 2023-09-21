# [Kotlin Note](../../README.md) - Chapter 4 Data Classes
| Chapter | Title |
| :-: | :- |
| 4.1 | [Data Class Delcaration](#41-data-class-delcaration) |
| 4.2 | [Provided Data Class Functions](#42-provided-data-class-functions) |
|  | [Provided Function: equals](#provided-function-equals) |
|  | [Provided Function: hashCode](#provided-function-hashcode) |
|  | [Provided Function: toString](#provided-function-tostring) |
|  | [Provided Function: componentN](#provided-function-componentn) |
|  | [Provided Function: copy](#provided-function-copy) |
| 4.3 | [Data Class Properties and Functions](#43-data-class-properties-and-functions) |
|  | [Data Class Properties](#data-class-properties) |
|  | [Data Class Functions](#data-class-functions) |
| 4.4 | [Destructing Data Class](#44-destructing-data-class) |

<br />

## 4.1 Data Class Delcaration
```kotlin
data class Food(var type: String, var energy: Int)
```
```kotlin
val food: Food = Food("Meat", 100)
```

<br />

## 4.2 [Provided Data Class Functions](https://kotlinlang.org/docs/data-classes.html)
```kotlin
data class Food(var type: String, var energy: Int)
```
### Provided Function: equals
```kotlin
val food1: Food = Food("Meat", 100)
val food2: Food = Food("Meat", 100)
println(food1.equals(food2))
```

### Provided Function: hashCode
```kotlin
val food: Food = Food("Meat", 100)
println(food.hashCode())
```

### Provided Function: toString
```kotlin
val food: Food = Food("Meat", 100)
println(food)                           // Food(type=Meat, energy=100)
```

### Provided Function: componentN
```kotlin
val food: Food = Food("Meat", 100)
val type: String = food.component1()
```
```kotlin
val food: Food = Food("Meat", 100)
val energy: Int = food.component2()
```

### Provided Function: copy
```kotlin
val food1: Food = Food("Meat", 100)
val food2: Food = food1.copy()
println(food2)
```
```kotlin
val food1: Food = Food("Meat", 100)
val food2: Food = food1.copy(energy = 1000)
println(food2)
```

<br />

## 4.3 Data Class Properties and Functions
### Data Class Properties
```kotlin
data class Food(var type: String, var energy: Int)
```
```kotlin
val food: Food = Food("Meat", 100)
val type: String = food.type
val energy: Int = food.energy
```

### Data Class Functions
```kotlin
data class Food(var type: String, var energy: Int) {

    fun eaten() {
        energy = 0
    }
}
```
```kotlin
val food: Food = Food("Meat", 100)
food.eaten()
```

<br />

## 4.4 Destructing Data Class
```kotlin
data class Food(var type: String, var energy: Int)
```
```kotlin
val food: Food = Food("Meat", 100)
val (type: String, energy: Int) = food

println("Type: $type, Energy: $energy")
```
```kotlin
val food: Food = Food("Meat", 100)
val (type, energy) = food

println("Type: $type, Energy: $energy")
```

<br />
