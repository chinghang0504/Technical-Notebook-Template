# [Kotlin Note](../../README.md) - Chapter 1 Classes
| Chapter | Title |
| :-: | :- |
| 1.1 | [Class Declaration](#11-class-declaration) |
| 1.2 | [Class Functions](#12-class-functions) |
| 1.3 | [Class Properties](#13-class-properties) |
| 1.4 | [Custom Getters and Setters](#14-custom-getters-and-setters) |
|  | [Custom Getters](#custom-getters) |
|  | [Custom Setters](#custom-setters) |
|  | [Private Custom Setters](#private-custom-setters) |
| 1.5 | [Computed Properties](#15-computed-properties) |
| 1.6 | [Class Visibility Modifiers](#16-class-visibility-modifiers) |
| 1.7 | [Class Property and Function Visibility Modifiers](#17-class-property-and-function-visibility-modifiers) |

<br />

## 1.1 Class Declaration
```kotlin
class Animal {
}
```
```kotlin
val animal: Animal = Animal()
```

<br />

## 1.2 Class Functions
```kotlin
class Animal {

    fun move() {
        println("I am moving")
    }
}
```
```kotlin
val animal: Animal = Animal()
animal.move()
```

<br />

## 1.3 Class Properties
```kotlin
class Animal {

    var name: String = ""
}
```
```kotlin
val animal: Animal = Animal()
val name: String = animal.name
```

<br />

## 1.4 Custom Getters and Setters
### Custom Getters
```kotlin
class Animal {

    var name: String = ""
        get() = field.uppercase()
}
```
```kotlin
class Animal {

    var name: String = ""
        get() {
            return field.uppercase()
        }
}
```

### Custom Setters
```kotlin
class Animal {

    var name: String = ""
        set(value) {
            field = value.lowercase()
        }
}
```

### Private Custom Setters
```kotlin
class Animal {

    var name: String = ""
        private set(value) {
            field = value.lowercase()
        }
}
```
```kotlin
class Animal {

    var name: String = ""
        private set
}
```

<br />

## 1.5 Computed Properties
```kotlin
class Animal {

    val name: String
        get() = Random.nextLong().toString()
}
```

<br />

## 1.6 Class Visibility Modifiers
- The defaul visibility modifier of classes is public.

| Visibility Modifier | Description |
| :-- | :-- |
| public | The class can be accessible outside the file. |
| private | The class can be accessible only within the same file. |
| internal | The class can be accessible only within the same module. |

<br />

## 1.7 Class Property and Function Visibility Modifiers
- The defaul visibility modifier of class properties and functions is public.

| Visibility Modifier | Description |
| :-- | :-- |
| public | The function or property can be accessible outside the class. |
| private | The function or property can be accessible only within the same class. |
| protected | The function or property can be accessible only within the same class or its subclass. |
| internal | The function or property can be accessible only within the same module. |

<br />
