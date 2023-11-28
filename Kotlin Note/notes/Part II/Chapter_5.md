# [Kotlin Note](../../README.md) - Chapter 5 Interfaces
| Chapter | Title |
| :-: | :- |
| 5.1 | [Interface Declaration](#51-interface-declaration) |
| 5.2 | [Interface Property and Function Prototypes](#52-interface-property-and-function-prototypes) |
|  | [Interface Property Prototypes](#interface-property-prototypes) |
|  | [Interface Function Prototypes](#interface-function-prototypes) |
| 5.3 | [Default Interface Functions](#53-default-interface-functions) |
| 5.4 | [Overriding Interface Functions](#54-overriding-interface-functions) |

<br />

## 5.1 Interface Declaration
```kotlin
interface Attackable {
}

class Animal : Attackable {
}
```
```kotlin
val animal: Animal = Animal()
```

<br />

## 5.2 Interface Property and Function Prototypes
### Interface Property Prototypes
```kotlin
interface Attackable {
    
    var attack: Int
}

class Animal : Attackable {
    
    override var attack: Int = 0
}
```
```kotlin
val animal: Animal = Animal()
animal.attack = 100
```

### Interface Function Prototypes
```kotlin
interface Attackable {

    fun attack()
}

class Animal : Attackable {
    
    override fun attack() {
        println("I am attacking")
    }
}
```
```kotlin
val animal: Animal = Animal()
animal.attack()
```

<br />

## 5.3 Default Interface Functions
```kotlin
interface Attackable {

    fun attack() {
        println("I can't attack")
    }
}

class Animal : Attackable {
}
```
```kotlin
val animal: Animal = Animal()
animal.attack()
```

<br />

## 5.4 Overriding Interface Functions
```kotlin
interface Attackable {

    fun attack() {
        println("I can't attack")
    }
}

class Animal : Attackable {
    
    override fun attack() {
        println("I am attacking")
    }
}
```
```kotlin
val animal: Animal = Animal()
animal.attack()
```

<br />
