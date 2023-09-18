# [Kotlin Note](../../README.md) - Chapter 4 Operator Overloading
| Chapter | Title |
| :-: | :- |
| 4.1 | [Operators](#41-operators) |
|  | [Unary Operators](#unary-operators) |
|  | [Increments and Decrements](#increments-and-decrements) |
|  | [Binary Operators](#binary-operators) |
|  | [in Operators](#in-operators) |
|  | [Indexed Access Operators](#indexed-access-operators) |
|  | [Invoke Operator](#invoke-operator) |
|  | [Augmented Assignments](#augmented-assignments) |
|  | [Equality and Inequality Operators](#equality-and-inequality-operators) |
|  | [Comparison Operators](#comparison-operators) |
| 4.2 | [Overloading Operators](#42-overloading-operators) |
|  | [Overloading a Plus Operator](#overloading-a-plus-operator) |
|  | [Overloading a Minus Operator](#overloading-a-minus-operator) |
|  | [Overloading a Times Operator](#overloading-a-times-operator) |

<br />

## 4.1 Operators
### Unary Operators
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| + | unaryPlus | +a |
| - | unaryMinus | -a |
| ! | not | !a |

### Increments and Decrements
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| ++ | inc | a++ |
| -- | dec | a-- |

### Binary Operators
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| + | plus | a + b |
| - | minus | a - b |
| * | times | a * b |
| / | div | a / b |
| % | rem | a % b |
| .. | rangeTo | a .. b |
| ..< | rangeUntil | a ..< b |

### in Operators
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| in | contains | a in b |
| !in | contains | a !in b |

### Indexed Access Operators
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| [] | get | a[i] |
| [] = | set | a[i] = b |

### Invoke Operator
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| () | invoke | a() |

### Augmented Assignments
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| += | plusAssign | a += b |
| -= | minusAssign | a -= b |
| *= | timesAssign | a *= b |
| /= | divAssign | a /= b |
| %= | remAssign | a %= b |

### Equality and Inequality Operators
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| == | equals | a == b |
| != | equals | a != b |

### Comparison Operators
| Operator | Function Name | Example |
| :-- | :-- | :-- |
| > | compareTo | a > b |
| < | compareTo | a < b |
| >= | compareTo | a >= b |
| <= | compareTo | a <= b |

<br />

## 4.2 Overloading Operators
```kotlin
class Item(val value: Double) {

    operator fun plus(item: Item): Item {
        return Item(value + item.value)
    }

    operator fun minus(item: Item): Item {
        return Item(value + item.value)
    }

    operator fun times(num: Int): Item {
        return Item(value * num)
    }
}
```
```kotlin
val item1: Item = Item(100.0)
val item2: Item = Item(200.0)
```

### Overloading a Plus Operator
```kotlin
val item3: Item = item1 + item2
```

### Overloading a Minus Operator
```kotlin
val item3: Item = item1 - item2
```

### Overloading a Times Operator
```kotlin
val item3: Item = item1 * 3
```

<br />
