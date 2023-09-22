# [Kotlin Note](../../README.md) - Chapter 2 Data Classes
| Chapter | Title |
| :-: | :- |
| 2.1 | [Data Class Delcaration](#21-data-class-delcaration) |
| 2.2 | [Data Class Provided Functions](#22-data-class-provided-functions) |
|  | [Data Class Provided: equals()](#data-class-provided-equals) |
|  | [Data Class Provided: hashCode()](#data-class-provided-hashcode) |
|  | [Data Class Provided: toString()](#data-class-provided-tostring) |
|  | [Data Class Provided: componentN()](#data-class-provided-componentn) |
|  | [Data Class Provided: copy()](#data-class-provided-copy) |
| 2.3 | [Data Class Properties and Functions](#23-data-class-properties-and-functions) |
|  | [Data Class Properties](#data-class-properties) |
|  | [Data Class Functions](#data-class-functions) |
| 2.4 | [Destructing Data Class](#24-destructing-data-class) |
|  | [Destructing Data Class without Type Inference](#destructing-data-class-without-type-inference) |
|  | [Destructing Data Class with Type Inference](#destructing-data-class-with-type-inference) |

<br />

## 2.1 Data Class Delcaration
```kotlin
data class Food(var type: String, var energy: Int)
```
```kotlin
val food: Food = Food("Meat", 100)
```

<br />

## 2.2 [Data Class Provided Functions](https://kotlinlang.org/docs/data-classes.html)
```kotlin
data class Food(var type: String, var energy: Int)
```
```kotlin
val food1: Food = Food("Meat", 100)
val food2: Food = Food("Fruit", 100)
```

### Data Class Provided: equals()
```kotlin
val equal: Boolean = food1.equals(food2)
```

### Data Class Provided: hashCode()
```kotlin
val hashCode: Int = food1.hashCode()
```

### Data Class Provided: toString()
```kotlin
val info: String = food1.toString()             // Food(type=Meat, energy=100)
```

### Data Class Provided: componentN()
```kotlin
val type: String = food1.component1()
val energy: Int = food1.component2()
```

### Data Class Provided: copy()
```kotlin
val food3: Food = food1.copy()
val food4: Food = food1.copy(energy = 1000)
```

<br />

## 2.3 Data Class Properties and Functions
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

## 2.4 Destructing Data Class
```kotlin
data class Food(var type: String, var energy: Int)
```

### Destructing Data Class without Type Inference
```kotlin
val (type: String, energy: Int) = Food("Meat", 100)
```

### Destructing Data Class with Type Inference
```kotlin
val (type, energy) = Food("Meat", 100)
```

<br />
