# [Kotlin Note](../../README.md) - Chapter 2 Data Classes
| Chapter | Title |
| :-: | :- |
| 2.1 | [Data Class Delcaration](#21-data-class-delcaration) |
| 2.2 | [Provided Data Class Functions](#22-provided-data-class-functions) |
|  | [Provided Function: equals()](#provided-function-equals) |
|  | [Provided Function: hashCode()](#provided-function-hashcode) |
|  | [Provided Function: toString()](#provided-function-tostring) |
|  | [Provided Function: componentN()](#provided-function-componentn) |
|  | [Provided Function: copy()](#provided-function-copy) |
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

## 2.2 [Provided Data Class Functions](https://kotlinlang.org/docs/data-classes.html)
```kotlin
data class Food(var type: String, var energy: Int)
```
```kotlin
val food1: Food = Food("Meat", 100)
val food2: Food = Food("Fruit", 100)
```

### Provided Function: equals()
```kotlin
val equal: Boolean = food1.equals(food2)
```

### Provided Function: hashCode()
```kotlin
val hashCode: Int = food1.hashCode()
```

### Provided Function: toString()
```kotlin
val info: String = food1.toString()             // Food(type=Meat, energy=100)
```

### Provided Function: componentN()
```kotlin
val type: String = food1.component1()
```
```kotlin
val energy: Int = food1.component2()
```

### Provided Function: copy()
```kotlin
val food3: Food = food1.copy()
```
```kotlin
val food3: Food = food1.copy(energy = 1000)
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
```kotlin
val food: Food = Food("Meat", 100)
```

### Destructing Data Class without Type Inference
```kotlin
val (type: String, energy: Int) = food
```

### Destructing Data Class with Type Inference
```kotlin
val (type, energy) = food
```

<br />
