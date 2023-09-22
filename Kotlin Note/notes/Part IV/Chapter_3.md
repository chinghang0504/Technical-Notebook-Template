# [Kotlin Note](../../README.md) - Chapter 3 Nested and Inner Classes
| Chapter | Title |
| :-: | :- |
| 3.1 | [Nested Class Declaration](#31-nested-class-declaration) |
| 3.2 | [Nested Class Properties and Functions](#32-nested-class-properties-and-functions) |
|  | [Nested Class Properties](#nested-class-properties) |
|  | [Nested Class Functions](#nested-class-functions) |
| 3.3 | [Inner Class Declaration](#33-inner-class-declaration) |
| 3.4 | [Inner Class Properties and Functions](#34-inner-class-properties-and-functions) |
|  | [Inner Class Properties](#inner-class-properties) |
|  | [Inner Class Functions](#inner-class-functions) |

<br />

## 3.1 Nested Class Declaration
```kotlin
class Animal {

    class Body {
    }
}
```
```kotlin
val animalBody: Animal.Body = Animal.Body()
```

<br />

## 3.2 Nested Class Properties and Functions
### Nested Class Properties
```kotlin
class Animal {
    
    class Body {

        var health: Int = 0
    }
}
```
```kotlin
val animalBody: Animal.Body = Animal.Body()
val health: Int = animalBody.health
```

### Nested Class Functions
```kotlin
class Animal {

    class Body {

        fun printHelloWorld() {
            println("Hello World")
        }
    }
}
```
```kotlin
val animalBody: Animal.Body = Animal.Body()
animalBody.printHelloWorld()
```

<br />

## 3.3 Inner Class Declaration
```kotlin
class Animal {

    inner class Body {
    }
}
```
```kotlin
val animal: Animal = Animal()
val animalBody: Animal.Body = animal.Body()
```

<br />

## 3.4 Inner Class Properties and Functions
### Inner Class Properties
```kotlin
class Animal {

    inner class Body {

        var health: Int = 0
    }
}
```
```kotlin
val animal: Animal = Animal()
val animalBody: Animal.Body = animal.Body()
val health: Int = animalBody.health
```

### Inner Class Functions
```kotlin
class Animal {

    var name: String = "Animal"

    inner class Body {

        fun printName() {
            println("Name: $name")
        }
    }
}
```
```kotlin
val animal: Animal = Animal()
val animalBody: Animal.Body = animal.Body()
animalBody.printName()
```

<br />
