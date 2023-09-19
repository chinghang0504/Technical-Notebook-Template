# [Kotlin Note](../../README.md) - Chapter 3 Inheritance
| Chapter | Title |
| :-: | :- |
| 3.1 | [Subclass Declaration](#31-subclass-declaration) |
| 3.2 | [Inheritance from Superclass](#32-inheritance-from-superclass) |
|  | [Accessing Superclass Properties](#accessing-superclass-properties) |
|  | [Accessing Subclass Properties](#accessing-subclass-properties) |
|  | [Calling Superclass Methods](#calling-superclass-methods) |
|  | [Calling Subclass Methods](#calling-subclass-methods) |
| 3.3 | [Overriding Superclass Properties and Methods](#33-overriding-superclass-properties-and-methods) |
|  | [Accessing Override Properties](#accessing-override-properties) |
|  | [Calling Override Methods](#calling-override-methods) |
| 3.4 | [Preventing Superclass Property and Method Override](#34-preventing-superclass-property-and-method-override) |
| 3.5 | [Type Checking](#35-type-checking) |
|  | [Using is Keyword](#using-is-keyword) |
| 3.6 | [Type Casting](#36-type-casting) |
|  | [Using as Keyword](#using-as-keyword) |
|  | [Using as Keyword and the Safe Case Operator](#using-as-keyword-and-the-safe-case-operator) |

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

## 3.2 Inheritance from Superclass
```kotlin
open class Animal {

    var name: String = ""

    fun move() {
        println("I am moving")
    }
}

class Fish : Animal() {

    var swimmingSpeed: Double = 0.0

    fun swim() {
        println("I am swimming")
    }
}
```
```kotlin
val fish: Fish = Fish()
```

### Accessing Superclass Properties
```kotlin
fish.name = "Fish"
```

### Accessing Subclass Properties
```kotlin
fish.swimmingSpeed = 10.0
```

### Calling Superclass Methods
```kotlin
fish.move()
```

### Calling Subclass Methods
```kotlin
fish.swim()
```

<br />

## 3.3 Overriding Superclass Properties and Methods
```kotlin
open class Animal {

    var name: String = ""
    open var movingSpeed: Double = 0.0

    open fun move() {
        println("I am moving")
    }
}

class Fish : Animal() {

    override var movingSpeed: Double = 10.0

    override fun move() {
        println("I am swimming")
    }
}
```
```kotlin
val fish: Fish = Fish()
```

### Accessing Override Properties
```kotlin
fish.movingSpeed = 100.0
```

### Calling Override Methods
```kotlin
fish.move()
```

<br />

## 3.4 Preventing Superclass Property and Method Override
```kotlin
open class Animal {

    var name: String = ""
    final var movingSpeed: Double = 0.0

    final fun move() {
        println("I am moving")
    }
}

class Fish : Animal() {
}
```

<br />

## 3.5 Type Checking
### Using is Keyword
```kotlin
println(fish is Fish)       // true
println(fish is Animal)     // true
```

<br />

## 3.6 Type Casting
```kotlin
open class Animal {

    var name: String = ""
}

class Fish : Animal() {

    var swimmingSpeed: Double = 0.0
}
```
```kotlin
val animal: Animal = Fish()
```

### Using as Keyword
```kotlin
(animal as Fish).swimmingSpeed = 10.0
```

### Using as Keyword and the Safe Case Operator
```kotlin
(animal as? Fish)?.swimmingSpeed = 10.0
```

<br />
