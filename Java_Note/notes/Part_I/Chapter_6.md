# [Java Note](../../README.md) - Chapter 6 Statements
| Chapter | Title |
| :- | :- |
| 6.1 | [Types of Statements](#61-types-of-statements) |
| 6.2 | [Conditional Statements](#62-conditional-statements) |
| 6.2.1 | [if Statements](#621-if-statements) |
| 6.2.2 | [if-else Statements](#622-if-else-statements) |
| 6.2.3 | [if-else if Statements](#623-if-else-if-statements) |
| 6.2.4 | [switch Statments](#624-switch-statments) |
| 6.3 | [Iterative Statements](#63-iterative-statements) |
| 6.3.1 | [while Statments](#631-while-statments) |
| 6.3.2 | [do-while Statements](#632-do-while-statements) |
| 6.3.3 | [for Statements](#633-for-statements) |
| 6.3.4 | [for-each Statements](#634-for-each-statements) |
| 6.4 | [Jump Statements](#64-jump-statements) |
| 6.4.1 | [break Statement](#641-break-statement) |
| 6.4.2 | [continue Statement](#642-continue-statement) |
| 6.4.3 | [return Statement](#643-return-statement) |
| 6.4.4 | [Labelled Statements (Not Recommended)](#644-labelled-statements-not-recommended) |

<br>

## 6.1 Types of Statements
1. Conditional Statements
2. Iterative Statements
3. Jump Statements

<br>

## 6.2 Conditional Statements
### 6.2.1 if Statements
```java
if (boolean_expression) {
    statement;
}
```

<br>

### 6.2.2 if-else Statements
```java
if (boolean_expression) {
    statement;
} else {
    statement;
}
```

<br>

### 6.2.3 if-else if Statements
```java
if (boolean_expression) {
    statement;
} else if (boolean_expression) {
    statement;
}
```
```java
if (boolean_expression) {
    statement;
} else if (boolean_expression) {
    statement;
} else {
    statement;
}
```

<br>

### 6.2.4 switch Statments
```java
switch (expression) {
    case value:
        statement;
        break;
    case value:
        statement;
        break;
}
```
- The default statement is optional.

```java
switch (expression) {
    case value:
        statement;
        break;
    case value:
        statement;
        break;
    default:
        statement;
}
```
- For versions of Java prior to JDK 7, expression must resolve to type byte, short, int, char, or an enumeration.
- Today, expression can also be of type String.
- Each value specified in the case statements must be a unique constant expression (such as a literal value).
- Duplicate case values are not allowed.

#### Multiple Cases with the Same Statement
```java
switch (expression) {
    case value:
    case value:
    case value:
        statement;
        break;
    case value:
        statement;
        break;
    default:
        statement;
}
```

<br>

## 6.3 Iterative Statements
### 6.3.1 while Statments
```java
while (boolean_expresion) {
    statement;
}
```

#### Infinite while Statements
```java
while (true) {
    statement;
}
```

<br>

### 6.3.2 do-while Statements
```java
do {
    statement;
} while (boolean_expression);
```

<br>

### 6.3.3 for Statements
```java
for (initialization_expression, condition_expression, update_expression) {
    statement;
}
```

#### Infinite for Statements
```java
for (;;) {

}
```

<br>

### 6.3.4 for-each Statements
```java
for (type variable: collection) {
    statement;
}
```
```java
int[] a  = { 1, 2, 3, 4, 5 };

for (int element: a) {
    System.out.println(element);
}
```

<br>

## 6.4 Jump Statements
### 6.4.1 break Statement
- Uses in switch, while, do-while, and for statements.
```java
for (int i = 0; i < 5; i++) {
    if (i == 3) {
        break;
    }
    System.out.println(i);
}
```

<br>

### 6.4.2 continue Statement
- Uses in while, do-while, and for statements.
```java
for (int i = 0; i < 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.println(i);
}
```

<br>

### 6.4.3 return Statement
- Uses in a method.
```java
for (int i = 0; i < 5; i++) {
    if (i == 3) {
        return;
    }
    System.out.println(i);
}
```

<br>

### 6.4.4 Labelled Statements (Not Recommended)
```java
outerLoop: for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        if (i == 3 & j == 3) {
            break outerLoop;
        }
        System.out.println("i: " + i + ", j = " + j);
    }
}
```

<br>
