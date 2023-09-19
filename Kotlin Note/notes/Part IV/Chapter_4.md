# [Kotlin Note](../../README.md) - Chapter 4 Data Classes
| Chapter | Title |
| :-: | :- |
| 4.1 | [Data Class Delcaration](#41-data-class-delcaration) |
| 4.2 | [Data Class Default Methods](#42-data-class-default-methods) |
|  | [Using toString Method](#using-tostring-method) |
|  | [Using equals Method](#using-equals-method) |
|  | [Using hashCode Method](#using-hashcode-method) |
|  | [Using copy Method](#using-copy-method) |
| 4.3 | [Destructing Data Class](#43-destructing-data-class) |

<br />

## 4.1 Data Class Delcaration
```kotlin
data class Food(val name: String, val energy: Double)
```
```kotlin
val food: Food = Food("Meat", 100.0)
```

<br />

## 4.2 Data Class Default Methods
### Using toString Method
```kotlin
println(food.toString())        // Food(name=Meat, energy=100.0)
```

### Using equals Method
```kotlin
println(food1.equals(food2))    // true
```

### Using hashCode Method
```kotlin
println(food.hashCode())        // 1153791349
```

### Using copy Method
```kotlin
val food1: Food = Food("Meat", 100.0)
val food2: Food = food1.copy()

println(food1.equals(food2))        // true
```
```kotlin
val food1: Food = Food("Meat", 100.0)
val food2: Food = food1.copy(name = "Apple")

println(food1.equals(food2))        // false
```

<br />

## 4.3 Destructing Data Class
```kotlin
val (name, energy) = Food("Meat", 100.0)

println(name)       // Meat
println(energy)     // 100.0
```

<br />
