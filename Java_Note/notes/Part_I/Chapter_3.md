# [Java Note](../../README.md) - Chapter 3 Variables and Constants
| Chapter | Title |
| :- | :- |
| 3.1 | [Variable Declaration](#31-variable-declaration) |
| 3.1.1 | [Variable Declaration without Initialization](#311-variable-declaration-without-initialization) |
| 3.1.2 | [Variable Declaration with Initialization](#312-variable-declaration-with-initialization) |
| 3.2 | [Constant Variable Declaration](#32-constant-variable-declaration) |
| 3.3 | [Type Inference](#33-type-inference) |

<br>

## 3.1 Variable Declaration
### 3.1.1 Variable Declaration without Initialization
```java
int a;
int b, c;
```

<br>

### 3.1.2 Variable Declaration with Initialization
```java
int a = 1;
int b = 2, c = 3;
```

<br>

## 3.2 Constant Variable Declaration
```java
final int a = 10;
```

<br>

## 3.3 Type Inference
```java
var a = 10.0;               // double type
final var b = 10.0;         // double type
```

Error: Cannot assign a null value
```java
var a = null;               // Error: Cannot assign a null value
```

<br>
