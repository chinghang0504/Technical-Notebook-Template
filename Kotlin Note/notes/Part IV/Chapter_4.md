# [Kotlin Note](../../README.md) - Chapter 4 Enum Classes
| Chapter | Title |
| :-: | :- |
| 4.1 | [Enum Class Declaration](#41-enum-class-declaration) |
| 4.2 | [Enum Class Properties and Methods](#42-enum-class-properties-and-methods) |
|  | [Accessing Enum Class Properties](#accessing-enum-class-properties) |
|  | [Calling Enum Class Methods](#calling-enum-class-methods) |
| 4.3 | [Enum Class Default Methods](#43-enum-class-default-methods) |
|  | [Using toString Method](#using-tostring-method) |
|  | [Using equals Method](#using-equals-method) |
|  | [Using hashCode Method](#using-hashcode-method) |

<br />

## 4.1 Enum Class Declaration
```kotlin
enum class LivingPlace {
    Land,
    Sea,
    Sky,
    Tree,
    Cave
}
```
```kotlin
val land: LivingPlace = LivingPlace.Land
```

<br />

## 4.2 Enum Class Properties and Methods
```kotlin
enum class LivingPlace(val elevation: Double) {
    Land(0.0),
    Sea(-10.0),
    Sky(10.0),
    Tree(2.0),
    Cave(-1.0);

    fun printElevation() {
        println("Elevation: $elevation")
    }
}
```
```kotlin
val land: LivingPlace = LivingPlace.Land
```

### Accessing Enum Class Properties
```kotlin
println(land.elevation)
```

### Calling Enum Class Methods
```kotlin
land.printElevation()
```

<br />

## 4.3 Enum Class Default Methods
### Using toString Method
```kotlin
val land: LivingPlace = LivingPlace.Land
println(land.toString())        // Land
```

### Using equals Method
```kotlin
val land1: LivingPlace = LivingPlace.Land
val land2: LivingPlace = LivingPlace.Land

println(land1.equals(land2))    // true
```

### Using hashCode Method
```kotlin
val land: LivingPlace = LivingPlace.Land
println(land.hashCode())        // 455896770
```

<br />
