# [Kotlin Note](../../README.md) - Chapter 3 Inheritance
| Chapter | Title |
| :-: | :- |
| 3.1 | [Subclass Declaration](#31-subclass-declaration) |
| 3.2 | [Inheritance Superclass Properties and Functions](#32-inheritance-superclass-properties-and-functions) |
|  | [Inheritance Superclass Properties](#inheritance-superclass-properties) |
|  | [Inheritance Superclass Functions](#inheritance-superclass-functions) |
| 3.3 | [Overriding Superclass Properties and Functions](#33-overriding-superclass-properties-and-functions) |
|  | [Overriding Superclass Properties](#overriding-superclass-properties) |
|  | [Overriding Superclass Functions](#overriding-superclass-functions) |
| 3.4 | [Preventing Superclass Property and Function Override](#34-preventing-superclass-property-and-function-override) |
|  | [Preventing Superclass Property Override](#preventing-superclass-property-override) |
|  | [Preventing Superclass Function Override](#preventing-superclass-function-override) |
| 3.5 | [super Keyword](#35-super-keyword) |
|  | [Calling Superclass Functions](#calling-superclass-functions) |
| 3.6 | [Type Checking](#36-type-checking) |
|  | [Using is Keyword](#using-is-keyword) |
| 3.7 | [Type Casting](#37-type-casting) |
|  | [Using as Keyword](#using-as-keyword) |
|  | [Using as Keyword and Safe Call Operator ?](#using-as-keyword-and-safe-call-operator) |
| 3.8 | [Smart Casting](#38-smart-casting) |

<br />

## 3.1 Subclass Declaration
```kotlin
open class Animal {
}

class Fish : Animal() {
}
```
```kotlin
val fish: Fish = Fish()
```

<br />

## 3.2 Inheritance Superclass Properties and Functions
### Inheritance Superclass Properties
```kotlin
open class Animal {

    var name: String = "Animal"
}

class Fish : Animal() {
}
```
```kotlin
val fish: Fish = Fish()
val name: String = fish.name
```

### Inheritance Superclass Functions
```kotlin
open class Animal {

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

## 3.3 Overriding Superclass Properties and Functions
### Overriding Superclass Properties
```kotlin
open class Animal {

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

### Overriding Superclass Functions
```kotlin
open class Animal {

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

## 3.4 Preventing Superclass Property and Function Override
### Preventing Superclass Property Override
```kotlin
open class Animal {

    final var name: String = "Animal"
}

class Fish : Animal() {
}
```
```kotlin
val fish: Fish = Fish()
val name: String = fish.name
```

### Preventing Superclass Function Override
```kotlin
open class Animal {

    final fun move() {
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

## 3.5 super Keyword
### Calling Superclass Functions
```kotlin
open class Animal {

    open fun move() {
        println("I am moving")
    }
}

class Fish : Animal() {

    override fun move() {
        println("Calling move() from Fish")
        super.move()
    }
}
```
```kotlin
val fish: Fish = Fish()
fish.move()
```

<br />

## 3.6 Type Checking
### Using is Keyword
```kotlin
open class Animal {
}

class Fish : Animal() {
}
```
```kotlin
val animal: Animal = Animal()
val fish: Fish = Fish()

println(animal is Animal)       // true
println(animal is Fish)         // false

println(fish is Animal)         // true
println(fish is Fish)           // true
```

<br />

## 3.7 Type Casting
```kotlin
open class Animal {
}

class Fish : Animal() {

    fun swim() {
        println("I am swimming")
    }
}
```

### Using as Keyword
```kotlin
val animal: Animal = Fish()
(animal as Fish).swim()
```

### Using as Keyword and Safe Call Operator ?
```kotlin
val animal: Animal = Fish()
(animal as? Fish)?.swim()
```

<br />

## 3.8 Smart Casting
```kotlin
open class Animal {
}

class Fish : Animal() {

    fun swim() {
        println("I am swimming")
    }
}
```
```kotlin
val animal: Animal = Fish()
if (animal is Fish) {
    animal.swim()
}
```

<br />
