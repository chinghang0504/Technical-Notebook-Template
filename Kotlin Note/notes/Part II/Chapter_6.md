# [Kotlin Note](../../README.md) - Chapter 6 Abstract Classes
| Chapter | Title |
| :-: | :- |
| 6.1 | [Abstract Class Declaration](#61-abstract-class-declaration) |
| 6.2 | [Abstract Class Properties and Functions ](#62-abstract-class-properties-and-functions) |
|  | [Abstract Class Properties](#abstract-class-properties) |
|  | [Abstract Class Functions](#abstract-class-functions) |
| 6.3 | [Overriding Abstract Class Properties and Functions](#63-overriding-abstract-class-properties-and-functions) |
|  | [Overriding Abstract Class Properties](#overriding-abstract-class-properties) |
|  | [Overriding Abstract Class Functions](#overriding-abstract-class-functions) |

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

## 6.2 Abstract Class Properties and Functions 
### Abstract Class Properties
```kotlin
abstract class Animal {

    var name: String = "Animal"
}

class Fish : Animal() {
}
```
```kotlin
val fish: Fish = Fish()
val name: String = fish.name
```

### Abstract Class Functions
```kotlin
abstract class Animal {

    fun move() {
        println("I am moving")
    }
}

class Fish : Animal() {
}
```
```kotlin
val fish: Fish = Fish()
fish.move()
```

<br />

## 6.3 Overriding Abstract Class Properties and Functions
### Overriding Abstract Class Properties
```kotlin
abstract class Animal {

    open var name: String = "Animal"
}

class Fish : Animal() {

    override var name: String = "Fish"
}
```
```kotlin
val fish: Fish = Fish()
val name: String = fish.name
```

### Overriding Abstract Class Functions
```kotlin
abstract class Animal {

    open fun move() {
        println("I am moving")
    }
}

class Fish : Animal() {

    override fun move() {
        println("I am swimming")
    }
}
```
```kotlin
val fish: Fish = Fish()
fish.move()
```

<br />
