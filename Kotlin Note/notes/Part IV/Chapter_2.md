# [Kotlin Note](../../README.md) - Chapter 2 Objects
| Chapter | Title |
| :-: | :- |
| 2.1 | [Object Declaration](#21-object-declaration) |
| 2.2 | [Object Properties and Methods](#22-object-properties-and-methods) |
|  | [Accessing Object Properties](#accessing-object-properties) |
|  | [Calling Object Methods](#calling-object-methods) |
| 2.3 | [Object Initialize Block](#23-object-initialize-block) |
| 2.4 | [Object Expression Declaration](#24-object-expression-declaration) |
| 2.5 | [Object Expression Methods](#25-object-expression-methods) |
|  | [Calling Object Expression Methods](#calling-object-expression-methods) |
| 2.6 | [Companion Objects](#26-companion-objects) |
|  | [Accessing Componion Object Properties](#accessing-componion-object-properties) |
|  | [Calling Componion Object Methods](#calling-componion-object-methods) |

<br />

## 2.1 Object Declaration
```kotlin
object Earth {
}
```

<br />

## 2.2 Object Properties and Methods
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

## 2.3 Object Initialize Block
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

## 2.4 Object Expression Declaration
```kotlin
val panda = object : Animal() {
}
```

<br />

## 2.5 Object Expression Methods
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

## 2.6 Companion Objects
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
