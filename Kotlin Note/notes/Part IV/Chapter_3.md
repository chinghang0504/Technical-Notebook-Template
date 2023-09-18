# [Kotlin Note](../../README.md) - Chapter 3 Data Classes
| Chapter | Title |
| :-: | :- |
| 3.1 | [Data Class Delcaration](#31-data-class-delcaration) |
| 3.2 | [Data Class Default Methods](#32-data-class-default-methods) |
|  | [Using toString Method](#using-tostring-method) |
|  | [Using equals Method](#using-equals-method) |
|  | [Using hashCode Method](#using-hashcode-method) |
|  | [Using copy Method](#using-copy-method) |
| 3.3 | [Destructing Data Class](#33-destructing-data-class) |

<br />

## 3.1 Data Class Delcaration
```kotlin
data class Food(val name: String, val energy: Double)
```
```kotlin
val food: Food = Food("Meat", 100.0)
```

<br />

## 3.2 Data Class Default Methods
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

## 3.3 Destructing Data Class
```kotlin
val (name, energy) = Food("Meat", 100.0)

println(name)       // Meat
println(energy)     // 100.0
```

<br />
