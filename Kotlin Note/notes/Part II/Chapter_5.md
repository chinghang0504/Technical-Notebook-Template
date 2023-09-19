# [Kotlin Note](../../README.md) - Chapter 5 Interfaces
| Chapter | Title |
| :-: | :- |
| 5.1 | [Interface Declaration](#51-interface-declaration) |
| 5.2 | [Interface Properties and Methods](#52-interface-properties-and-methods) |
|  | [Accessing Interface Properties](#accessing-interface-properties) |
|  | [Calling Interface Methods](#calling-interface-methods) |
| 5.3 | [Default Interface Methods](#53-default-interface-methods) |
|  | [Calling Default Interface Methods](#calling-default-interface-methods) |

<br />

## 5.1 Interface Declaration
```kotlin
interface AttackAbility {
}

class Animal : AttackAbility {
}
```
```kotlin
val animal: Animal = Animal()
```

<br />

## 5.2 Interface Properties and Methods
```kotlin
interface AttackAbility {

    var damage: Int

    fun attack()
}

class Animal : AttackAbility {
    
    override var damage: Int = 0

    override fun attack() {
        println("I am attacking with damage $damage")
    }
}
```
```kotlin
val animal: Animal = Animal()
```

### Accessing Interface Properties
```kotlin
animal.damage = 100
```

### Calling Interface Methods
```kotlin
animal.attack()
```

<br />

## 5.3 Default Interface Methods
```kotlin
interface AttackAbility {

    fun attack() {
        println("I am attacking with no damage")
    }
}

class Animal : AttackAbility {
}
```
```kotlin
val animal: Animal = Animal()
```

### Calling Default Interface Methods
```kotlin
animal.attack()
```

<br />
