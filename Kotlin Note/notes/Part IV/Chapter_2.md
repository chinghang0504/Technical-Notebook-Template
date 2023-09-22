# [Kotlin Note](../../README.md) - Chapter 2 Objects
| Chapter | Title |
| :-: | :- |
| 2.1 | [Object Declaration](#21-object-declaration) |
| 2.2 | [Object Properties and Functions](#22-object-properties-and-functions) |
|  | [Object Properties](#object-properties) |
|  | [Object Functions](#object-functions) |
| 2.3 | [Object Initialize Block](#23-object-initialize-block) |
| 2.4 | [Object Expression Declaration](#24-object-expression-declaration) |
| 2.5 | [Object Expression Properties and Functions](#25-object-expression-properties-and-functions) |
|  | [Object Expression Properties](#object-expression-properties) |
|  | [Object Expression Functions](#object-expression-functions) |
| 2.6 | [Companion Objects Declaration](#26-companion-objects-declaration) |
| 2.7 | [Companion Objects Properties and Functions](#27-companion-objects-properties-and-functions) |
|  | [Companion Objects Properties](#companion-objects-properties) |
|  | [Companion Objects Functions](#companion-objects-functions) |

<br />

## 2.1 Object Declaration
```kotlin
object Earth {
}
```

<br />

## 2.2 Object Properties and Functions
### Object Properties
```kotlin
object Earth {
    
    var mass: Int = 0
}
```
```kotlin
val mass: Int = Earth.mass
```

### Object Functions
```kotlin
object Earth {

    fun printHelloWorld() {
        println("Hello World")
    }
}
```
```kotlin
Earth.printHelloWorld()
```

<br />

## 2.3 Object Initialize Block
```kotlin
object Earth {

    init {
        println("Executing an initialize block")
    }

    fun printHelloWorld() {
        println("Hello World")
    }
}
```
```kotlin
Earth.printHelloWorld()
```

<br />

## 2.4 Object Expression Declaration
```kotlin
open class Animal {
}
```
```kotlin
val bear = object : Animal() {
}
```

<br />

## 2.5 Object Expression Properties and Functions
```kotlin
open class Animal {
}
```

### Object Expression Properties
```kotlin
val bear = object : Animal() {

    var hungry: Int = 100
}
val hungry: Int = bear.hungry
```

### Object Expression Functions
```kotlin
val bear = object : Animal() {

    fun move() {
        println("I am catching fish")
    }
}
bear.move()
```

<br />

## 2.6 Companion Objects Declaration
```kotlin
class Animal {

    companion object {
    }
}
```

<br />

## 2.7 Companion Objects Properties and Functions
### Companion Objects Properties
```kotlin
class Animal {

    companion object {

        var num: Int = 0
    }
}
```
```kotlin
val num: Int = Animal.num
```

### Companion Objects Functions
```kotlin
class Animal {

    companion object {

        fun printHelloWorld() {
            println("Hello World")
        }
    }
}
```
```kotlin
Animal.printHelloWorld()
```

<br />
