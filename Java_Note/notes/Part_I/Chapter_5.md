# [Java Note](../../README.md) - Chapter 5 Operators
| Chapter | Title |
| :- | :- |
| 5.1 | [Arithmetic Operators](#51-arithmetic-operators) |
| 5.1.1 | [Arithmetic Assignment Operators](#511-arithmetic-assignment-operators) |
| 5.1.2 | [Increment and Decrement](#512-increment-and-decrement) |
| 5.2 | [Bitwise Operators](#52-bitwise-operators) |
| 5.2.1 | [Bitwise Assignment Operators](#521-bitwise-assignment-operators) |
| 5.2.2 | [Unary Bitwise Operators](#522-unary-bitwise-operators) |
| 5.3 | [Relational Operators](#53-relational-operators) |
| 5.4 | [Logical Operators](#54-logical-operators) |
| 5.4.1 | [Logical Assignment Operators](#541-logical-assignment-operators) |
| 5.4.2 | [Unary Logical Operators](#542-unary-logical-operators) |
| 5.5 | [Assignment Operators](#55-assignment-operators) |
| 5.6 | [?: Operator](#56--operator) |
| 5.7 | [Parentheses](#57-parentheses) |
| 5.8 | [Operator Precedence](#58-operator-precedence) |

<br>

## 5.1 Arithmetic Operators
| Operator | Description |
| :- | :- |
| + | Addition |
| - | Subtraction |
| * | Multiplication |
| / | Division |
| % | Modulus |

<br>

### 5.1.1 Arithmetic Assignment Operators
| Operator | Description |
| :- | :- |
| += | Addition assignment |
| -= | Subtraction assignment |
| *= | Multiplication assignment |
| /= | Division assignment |
| %= | Modulus assignment |

<br>

## 5.1.2 Increment and Decrement
| Operator | Description | Expression |
| :- | :- | :- |
| ++ | Prefix increment | ++x |
| ++ | Postfix increment | x++ |
| -- | Prefix decrement | --x |
| -- | Postfix decrement | x-- |

<br>

## 5.2 Bitwise Operators
| Operator | Description |
| :- | :- |
| & | Bitwise and |
| \| | Bitwise or |
| ^ | Bitwise xor |
| << | Left shift |
| >> | Arithmetic right shift |
| >>> | Logical right shift |

<br>

### 5.2.1 Bitwise Assignment Operators
| Operator | Description |
| :- | :- |
| &= | Bitwise and assignment |
| \|= | Bitwise or assignment |
| ^= | Bitwise xor assignment |
| <<= | Left shift assignment |
| >>= | Arithmetic right shift assignment |
| >>>= | Logical right shift assignment |

<br>

### 5.2.2 Unary Bitwise Operators
| Operator | Description |
| :- | :- |
| ~ | Bitwise not |

<br>

## 5.3 Relational Operators
| Operator | Description |
| :- | :- |
| == | Equal to |
| != | Not equal to |
| > | Greater than |
| < | Less than |
| >= | Greater than or equal to |
| <= | Less than or equal to |

<br>

## 5.4 Logical Operators
| Operator | Description |
| :- | :- |
| && | Short-circuit logical and |
| \|\| | Short-circuit logical or |
| & | Logical and |
| \| | Logical or |
| ^ | Logical xor |

<br>

### 5.4.1 Logical Assignment Operators
| Operator | Description |
| :- | :- |
| &= | Logical and assignment |
| \|= | Logical or assignment |
| ^= | Logical xor assignment |

<br>

### 5.4.2 Unary Logical Operators
| Operator | Description |
| :- | :- |
| ! | Logical not |

<br>

## 5.5 Assignment Operators
| Operator | Description |
| :- | :- |
| = | Assignment |

<br>

## 5.6 ?: Operator
```java
variable = boolean_expression ? true_expression : false_expression;
```

<br>

## 5.7 Parentheses
```java
int a = (5 + 7) * 2;
```

<br>

## 5.8 Operator Precedence
| Precedence | Operators |
| :- | :- |
| Highest | ++ (postfix), --(postfix) |
|  | ++ (prefix), --(prefix), ~, !, + (unary), - (unary), (type-case) |
|  | *, /, % |
|  | +, - |
|  | <<, >>, >>> |
|  | >, >=, <, <=, instanceof |
|  | ==, != |
|  | & |
|  | ^ |
|  | \| |
|  | && |
|  | \|\| |
|  | ?: |
|  | -> |
| Lowest | =, op= |

<br>
