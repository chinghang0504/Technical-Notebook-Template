# [Kotlin Note](../../README.md) - Chapter 7 Generics
| Chapter | Title |
| :-: | :- |
| 7.1 | [Generic Class Declaration](#71-generic-class-declaration) |
| 7.2 | [Generic Class Constraints](#72-generic-class-constraints) |
| 7.3 | [Generic Class Properties and Functions](#73-generic-class-properties-and-functions) |
|  | [Generic Class Properties](#generic-class-properties) |
|  | [Generic Class Functions](#generic-class-functions) |

<br />

## 7.1 Generic Class Declaration
```kotlin
class Cage<T> {
}
```
```kotlin
val cage: Cage<Any> = Cage()
```

<br />

## 7.2 Generic Class Constraints
```kotlin
class Animal {
}

class Cage<T: Animal> {
}
```
```kotlin
val cage: Cage<Animal> = Cage()
```

<br />

## 7.3 Generic Class Properties and Functions
### Generic Class Properties
```kotlin
class Animal {
}

class Cage<T: Animal>(var animal: T) {
}
```
```kotlin
val cage: Cage<Animal> = Cage(Animal())
val animal: Animal = cage.animal
```

### Generic Class Functions
```kotlin
class Animal {
}

class Cage<T: Animal?>(var animal: T?) {

    fun release(): T? {
        val temp: T? = animal
        animal = null
        return temp
    }
}
```
```kotlin
val cage: Cage<Animal> = Cage(Animal())
val animal: Animal? = cage.release()
```

<br />
