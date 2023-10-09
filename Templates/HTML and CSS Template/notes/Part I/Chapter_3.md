# [HTML and CSS Note](../../README.md) - Chapter 3 Lists
| Chapter | Title |
| :-: | :- |
| 3.1 | [Types of Lists](#31-types-of-lists) |
| 3.2 | [Ordered Lists \<ol> and \<li>](#32-ordered-lists-ol-and-li) |
| 3.3 | [Unordered Lists \<ul> and \<li>](#33-unordered-lists-ul-and-li) |
| 3.4 | [Definition Lists \<dl>, \<dt>, and \<dd>](#34-definition-lists-dl-dt-and-dd) |
| 3.5 | [Nested Lists](#35-nested-lists) |

<br />

## 3.1 Types of Lists
- Ordered Lists
    - Ordered lists are lists where each item in the list is numbered.
    - For example, the list might be a set of steps for a recipe that must be performed in order, or a legal contract where each point needs to be identified by a section number.
- Unordered Lists
    - Unordered lists are lists that begin with a bullet point (rather than characters that indicate order).
- Definition Lists
    - Definition lists are made up of a set of terms along with the definitions for each of those terms.

<br />

## 3.2 Ordered Lists \<ol> and \<li>
- Browsers indent lists by default.
- Sometimes you may see a type attribute used with the \<ol> element to specify the type of numbering (numbers, letters, roman numerals and so on).
- It is better to use the CSS liststyle-type property.

```html
<html>
    <body>
        <p>
            List of Items
            <ol>
                <li>Item A</li>
                <li>Item B</li>
                <li>Item C</li>
                <li>Item D</li>
                <li>Item E</li>
            </ol> 
        </p>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_3_1.PNG)

<br />

## 3.3 Unordered Lists \<ul> and \<li>
- Browsers indent lists by default.
- Sometimes you may see a type attribute used with the \<ul> element to specify the type of bullet point (circles, squares, diamonds and so on).
- It is better to use the CSS list-styletype property.

```html
<html>
    <body>
        <p>
            List of Items
            <ul>
                <li>Item A</li>
                <li>Item B</li>
                <li>Item C</li>
                <li>Item D</li>
                <li>Item E</li>
            </ul> 
        </p>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_3_2.PNG)

<br />

## 3.4 Definition Lists \<dl>, \<dt>, and \<dd>
- \<dl>
    - The definition list is created with the \<dl> element and usually consists of a series of terms and their definitions.
- \<dt>
    - This is used to contain the term being defined (the definition term).
- \<dd> 
    - This is used to contain the definition.

```html
<html>
    <body>
        <p>
            List of Items
            <dl>
                <dt>Item A</dt>
                <dd>A for Apple</dd>
                <dt>Item B</dt>
                <dd>B for Boy</dd>
                <dt>Item C</dt>
                <dd>C for Car</dd>
            </dl> 
        </p>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_3_3.PNG)

<br />

## 3.5 Nested Lists
- Browsers display nested lists indented further than the parent list.
- In nested unordered lists, the browser will usually change the style of the bullet point too.

```html
<html>
    <body>
        <p>
            List of Items
            <ul>
                <li>Item A</li>
                <ul>
                    <li>Location 1</li>
                    <li>Location 2</li>
                    <li>Location 3</li>
                </ul>
                <li>Item B</li>
                <li>Item C</li>
            </ul>
        </p>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_3_4.PNG)

<br />
