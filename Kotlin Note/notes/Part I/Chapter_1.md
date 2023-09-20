# [Kotlin Note](../../README.md) - Chapter 1 Basics
| Chapter | Title |
| :-: | :- |
| 1.1 | [Comments](#11-comments) |
|  | [Single-line Comments](#single-line-comments) |
|  | [Multi-line Comments](#multi-line-comments) |
| 1.2 | [main Function](#12-main-function) |
| 1.3 | [Keywords and Operators](#13-keywords-and-operators) |
|  | [Hard Keywords](#hard-keywords) |
|  | [Soft Keywords](#soft-keywords) |
|  | [Modifier Keywords](#modifier-keywords) |
|  | [Special Identifiers](#special-identifiers) |
|  | [Operators and Special Symbols](#operators-and-special-symbols) |
| 1.4 | [Operator Precedence](#14-operator-precedence) |

<br />

## 1.1 Comments
### Single-line Comments
```kotlin
// This is a comment
```

### Multi-line Comments
```kotlin
/*
    This is a comment
 */
```

<br />

## 1.2 main Function
```kotlin
fun main(args: Array<String>) {

}
```

<br />

## 1.3 [Keywords and Operators](https://kotlinlang.org/docs/keyword-reference.html)
### [Hard Keywords](https://kotlinlang.org/docs/keyword-reference.html#hard-keywords)
- The following tokens are always interpreted as keywords and cannot be used as identifiers:

|  |  |  |  |  |
| :-- | :-- | :-- | :-- | :-- |
| as | as? | break | class | continue |
| do | else | false | for | fun |
| if | in | !in | interface | is |
| !is | null | object | package | return |
| super | this | throw | true | try |
| typealias | typeof | val | var | when |
| while |  |  |  |  |

### [Soft Keywords](https://kotlinlang.org/docs/keyword-reference.html#soft-keywords)
- The following tokens act as keywords in the context in which they are applicable, and they can be used as identifiers in other contexts:

|  |  |  |  |  |
| :-- | :-- | :-- | :-- | :-- |
| by | catch | constructor | delegate | dynamic |
| field | file | finally | get | import |
| init | param | property | receiver | set |
| setparam | value | where |  |  |

### [Modifier Keywords](https://kotlinlang.org/docs/keyword-reference.html#modifier-keywords)
- The following tokens act as keywords in modifier lists of declarations, and they can be used as identifiers in other contexts:

|  |  |  |  |  |
| :-- | :-- | :-- | :-- | :-- |
| abstract | actual | annotation | companion | const |
| crossinline | data | enum | expect | external |
| final | infix | inline | inner | internal |
| lateinit | noinline | open | operator | out |
| override | private | protected | public | reified |
| sealed | suspend | tailrec | vararg |  |

### [Special Identifiers](https://kotlinlang.org/docs/keyword-reference.html#special-identifiers)
- The following identifiers are defined by the compiler in specific contexts, and they can be used as regular identifiers in other contexts:

|  |  |  |  |  |
| :-- | :-- | :-- | :-- | :-- |
| field | it |  |  |  |


### [Operators and Special Symbols](https://kotlinlang.org/docs/keyword-reference.html#operators-and-special-symbols)
- Kotlin supports the following operators and special symbols:

|  |  |  |  |  |
| :-- | :-- | :-- | :-- | :-- |
| + | - | * | / | % |
| = |  |  |  |  |
| += | -= | *= | /= | %= |
| ++ | -- |  |  |  |
| && | \|\| | ! |  |  |
| == | != |  |  |  |
| === | !== |  |  |  |
| < | > | <= | >= |  |
| [ | ] |  |  |  |
| !! |  |  |  |  |
| ?. |  |  |  |  |
| ?: |  |  |  |  |
| :: |  |  |  |  |
| .. | ..< |  |  |  |
| : |  |  |  |  |
| ? |  |  |  |  |
| -> |  |  |  |  |
| @ |  |  |  |  |
| ; |  |  |  |  |
| $ |  |  |  |  |
| _ |  |  |  |  |

<br />

## 1.4 [Operator Precedence](https://kotlinlang.org/docs/reference/grammar.html#expressions)
| Precedence | Title | Symbols |
| :-- | :-- | :-- |
| Highest | Postfix | ++, --, ., ?., ? |
|  | Prefix | -, +, ++, --, !, label |
|  | Type RHS | :, as, as? |
|  | Multiplicative | *, /, % |
|  | Additive | +, - |
|  | Range | .. |
|  | Infix function | simpleIdentifier |
|  | Elvis | ?: |
|  | Named checks | in, !in, is, !is |
|  | Comparison | <, >, <=, >= |
|  | Equality | ==, !=, ===, !== |
|  | Conjunction | && |
|  | Disjunction | \|\| |
|  | Spread operator | * |
| Lowest | Assignment | =, +=, -=, *=, /=, %= |

<br />
