# [Kotlin Note](../../README.md) - Chapter 6 Abstract Classes
| Chapter | Title |
| :-: | :- |
| 6.1 | [Abstract Class Declaration](#61-abstract-class-declaration) |
| 6.2 | [Abstract Class Properties and Methods](#62-abstract-class-properties-and-methods) |
|  | [Accessing Abstract Class Properties](#accessing-abstract-class-properties) |
|  | [Calling Abstract Class Methods](#calling-abstract-class-methods) |
| 6.3 | [Default Abstract Class Properties and Methods](#63-default-abstract-class-properties-and-methods) |
|  | [Accessing Default Abstract Class Properties](#accessing-default-abstract-class-properties) |
|  | [Calling Default Abstract Class Methods](#calling-default-abstract-class-methods) |

<br />

## 6.1 Abstract Class Declaration
```kotlin
abstract class Animal {
}

class Fish : Animal() {
}
```
```kotlin
val fish: Fish = Fish()
```

<br />

## 6.2 Abstract Class Properties and Methods
```kotlin
abstract class Animal {

    abstract var name: String

    abstract fun move()
}

class Fish : Animal() {
    override var name: String = ""

    override fun move() {
        println("I am swimming")
    }
}
```
```kotlin
val fish: Fish = Fish()
```

### Accessing Abstract Class Properties
```kotlin
fish.name = "Fish"
```

### Calling Abstract Class Methods
```kotlin
fish.move()
```

<br />

## 6.3 Default Abstract Class Properties and Methods
```kotlin
abstract class Animal {

    var name: String = ""

    fun move() {
        println("I am moving")
    }
}

class Fish : Animal() {
}
```
```kotlin
val fish: Fish = Fish()
```

### Accessing Default Abstract Class Properties
```kotlin
fish.name = "Fish"
```

### Calling Default Abstract Class Methods
```kotlin
fish.move()
```

<br />
