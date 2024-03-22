# [Java Note](../../README.md) - Chapter 2 Primitive Types
| Chapter | Title |
| :- | :- |
| 2.1 | [Primitive Types](#21-primitive-types) |
| 2.2 | [Integers](#22-integers) |
| 2.2.1 | [Integer Types](#221-integer-types) |
| 2.2.2 | [Integer Literals](#222-integer-literals) |
| 2.3 | [Floating-Point Numbers](#23-floating-point-numbers) |
| 2.3.1 | [Floating-Point Types](#231-floating-point-types) |
| 2.3.2 | [Floating-Point Literals](#232-floating-point-literals) |
| 2.4 | [Characters](#24-characters) |
| 2.4.1 | [Character Types](#241-character-types) |
| 2.4.2 | [Character Literals](#242-character-literals) |
| 2.4.3 | [Character Escape Sequences](#243-character-escape-sequences) |
| 2.5 | [Boolean](#25-boolean) |
| 2.5.1 | [Boolean Types](#251-boolean-types) |
| 2.5.2 | [Boolean Literals](#252-boolean-literals) |
| 2.6 | [Type Casting](#26-type-casting) |
| 2.6.1 | [Widening Casting](#261-widening-casting) |
| 2.6.2 | [Narrowing Casting](#262-narrowing-casting) |
| 2.7 | [Type Promotion](#27-type-promotion) |
| 2.7.1 | [Type Promotion in byte, short, and char Operands](#271-type-promotion-in-byte-short-and-char-operands) |
| 2.7.2 | [Type Promotion in int, long, float, and double Operands](#272-type-promotion-in-int-long-float-and-double-operands) |

<br>

## 2.1 Primitive Types
- Integers: **byte**, **short**, **int**, and **long**
- Floating-Point Numbers: **float** and **double**
- Characters: **char**
- Boolean: **boolean**

<br>

## 2.2 Integers
### 2.2.1 Integer Types
| Data Type | Size (Bytes) | Range |
| :- | :- | :- |
| **byte** | 1 | –128 to 127 |
| **short** | 2 | –32,768 to 32,767 |
| **int** | 4 | –2,147,483,648 to 2,147,483,647 |
| **long** | 8 | –9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |

<br>

### 2.2.2 Integer Literals
#### Binary Integer Literals
```java
int a = 0b1010;         // Suggested
int b = 0B1010;
```

#### Octal Integer Literals
```java
int a = 0127;
```

#### Decimal Integer Literals
```java
int a = 789;
```

#### Hexadecimal Integer Literals
```java
int a = 0xabcd;
int b = 0xABCD;         // Suggested
int c = 0Xabcd;
int d = 0XABCD;
```

#### Long Integer Literals
```java
long a = 123l;
long b = 123L;          // Suggested
```

#### Integer Literals with Underscores
```java
int a = 123_456_789;
int b = 123__456__789;
```

<br>

## 2.3 Floating-Point Numbers
### 2.3.1 Floating-Point Types
| Data Type | Size (Bytes) | Approximate Range |
| :- | :- | :- |
| **float** | 4 | 1.4e–045 to 3.4e+038 |
| **double** | 8 | 4.9e–324 to 1.8e+308 |

<br>

### 2.3.2 Floating-Point Literals
#### Float Literals
```java
float a = 1.23f;
float b = 1.23F;            // Suggested
```

#### Double Literals
```java
double a = 1.23;            // Suggested
double b = 1.23d;
double c = 1.23D;
```

#### Scientific Notation Literals
```java
double a = 1.23e100;
double b = 1.23e+100;
double c = 1.23e-100;
double d = 1.23E100;
```

#### Hexadecimal Floating-Point Literals
```java
double a = 0x12.2p2;
double b = 0x12.2P2;        // = 0x12.2 * 4
```

#### Floating-Point Literals with Underscores
```java
double a = 123.456_789;
double b = 123.456__789;
```

#### Floating-Point Literals without Leading Zero
```java
double a = .09;
```

<br>

## 2.4 Characters
### 2.4.1 Character Types
| Data Type | Size (Bytes) | Range |
| :- | :- | :- |
| **char** | 2 | 0 to 65,535 |

<br>

### 2.4.2 Character Literals
#### Char Literals
```java
char a = 'a';
char b = 97;
```

#### Character Escape Sequence Literals
```java
char a = '\'';
char b = '\123';
char c = '\u0061';
```

<br>

### 2.4.3 Character Escape Sequences
| Escape Sequence | Description |
| :- | :- |
| \\ddd | Octal character (ddd) |
| \\uxxxx | Hexadecimal Unicode character (xxxx) |
| \\' | Single quote |
| \\" | Double quote |
| \\\\ | Backslash |
| \\r | Carriage return |
| \\n | New line (Line feed) |
| \\f | Form feed |
| \\t | Tab |
| \\b | Backspace |
| \\s | Space (added by JDK 15) |
| \\endofline | Continue line (applies only to text blocks; added by JDK 15) |

<br>

## 2.5 Boolean
### 2.5.1 Boolean Types
| Data Type | Size (Bits) | Value |
| :- | :- | :- |
| **boolean** | 1 | **true** or **false** |

<br>

### 2.5.2 Boolean Literals
```java
boolean a = true;
boolean b = false;
```

<br>

## 2.6 Type Casting
### 2.6.1 Widening Casting
**byte** -> **short** -> **int** -> **long** -> **float** -> **double**
```java
byte a = 1;
short b = a;
int c = b;
long d = c;
float e = d;
double f = e;
```

**char** -> **int**
```java
char a = 1;
int b = a;
```

<br>

### 2.6.2 Narrowing Casting
```java
(type)expression
```

**double** -> **float** -> **long** -> **int** -> **short** -> **byte**
```java
double f = 1.5;
float e = (float)f;
long d = (long)e;
int c = (int)d;
short b = (short)c;
byte a = (byte)b;
```

**int** -> **char**
```java
int b = 1;
char a = (char)b;
```

<br>

## 2.7 Type Promotion
### 2.7.1 Type Promotion in byte, short, and char Operands
**byte** / **short** / **char** -> **int**
```java
byte a = 50;
byte b = 50;
int c = a * b;          // Automatically promote to int
```

Error: Expression is promoted to int
```java
byte a = 50;
byte b = 50;
byte c = a * b;         // Error: Cannot assign int to byte
```

<br>

### 2.7.2 Type Promotion in int, long, float, and double Operands
**int** -> **long** -> **float** -> **double**
```java
int a = 50;
long b = 50;
long c = a * b;         // Automatically promote to long
```

Error: Expression is promoted to long
```java
int a = 50;
long b = 50;
int c = a * b;          // Error: Cannot assign long to int
```

<br>
