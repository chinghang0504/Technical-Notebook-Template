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
|  | [Assigning Properties in the Initializer Block](#assigning-properties-in-the-initializer-block) |
|  | [Calling Precondition Functions in the Initializer Block](#calling-precondition-functions-in-the-initializer-block) |
| 2.3 | [Initialization Order](#23-initialization-order) |
|  | [Using Empty Constructor](#using-empty-constructor) |
|  | [Using Primary Constructor](#using-primary-constructor) |
|  | [Using Secondary Constructor without Calling a Primary Constructor](#using-secondary-constructor-without-calling-a-primary-constructor) |
|  | [Using Secondary Constructor with Calling a Primary Constructor](#using-secondary-constructor-with-calling-a-primary-constructor) |
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
class Animal(name: String) {
}
```
```kotlin
val animal: Animal = Animal("Animal")
```

### Primary Constructor with Defining Properties
```kotlin
class Animal(var name: String) {
}
```
```kotlin
val animal: Animal = Animal("Animal")
val name: String = animal.name
```

### Secondary Constructor without Calling a Primary Constructor
```kotlin
class Animal {

    var name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
```
```kotlin
val animal: Animal = Animal("Animal", 10)
val name: String = animal.name
val age: Int = animal.age
```

### Secondary Constructor with Calling a Primary Constructor
```kotlin
class Animal(var name: String) {

    var age: Int = 0

    constructor(name: String, age: Int): this(name) {
        this.age = age
    }
}
```
```kotlin
val animal: Animal = Animal("Animal", 10)
val name: String = animal.name
val age: Int = animal.age
```

### Secondary Constructor with Calling a Secondary Constructor
```kotlin
class Animal(var name: String) {

    var age: Int = 0

    constructor(name: String, age: Int): this(name) {
        this.age = age
    }

    constructor(): this("Animal", 0) {
    }
}
```
```kotlin
val animal: Animal = Animal()
val name: String = animal.name
val age: Int = animal.age
```

<br />

## 2.2 Initializer Blocks
### Assigning Properties in the Initializer Block
```kotlin
class Animal {

    var name: String

    init {
        name = "Animal"
    }
}
```
```kotlin
val animal: Animal = Animal()
val name: String = animal.name
```

### Calling Precondition Functions in the Initializer Block
```kotlin
class Animal(var age: Int) {

    init {
        require(age >= 0)
    }
}
```
```kotlin
val animal: Animal = Animal(-1)
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

### Using Secondary Constructor without Calling a Primary Constructor
1. Assigning properties in the class
2. Executing an initializer block
3. Executing a secondary constructor block

### Using Secondary Constructor with Calling a Primary Constructor
1. Calling a primary constructor
2. Assigning properties in the primary constructor
3. Assigning properties in the class
4. Executing an initializer block
5. Executing a secondary constructor block

<br />

## 2.4 Late Initialization
- The limitations of late initialization
    1. Can only be used with var properties
    2. Cannot define a custom getter or setter
    3. Cannot be the primitive types

```kotlin
class Animal {

    lateinit var name: String
}
```
```kotlin
val animal: Animal = Animal()
animal.name = "Animal"
```

<br />

## 2.5 Lazy Initialization
```kotlin
class Animal {

    val name: String by lazy {
        println("Calling a lazy initialization")
        Random.nextLong().toString()
    }
}
```
```kotlin
val animal: Animal = Animal()
val name: String = animal.name
```

<br />
