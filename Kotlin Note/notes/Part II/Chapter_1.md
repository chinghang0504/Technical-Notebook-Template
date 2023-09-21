# [Kotlin Note](../../README.md) - Chapter 1 Classes
| Chapter | Title |
| :-: | :- |
| 1.1 | [Class Declaration](#11-class-declaration) |
| 1.2 | [Class Visibility Modifiers](#12-class-visibility-modifiers) |
| 1.3 | [Class Functions](#13-class-functions) |
|  | [Calling a Class Function](#calling-a-class-function) |
| 1.4 | [Class Properties](#14-class-properties) |
|  | [Geting a Class Property](#geting-a-class-property) |
|  | [Setting a Class Property](#setting-a-class-property) |
| 1.5 | [Custom Getters and Setters](#15-custom-getters-and-setters) |
|  | [Custom Getters](#custom-getters) |
|  | [Custom Setters](#custom-setters) |
|  | [Private Custom Setters](#private-custom-setters) |
| 1.6 | [Computed Properties](#16-computed-properties) |

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

## 1.2 Class Visibility Modifiers
- The defaul visibility modifier of classes is public.

| Visibility Modifier | Description |
| :-- | :-- |
| public | The function or property can be accessible outside the class. |
| private | The function or property can be accessible only within the same class. |
| protected | The function or property can be accessible only within the same class or its subclass. |
| internal | The function or property can be accessible only within the same module. | 

<br />

## 1.3 Class Functions
```kotlin
class Animal {

    fun move() {
        println("I am moving")
    }
}
```
```kotlin
val animal: Animal = Animal()
```

### Calling a Class Function
```kotlin
animal.move()
```

<br />

## 1.4 Class Properties
```kotlin
class Animal {

    var name: String = ""
}
```
```kotlin
val animal: Animal = Animal()
```

### Geting a Class Property
```kotlin
val name: String = animal.name
```

### Setting a Class Property
```kotlin
animal.name = "Animal"
```

<br />

## 1.5 Custom Getters and Setters
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

## 1.6 Computed Properties
```kotlin
class Animal {

    val name: String
        get() = Random.nextLong().toString()
}
```

<br />
