# [Kotlin Note](../../README.md) - Chapter 9 Objects
| Chapter | Title |
| :-: | :- |
| 9.1 | [Object Declaration](#91-object-declaration) |
| 9.2 | [Object Properties and Functions](#92-object-properties-and-functions) |
|  | [Object Properties](#object-properties) |
|  | [Object Functions](#object-functions) |
| 9.3 | [Object Initialize Block](#93-object-initialize-block) |
| 9.4 | [Object Expression Declaration](#94-object-expression-declaration) |
| 9.5 | [Object Expression Properties and Functions](#95-object-expression-properties-and-functions) |
|  | [Object Expression Properties](#object-expression-properties) |
|  | [Object Expression Functions](#object-expression-functions) |
| 9.6 | [Companion Objects Declaration](#96-companion-objects-declaration) |
| 9.7 | [Companion Objects Properties and Functions](#97-companion-objects-properties-and-functions) |
|  | [Companion Objects Properties](#companion-objects-properties) |
|  | [Companion Objects Functions](#companion-objects-functions) |

<br />

## 9.1 Object Declaration
```kotlin
object Earth {
}
```

<br />

## 9.2 Object Properties and Functions
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

## 9.3 Object Initialize Block
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

## 9.4 Object Expression Declaration
```kotlin
open class Animal {
}
```
```kotlin
val bear = object : Animal() {
}
```

<br />

## 9.5 Object Expression Properties and Functions
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

## 9.6 Companion Objects Declaration
```kotlin
class Animal {

    companion object {
    }
}
```

<br />

## 9.7 Companion Objects Properties and Functions
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
