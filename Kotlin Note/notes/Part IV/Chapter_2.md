# [Kotlin Note](../../README.md) - Chapter 2 Nested Classes
| Chapter | Title |
| :-: | :- |
| 2.1 | [Nested Class Declaration](#21-nested-class-declaration) |
| 2.2 | [Nested Class Properties and Methods](#22-nested-class-properties-and-methods) |
|  | [Accessing Nested Class Properties](#accessing-nested-class-properties) |
|  | [Calling Nested Class Methods](#calling-nested-class-methods) |

<br />

## 2.1 Nested Class Declaration
```kotlin
class Animal {

    class Body {
    }
}
```
```kotlin
val animalBody: Animal.Body = Animal.Body()
```

## 2.2 Nested Class Properties and Methods
```kotlin
class Animal {

    class Body {

        var health: Double = 0.0

        fun printlnHealth() {
            println("Health: $health")
        }
    }

    var body: Body = Body()
}
```
```kotlin
val animal: Animal = Animal()
```

### Accessing Nested Class Properties
```kotlin
animal.body.health = 100.0
```

### Calling Nested Class Methods
```kotlin
animal.body.printlnHealth()
```

<br />
