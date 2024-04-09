# [Java Note](../../README.md) - Chapter 4 Arrays
| Chapter | Title |
| :- | :- |
| 4.1 | [Array Declaration](#41-array-declaration) |
| 4.1.1 | [Array Declaration without Initialization](#411-array-declaration-without-initialization) |
| 4.1.2 | [Array Declaration with Specified Size](#412-array-declaration-with-specified-size) |
| 4.1.3 | [Array Declaration with Empty Array Initializer](#413-array-declaration-with-empty-array-initializer) |
| 4.1.4 | [Array Declaration with Array Initializer](#414-array-declaration-with-array-initializer) |
| 4.1.5 | [Array Declaration with Array Initializer and new Keyword](#415-array-declaration-with-array-initializer-and-new-keyword) |
| 4.2 | [Array Fields and Methods](#42-array-fields-and-methods) |
| 4.2.1 | [Getting Array Elements](#421-getting-array-elements) |
| 4.2.2 | [Setting Array Elements](#422-setting-array-elements) |
| 4.2.3 | [Array Field: length](#423-array-field-length) |
| 4.2.4 | [Array Method: clone()](#424-array-method-clone) |
| 4.3 | [Class: java.util.Arrays](#43-class-javautilarrays) |
| 4.3.1 | [Arrays: toString()](#431-arrays-tostring) |
| 4.4 | [Multidimensional Arrays](#44-multidimensional-arrays) |
| 4.4.1 | [Multidimensional Array Declaration](#441-multidimensional-array-declaration) |
| 4.4.2 | [Irrgular Multidimensional Array Declaration](#442-irrgular-multidimensional-array-declaration) |
| 4.4.3 | [Accessing Multidimensional Array Elements](#443-accessing-multidimensional-array-elements) |

<br>

## 4.1 Array Declaration
### 4.1.1 Array Declaration without Initialization
Warning: This does not hold an array.
```java
int[] a;
```

<br>

### 4.1.2 Array Declaration with Specified Size
```java
int[] a = new int[10];
```
- The elements in the array allocated by new will automatically be initialized to zero (for numeric types), false (for boolean), or null (for reference types).

<br>

### 4.1.3 Array Declaration with Empty Array Initializer
```java
int[] a = {};
```

<br>

### 4.1.4 Array Declaration with Array Initializer
```java
int[] a = { 1, 2, 3 };
```

<br>

### 4.1.5 Array Declaration with Array Initializer and new Keyword
```java
int[] a = new int[]{ 1, 2, 3 };
```
```java
int[] fun() {
    return new int[]{ 1, 2, 3 };
}
```
- Usually used in returning an array

Error: Without the new Keyword
```java
int[] fun() {
    return { 1, 2, 3 };
}
```

<br>

## 4.2 Array Fields and Methods
### 4.2.1 Getting Array Elements
```java
int[] a = { 1, 2, 3 };
System.out.println(a[0]);
```

<br>

### 4.2.2 Setting Array Elements
```java
int[] a = { 1, 2, 3 };
a[0] = 100;
```

<br>

### 4.2.3 Array Field: length
- The size of the array.
```java
int[] a = { 1, 2, 3 };
System.out.println(a.length);
```

<br>

### 4.2.4 Array Method: clone()
- Shallow copy of the array.
```java
int[] a = { 1, 2, 3 };
int[] b = a.clone();
```

<br>

## 4.3 [Class: java.util.Arrays](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/Arrays.html)
### 4.3.1 [Arrays: toString()](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/Arrays.html#toString(int%5B%5D))
```java
public static String toString(int[] a)
```
- Returns a string representation of the contents of the specified array.
- The string representation consists of a list of the array's elements, enclosed in square brackets ("[]").
- Adjacent elements are separated by the characters ", " (a comma followed by a space).
- Elements are converted to strings as by String.valueOf(int).
- Returns "null" if a is null.

<br>

## 4.4 Multidimensional Arrays
### 4.4.1 Multidimensional Array Declaration
```java
int[][] a;
int[][] b = new int[3][4];
int[][] c = {};                                 // An empty array with nothing
int[][] d = { {} };                             // An empty array with an empty array
int[][] e = { { 1, 2, 3,}, { 4, 5, 6 } };
```

<br>

### 4.4.2 Irrgular Multidimensional Array Declaration
```java
int[][] a = new int[3][];
a[0] = new int[1];
a[1] = new int[2];
a[2] = new int[3];
```

<br>

### 4.4.3 Accessing Multidimensional Array Elements
```java
int[][] a = { { 1, 2, 3,}, { 4, 5, 6 } };
a[0][0] = 100;
System.out.println(a[0][0]);
```

<br>
