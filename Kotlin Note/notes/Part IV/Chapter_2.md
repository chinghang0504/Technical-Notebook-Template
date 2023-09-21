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

    val animalList: List<Animal> = mutableListOf()
}
```
```kotlin
Earth.animalList.add(Animal())
```

### Object Functions
```kotlin
object Earth {

    fun printMessage() {
        println("Hello World")
    }
}
```
```kotlin
Earth.printMessage()
```

<br />

## 2.3 Object Initialize Block
```kotlin
object Earth {

    val animalList: MutableList<Animal>

    init {
        println("Executing an initialize block")
        animalList = mutableListOf(Animal(), Animal(), Animal())
    }
}
```

<br />

## 2.4 Object Expression Declaration
```kotlin
val bear = object: Animal() {
}
```

<br />

## 2.5 Object Expression Properties and Functions
```kotlin
open class Animal {

    open fun move() {
        println("I am moving")
    }
}
```

### Object Expression Properties
```kotlin
val bear = object: Animal() {
    
    var hungry: Int = 100
}
    
val hungry: Int = bear.hungry
```

### Object Expression Functions
```kotlin
val bear = object: Animal() {

    override fun move() {
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

        var animalSize: Int = 0
    }
}
```
```kotlin
val animalSize: Int = Animal.animalSize
```

### Companion Objects Functions
```kotlin
class Animal {

    companion object {

        fun sayHello() {
            println("Hello")
        }
    }
}
```
```kotlin
Animal.sayHello()
```

<br />
