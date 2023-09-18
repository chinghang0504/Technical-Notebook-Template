# [Kotlin Note](../../README.md) - Chapter 1 Objects
| Chapter | Title |
| :-: | :- |
| 1.1 | [Object Declaration](#11-object-declaration) |
| 1.2 | [Object Properties and Methods](#12-object-properties-and-methods) |
|  | [Accessing Object Properties](#accessing-object-properties) |
|  | [Calling Object Methods](#calling-object-methods) |
| 1.3 | [Object Initialize Block](#13-object-initialize-block) |
| 1.4 | [Object Expression Declaration](#14-object-expression-declaration) |
| 1.5 | [Object Expression Methods](#15-object-expression-methods) |
|  | [Calling Object Expression Methods](#calling-object-expression-methods) |
| 1.6 | [Companion Objects](#16-companion-objects) |
|  | [Accessing Componion Object Properties](#accessing-componion-object-properties) |
|  | [Calling Componion Object Methods](#calling-componion-object-methods) |

<br />

## 1.1 Object Declaration
```kotlin
object Earth {
}
```

<br />

## 1.2 Object Properties and Methods
```kotlin
object Earth {

    val animalList: MutableList<Animal> = mutableListOf()

    fun printAnimalNumber() {
        println("Number of animals: ${animalList.size}")
    }
}
```

### Accessing Object Properties
```kotlin
val fish: Fish = Fish()
Earth.animalList.add(fish)
```

### Calling Object Methods
```kotlin
Earth.printAnimalNumber()
```

<br />

## 1.3 Object Initialize Block
```kotlin
object Earth {

    val animalList: MutableList<Animal>

    init {
        animalList = mutableListOf(Fish(), Fish(), Fish())
    }

    fun printAnimalNumber() {
        println("Number of animals: ${animalList.size}")
    }
}
```

<br />

## 1.4 Object Expression Declaration
```kotlin
val panda = object : Animal() {
}
```

<br />

## 1.5 Object Expression Methods
```kotlin
val panda = object : Animal() {

    override fun move() {
        println("I am running")
    }
}
```

### Calling Object Expression Methods
```kotlin
panda.move()
```

<br />

## 1.6 Companion Objects
```kotlin
class Fish : Animal() {

    companion object {
        var livingPlace: String = "sea"

        fun printLivingPlace() {
            println("I am living in the $livingPlace")
        }
    }
}
```

### Accessing Componion Object Properties
```kotlin
println(Fish.livingPlace)
```

### Calling Componion Object Methods
```kotlin
Fish.printLivingPlace()
```

<br />
