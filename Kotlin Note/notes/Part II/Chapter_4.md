# [Kotlin Note](../../README.md) - Chapter 4 Operator Overloading
| Chapter | Title |
| :-: | :- |
| 4.1 | [Operator Overloading Summary](#41-operator-overloading-summary) |
|  | [Unary Operators](#unary-operators) |
|  | [Increments and Decrements](#increments-and-decrements) |
|  | [Binary Operators](#binary-operators) |
|  | [in Operator](#in-operator) |
|  | [Indexed Access Operators](#indexed-access-operators) |
|  | [Invoke Operator](#invoke-operator) |
|  | [Augmented Assignments](#augmented-assignments) |
|  | [Equality and Inequality Operators](#equality-and-inequality-operators) |
|  | [Comparison Operators](#comparison-operators) |
| 4.2 | [Operator Overloading Examples](#42-operator-overloading-examples) |
|  | [Unary Operator Overloading Example](#unary-operator-overloading-example) |
|  | [Increment and Decrement Overloading Example](#increment-and-decrement-overloading-example) |
|  | [Binary Operator Overloading Example](#binary-operator-overloading-example) |
|  | [in Operator Overloading Example](#in-operator-overloading-example) |
|  | [Indexed Access Operator Overloading Example](#indexed-access-operator-overloading-example) |
|  | [Invoke Operator Overloading Example](#invoke-operator-overloading-example) |
|  | [Augmented Assignment Overloading Example](#augmented-assignment-overloading-example) |
|  | [Equality and Inequality Operator Overloading Example](#equality-and-inequality-operator-overloading-example) |
|  | [Comparison Operator Overloading Example](#comparison-operator-overloading-example) |

<br />

## 4.1 [Operator Overloading Summary](https://kotlinlang.org/docs/operator-overloading.html)
### Unary Operators
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| + | unaryPlus | +a |
| - | unaryMinus | -a |
| ! | not | !a |

### Increments and Decrements
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| ++ | inc | a++ |
| -- | dec | a-- |

### Binary Operators
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| + | plus | a + b |
| - | minus | a - b |
| * | times | a * b |
| / | div | a / b |
| % | rem | a % b |
| .. | rangeTo | a .. b |
| ..< | rangeUntil | a ..< b |

### in Operator
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| in | contains | a in b |
| !in |  | a !in b |

### Indexed Access Operators
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| [] | get | a[i] |
| [] = | set | a[i] = b |

### Invoke Operator
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| () | invoke | a() |

### Augmented Assignments
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| += | plusAssign | a += b |
| -= | minusAssign | a -= b |
| *= | timesAssign | a *= b |
| /= | divAssign | a /= b |
| %= | remAssign | a %= b |

### Equality and Inequality Operators
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| == | equals | a == b |
| != |  | a != b |

### Comparison Operators
| Operator | Function Name | Expression |
| :-- | :-- | :-- |
| > | compareTo | a > b |
| < |  | a < b |
| >= |  | a >= b |
| <= |  | a <= b |

<br />

## 4.2 Operator Overloading Examples
### Unary Operator Overloading Example
```kotlin
class Box(var value: Int) {

    operator fun unaryPlus() : Box = Box(value)
    operator fun unaryMinus() : Box = Box(-value)
    operator fun not() : Box = Box(-value)

    override fun toString(): String {
        return "Box Value: $value"
    }
}
```
```kotlin
val box: Box = Box(10)

println(+box)
println(-box)
println(!box)
```

### Increment and Decrement Overloading Example
```kotlin
class Box(var value: Int) {

    operator fun inc() : Box = Box(value + 1)
    operator fun dec() : Box = Box(value - 1)

    override fun toString(): String {
        return "Box Value: $value"
    }
}
```
```kotlin
var box: Box = Box(10)

println(++box)
println(box++)
println(--box)
println(box--)
```

### Binary Operator Overloading Example
```kotlin
class Box(var value: Int) {

    operator fun plus(box: Box): Box = Box(value + box.value)
    operator fun minus(box: Box): Box = Box(value - box.value)
    operator fun times(box: Box): Box = Box(value * box.value)
    operator fun div(box: Box): Box = Box(value / box.value)
    operator fun rem(box: Box): Box = Box(value % box.value)

    operator fun rangeTo(box: Box): Box {
        val num1: Int = value + box.value
        val num2: Int = abs(value - box.value) + 1
        return Box(num1 * num2 / 2)
    }
    operator fun rangeUntil(box: Box): Box {
        val num1: Int = value + (box.value - 1)
        val num2: Int = abs(value - (box.value - 1)) + 1
        return Box(num1 * num2 / 2)
    }

    override fun toString(): String {
        return "Box Value: $value"
    }
}
```
```kotlin
val box1: Box = Box(1)
val box2: Box = Box(5)

println(box1 + box2)
println(box1 - box2)
println(box1 * box2)
println(box1 / box2)
println(box1 % box2)

println(box1 .. box2)
println(box1 ..< box2)
```

### in Operator Overloading Example
```kotlin
class Box(var value: Int) {

    override fun toString(): String {
        return "Box Value: $value"
    }
}

class Boxes(var boxList: List<Box>) {

    operator fun contains(box: Box): Boolean {
        boxList.forEach {
            if (it.value == box.value) return true
        }
        return false
    }

    override fun toString(): String {
        return boxList.toString()
    }
}
```
```kotlin
val box: Box = Box(1)
val boxes: Boxes = Boxes(listOf(Box(1), Box(2), Box(3)))

println(box in boxes)
println(box !in boxes)
```

### Indexed Access Operator Overloading Example
```kotlin
class Box(var value: Int) {

    override fun toString(): String {
        return "Box Value: $value"
    }
}

class Boxes(var boxList: MutableList<Box>) {

    operator fun get(i: Int): Box = boxList[i]
    operator fun set(i: Int, box: Box) { boxList[i] = box }

    override fun toString(): String {
        return boxList.toString()
    }
}
```
```kotlin
val box: Box = Box(1)
val boxes: Boxes = Boxes(mutableListOf(Box(3), Box(4), Box(5)))

println(boxes[0])
boxes[0] = box
```

### Invoke Operator Overloading Example
```kotlin
class Box(var value: Int) {

    override fun toString(): String {
        return "Box Value: $value"
    }
}

class Boxes(var boxList: List<Box>) {

    operator fun invoke(i: Int): Box = boxList[i]

    override fun toString(): String {
        return boxList.toString()
    }
}
```
```kotlin
val boxes: Boxes = Boxes(listOf(Box(1), Box(2), Box(3)))

println(boxes(0))
```

### Augmented Assignment Overloading Example
```kotlin
class Box(var value: Int) {

    operator fun plusAssign(box: Box) { value += box.value }
    operator fun minusAssign(box: Box) { value -= box.value }
    operator fun timesAssign(box: Box) { value *= box.value }
    operator fun divAssign(box: Box) { value /= box.value }
    operator fun remAssign(box: Box) { value %= box.value }

    override fun toString(): String {
        return "Box Value: $value"
    }
}
```
```kotlin
var box1: Box = Box(1)
var box2: Box = Box(5)

box1 += box2
println(box1)
box1 -= box2
println(box1)
box1 *= box2
println(box1)
box1 /= box2
println(box1)
box1 %= box2
println(box1)
```

### Equality and Inequality Operator Overloading Example
```kotlin
class Box(var value: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Box) return false

        return value == other.value
    }

    override fun toString(): String {
        return "Box Value: $value"
    }
}
```
```kotlin
val box1: Box = Box(1)
val box2: Box = Box(5)

println(box1 == box2)
println(box1 != box2)
```

### Comparison Operator Overloading Example
```kotlin
class Box(var value: Int) {

    operator fun compareTo(box: Box): Int = value - box.value

    override fun toString(): String {
        return "Box Value: $value"
    }
}
```
```kotlin
val box1: Box = Box(1)
val box2: Box = Box(5)

println(box1 > box2)
println(box1 < box2)
println(box1 >= box2)
println(box1 <= box2)
```

<br />
