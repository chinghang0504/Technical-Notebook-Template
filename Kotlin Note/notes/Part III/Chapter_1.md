# [Kotlin Note](../../README.md) - Chapter 1 Classes
| Chapter | Title |
| :-: | :- |
| 1.1 | [Class Declaration](#11-class-declaration) |
| 1.2 | [Creating an Instance of a Class](#12-creating-an-instance-of-a-class) |
| 1.3 | [Class Visibility](#13-class-visibility) |
| 1.4 | [Class Methods](#14-class-methods) |
| 1.5 | [Class Properties](#15-class-properties) |
|  | [Get a Class Property](#get-a-class-property) |
|  | [Set a Class Property](#set-a-class-property) |
| 1.6 | [Custom Getters and Setters](#16-custom-getters-and-setters) |
|  | [Custom Getters](#custom-getters) |
|  | [Custom Setters](#custom-setters) |
|  | [Private Custom Setters](#private-custom-setters) |
| 1.7 | [Computed Properties](#17-computed-properties) |

<br />

## 1.1 Class Declaration
```kotlin
class Animal {
}
```

<br />

## 1.2 Creating an Instance of a Class
```kotlin
val animal: Animal = Animal()
```

<br />

## 1.3 Class Visibility
- The defaul modifier is public.

| Modifier | Description |
| :-- | :-- |
| public | The function or property can be accessible outside the class. |
| private | The function or property can be accessible only within the same class. |
| protected | The function or property can be accessible only within the same class or its subclass. |
| internal | The function or property can be accessible only within the same module. | 

<br />

## 1.4 Class Methods
```kotlin
class Animal {

    fun move() {
        println("I am moving")
    }
}
```
```kotlin
animal.move()
```

<br />

## 1.5 Class Properties
```kotlin
class Animal {

    var movingSpeed: Double = 0.0

    fun move() {
        println("I am moving")
    }
}
```

### Get a Class Property
```kotlin
val movingSpeed: Double = animal.movingSpeed
```

### Set a Class Property
```kotlin
animal.movingSpeed = 20.0
```

<br />

## 1.6 Custom Getters and Setters
### Custom Getters
```kotlin
class Animal {

    var movingSpeed: Double = 0.0
        get() = field * 0.621371

    fun move() {
        println("I am moving")
    }
}
```
```kotlin
class Animal {

    var movingSpeed: Double = 0.0
        get() {
            return field * 0.621371
        }
    
    fun move() {
        println("I am moving")
    }
}
```

### Custom Setters
```kotlin
class Animal {

    var movingSpeed: Double = 0.0
        set(value) {
            field = value / 0.621371
        }

    fun move() {
        println("I am moving")
    }
}
```

### Private Custom Setters
```kotlin
class Animal {

    var movingSpeed: Double = 0.0
        get() = field * 0.621371
        private set(value) {
            field = value / 0.621371
        }

    fun move() {
        println("I am moving")
    }
}
```
```kotlin
class Animal {

    var movingSpeed: Double = 0.0
        get() = field * 0.621371
        private set

    fun move() {
        println("I am moving")
    }
}
```

<br />

## 1.7 Computed Properties
```kotlin
class Animal {

    var movingSpeed: Double = 0.0
        get() = field * 0.621371
        set(value) {
            field = value / 0.621371
        }

    val attackDamage: Double
        get() = 10.0 + movingSpeed * 100

    fun move() {
        println("I am moving")
    }
}
```

<br />
