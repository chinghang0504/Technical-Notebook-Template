# [Kotlin Note](../../README.md) - Chapter 2 Initialization
| Chapter | Title |
| :-: | :- |
| 2.1 | [Constructors](#21-constructors) |
|  | [Empty Constructor](#empty-constructor) |
|  | [Primary Constructor without Defining Properties](#primary-constructor-without-defining-properties) |
|  | [Primary Constructor with Defining Properties](#primary-constructor-with-defining-properties) |
|  | [Secondary Constructor without Calling a Primary Constructor](#secondary-constructor-without-calling-a-primary-constructor) |
|  | [Secondary Constructor with Calling a Primary Constructor](#secondary-constructor-with-calling-a-primary-constructor) |
|  | [Secondary Constructor with Calling a Secondary Constructor](#secondary-constructor-with-calling-a-secondary-constructor) |
| 2.2 | [Initializer Blocks](#22-initializer-blocks) |
|  | [Initializer Block with Assigning Properties](#initializer-block-with-assigning-properties) |
|  | [Initializer Block with Precondition Functions](#initializer-block-with-precondition-functions) |
| 2.3 | [Initialization Order](#23-initialization-order) |
| 2.4 | [Late Initialization](#24-late-initialization) |
| 2.5 | [Lazy Initialization](#25-lazy-initialization) |

<br />

## 2.1 Constructors
### Empty Constructor
```kotlin
class Animal {
}
```
```kotlin
val animal: Animal = Animal()
```

### Primary Constructor without Defining Properties
```kotlin
class Animal(initialMovingSpeed: Double) {

    var movingSpeed: Double = initialMovingSpeed
}
```
```kotlin
val animal: Animal = Animal(100.0)
```

### Primary Constructor with Defining Properties
```kotlin
class Animal(var movingSpeed: Double) {
}
```
```kotlin
val animal: Animal = Animal(100.0)
```

### Secondary Constructor without Calling a Primary Constructor
```kotlin
class Animal {

    var movingSpeed: Double

    constructor(initialMovingSpeed: Double) {
        movingSpeed = initialMovingSpeed
    }
}
```
```kotlin
val animal: Animal = Animal(100.0)
```

### Secondary Constructor with Calling a Primary Constructor
```kotlin
class Animal(initialMovingSpeed: Double, val name: String) {

    var movingSpeed: Double = initialMovingSpeed

    constructor(name: String) : this(0.0, name) {
        println("Calling a secondary constructor")
    }
}
```
```kotlin
val animal: Animal = Animal("Dog")
```

### Secondary Constructor with Calling a Secondary Constructor
```kotlin
class Animal(initialMovingSpeed: Double, val name: String) {

    var movingSpeed: Double = initialMovingSpeed

    constructor(name: String) : this(0.0, name)

    constructor() : this(0.0, "Unknown")
}
```
```kotlin
val animal: Animal = Animal()
```

<br />

## 2.2 Initializer Blocks
### Initializer Block with Assigning Properties
```kotlin
class Animal() {

    var movingSpeed: Double

    init {
        movingSpeed = 0.0
    }
}
```
```kotlin
val animal: Animal = Animal()
```

### Initializer Block with Precondition Functions
```kotlin
class Animal(initialMovingSpeed: Double) {

    var movingSpeed: Double = initialMovingSpeed

    init {
        require(movingSpeed >= 0.0)
    }
}
```
```kotlin
val animal: Animal = Animal(-1.0)
```

<br />

## 2.3 Initialization Order
### Using Empty Constructor
1. Assigning properties in the class
2. Executing an initializer block

### Using Primary Constructor
1. Assigning properties in the primary constructor
2. Assigning properties in the class
3. Executing an initializer block

### Using Secondary Constructor
1. Calling a primary constructor
2. Assigning properties in the primary constructor
3. Assigning properties in the class
4. Executing an initializer block
5. Executing a secondary constructor block

<br />

## 2.4 Late Initialization
- The limitations of late initialization
    1. can only be used with var properties
    2. cannot define a custom getter or setter
    3. cannot be the primitive types

```kotlin
class Animal() {

    lateinit var name: String
}
```
```kotlin
val animal: Animal = Animal()
```

<br />

## 2.5 Lazy Initialization
```kotlin
class Animal() {

    val name: String by lazy {
        println("Calling a lazy initialization")
        "Unknown"
    }
}
```
```kotlin
val animal: Animal = Animal()
animal.name
animal.name
```

<br />
