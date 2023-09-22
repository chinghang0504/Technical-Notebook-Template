# [Kotlin Note](../../README.md) - Chapter 8 Extensions
| Chapter | Title |
| :-: | :- |
| 8.1 | [Class Extension Functions](#81-class-extension-functions) |
| 8.2 | [Class Operator Extension Functions](#82-class-operator-extension-functions) |
| 8.3 | [Companion Object Operator Extension Functions](#83-companion-object-operator-extension-functions) |

<br />

## 8.1 Class Extension Functions
```kotlin
class Animal {
}

fun Animal.move() {
    println("I am moving")
}
```
```kotlin
val animal: Animal = Animal()
animal.move()
```

<br />

## 8.2 Class Operator Extension Functions
```kotlin
class Animal {
}

operator fun Animal.times(num: Int): MutableList<Animal> {
    require(num >= 0)

    val list: MutableList<Animal> = mutableListOf()
    for (i in 1 .. num) {
        list.add(Animal())
    }

    return list
}
```
```kotlin
val animal: Animal = Animal()
val list: MutableList<Animal> = animal * 3
```

<br />

## 8.3 Companion Object Operator Extension Functions
```kotlin
class Animal {

    companion object {
    }
}

operator fun Animal.Companion.times(num: Int): MutableList<Animal> {
    require(num >= 0)

    val list: MutableList<Animal> = mutableListOf()
    for (i in 1 .. num) {
        list.add(Animal())
    }

    return list
}
```
```kotlin
val list: MutableList<Animal> = Animal * 3
```

<br />
