# [Kotlin Note](../../README.md) - Chapter 1 Basics
| Chapter | Title |
| :-: | :- |
| 1.1 | [Comments](#11-comments) |
|  | [Single-Line Comments](#single-line-comments) |
|  | [Multi-Line Comments](#multi-line-comments) |
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
### Single-Line Comments
```kotlin
// This is a comment
```

### Multi-Line Comments
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

<style>
table, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<table>
    <tr>
        <td>as</td><td>as?</td><td>break</td><td>class</td><td>continue</td>
    </tr>
    <tr>
        <td>do</td><td>else</td><td>false</td><td>for</td><td>fun</td>
    </tr>
    <tr>
        <td>if</td><td>in</td><td>!in</td><td>interface</td><td>is</td>
    </tr>
    <tr>
        <td>!is</td><td>null</td><td>object</td><td>package</td><td>return</td>
    </tr>
    <tr>
        <td>super</td><td>this</td><td>throw</td><td>true</td><td>try</td>
    </tr>
    <tr>
        <td>typealias</td><td>typeof</td><td>val</td><td>var</td><td>when</td>
    </tr>
    <tr>
        <td>while</td><td></td><td></td><td></td><td></td>
    </tr>
</table>

### [Soft Keywords](https://kotlinlang.org/docs/keyword-reference.html#soft-keywords)
- The following tokens act as keywords in the context in which they are applicable, and they can be used as identifiers in other contexts:

<table>
    <tr>
        <td>by</td><td>catch</td><td>constructor</td><td>delegate</td><td>dynamic</td>
    </tr>
    <tr>
        <td>field</td><td>file</td><td>finally</td><td>get</td><td>import</td>
    </tr>
    <tr>
        <td>init</td><td>param</td><td>property</td><td>receiver</td><td>set</td>
    </tr>
    <tr>
        <td>setparam</td><td>value</td><td>where</td><td></td><td></td>
    </tr>
</table>

### [Modifier Keywords](https://kotlinlang.org/docs/keyword-reference.html#modifier-keywords)
- The following tokens act as keywords in modifier lists of declarations, and they can be used as identifiers in other contexts:

<table>
    <tr>
        <td>abstract</td><td>actual</td><td>annotation</td><td>companion</td><td>const</td>
    </tr>
    <tr>
        <td>crossinline</td><td>data</td><td>enum</td><td>expect</td><td>external</td>
    </tr>
    <tr>
        <td>final</td><td>infix</td><td>inline</td><td>inner</td><td>internal</td>
    </tr>
    <tr>
        <td>lateinit</td><td>noinline</td><td>open</td><td>operator</td><td>out</td>
    </tr>
    <tr>
        <td>override</td><td>private</td><td>protected</td><td>public</td><td>reified</td>
    </tr>
    <tr>
        <td>sealed</td><td>suspend</td><td>tailrec</td><td>vararg</td><td></td>
    </tr>
</table>

### [Special Identifiers](https://kotlinlang.org/docs/keyword-reference.html#special-identifiers)
- The following identifiers are defined by the compiler in specific contexts, and they can be used as regular identifiers in other contexts:

<table>
    <tr>
        <td>field</td><td>it</td>
    </tr>
</table>

### [Operators and Special Symbols](https://kotlinlang.org/docs/keyword-reference.html#operators-and-special-symbols)
- Kotlin supports the following operators and special symbols:

<table>
    <tr>
        <td>+</td><td>-</td><td>*</td><td>/</td><td>%</td>
    </tr>
    <tr>
        <td>=</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>+=</td><td>-=</td><td>*=</td><td>/=</td><td>%=</td>
    </tr>
    <tr>
        <td>++</td><td>--</td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>&&</td><td>||</td><td>!</td><td></td><td></td>
    </tr>
    <tr>
        <td>==</td><td>!=</td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>===</td><td>!==</td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td><</td><td>></td><td><=</td><td>>=</td><td></td>
    </tr>
    <tr>
        <td>[</td><td>]</td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>!!</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>?.</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>?:</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>::</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>..</td><td>..<</td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>:</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>?</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>-></td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>@</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>;</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>$</td><td></td><td></td><td></td><td></td>
    </tr>
    <tr>
        <td>_</td><td></td><td></td><td></td><td></td>
    </tr>
</table>

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
