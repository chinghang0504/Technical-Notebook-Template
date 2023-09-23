# [HTML and CSS Note](../../README.md) - Chapter 1 Structure
| Chapter | Title |
| :-: | :- |
| 1.1 | [Selector and Declaration](#11-selector-and-declaration) |
| 1.2 | [Property and Value](#12-property-and-value) |
| 1.3 | [Using External CSS \<link>](#13-using-external-css-link) |
|  | [Attributes: href, type, and rel](#attributes-href-type-and-rel) |
| 1.4 | [Using Internal CSS \<style>](#14-using-internal-css-style) |
|  | [Attribute: type="text/css"](#attribute-typetextcss) |
| 1.5 | [CSS Selectors](#15-css-selectors) |
|  | [Universal Selector](#universal-selector) |
|  | [Type Selector](#type-selector) |
|  | [Class Selector](#class-selector) |
|  | [ID Selector](#id-selector) |
|  | [Child Selector](#child-selector) |
|  | [Descendant Selector](#descendant-selector) |
|  | [Adjacent Sibling Selector](#adjacent-sibling-selector) |
|  | [General Sibling Selector](#general-sibling-selector) |
| 1.6 | [CSS Rules Cascade](#16-css-rules-cascade) |
| 1.7 | [Inheritance](#17-inheritance) |
| 1.8 | [Comments](#18-comments) |

<br />

## 1.1 Selector and Declaration
- CSS works by associating rules with HTML elements.
- These rules govern how the content of specified elements should be displayed.
- A CSS rule contains two parts: a selector and a declaration.

Selector and Declaration
![Selector and Declaration](../../images/Part%20II/image_1_1.PNG)

<br />

## 1.2 Property and Value
- CSS declarations sit inside curly brackets and each is made up of two parts: a property and a value, separated by a colon.
- You can specify several properties in one declaration, each separated by a semi-colon.

Property and Value
![Property and Value](../../images/Part%20II/image_1_2.PNG)

<br />

## 1.3 Using External CSS \<link>
### Attributes: href, type, and rel
- The \<link> element can be used in an HTML document to tell the browser where to find the CSS file used to style the page.
- It is an empty element (meaning it does not need a closing tag), and it lives inside the \<head> element.
- It should use three attributes:
    1. href
        - This specifies the path to the CSS file (which is often placed in a folder called css or styles).
    2. type
        - This attribute specifies the type of document being linked to.
        - The value should be text/css.
    3. rel
        - This specifies the relationship between the HTML page and the file it is linked to.
        - The value should be stylesheet when linking to a CSS file.
- An HTML page can use more than one CSS style sheet.
- To do this it could have a \<link> element for every CSS file it uses.
- For example, some authors use one CSS file to control the presentation (such as fonts and colors) and a second to control the layout.

```html
<!DOCTYPE html>
<html>
    <head>
        <title>This is a title</title>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <h1>This is a heading</h1>
        <p>This is a paragrah</p>
    </body>
</html>
```

```css
body {
    font-family: arial;
}
h1 {
    color: #ff0000;
}
```

Result
![Result](../../images/Part%20II/image_1_3.PNG)

<br />

## 1.4 Using Internal CSS \<style>
- When building a site with more than one page, you should use an external CSS style sheet.
    1. Allows all pages to use the same style rules (rather than repeating them in each page).
    2. Keeps the content separate from how the page looks.
    3. Means you can change the styles used across all pages by altering just one file (rather than each individual page).

### Attribute: type="text/css"
```html
<!DOCTYPE html>
<html>
    <head>
        <title>This is a title</title>
        <style type="text/css">
            body {
                font-family: arial;
            }
            h1 {
                color: #ff0000;
            }
        </style>
    </head>
    <body>
        <h1>This is a heading</h1>
        <p>This is a paragrah</p>
    </body>
</html>
```

Result
![Result](../../images/Part%20II/image_1_4.PNG)

<br />

## 1.5 CSS Selectors
- There are many different types of CSS selector that allow you to target rules to specific elements in an HTML document.
- CSS Selectors
    1. Universal Selector
    2. Type Selector
    3. Class Selector
    4. ID Selector
    5. Child Selector
    6. Descendant Selector
    7. Adjacent Sibling Selector
    8. General Sibling Selector

### Universal Selector
- Applies to all elements in the document

```css
* {

}
```
- Targets all elements on the page

### Type Selector
- Matches element names

```css
h1, h2, h3 {

}
```
- Targets the \<h1>, \<h2> and \<h3> elements

### Class Selector
- Matches an element whose class attribute has a value that matches the one specified after the period (or full stop) symbol

```css
.note {

}
```
- Targets any element whose class attribute has a value of note

```css
p.note {

}
```
- Targets only \<p> elements whose class attribute has a value of note

### ID Selector
- Matches an element whose id attribute has a value that matches the one specified after the pound or hash symbol

```css
#introduction {

}
```
- Targets the element whose id attribute has a value of introduction

### Child Selector
- Matches an element that is a direct child of another

```css
li>a {

}
```
- Targets any \<a> elements that are children of an \<li> element (but not other \<a> elements in the page)

### Descendant Selector
- Matches an element that is a descendent of another specified element (not just a direct child of that element)

```css
p a {

}
```
- Targets any \<a> elements that sit inside a \<p> element, even if there are other elements nested between them

### Adjacent Sibling Selector
- Matches an element that is the next sibling of another

```css
h1+p {

}
```
- Targets the first \<p> element after any \<h1> element (but not other \<p> elements)

### General Sibling Selector
- Matches an element that is a sibling of another, although it does not have to be the directly preceding element

```css
h1~p {

}
```

- If you had two \<p> elements that are siblings of an \<h1> element, this rule would apply to both

<br />

## 1.6 CSS Rules Cascade
- If there are two or more rules that apply to the same element, it is important to understand which will take precedence.

Last Rule
- If the two selectors are identical, the latter of the two will take precedence.

Specificity
- If one selector is more specific than the others, the more specific rule will take precedence over more general ones.

Important
- You can add !important after any property value to indicate that it should be considered more important than other rules that apply to the same element.

```html
<!DOCTYPE html>
<html>
    <head>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <h1>Potatoes</h1>
        <p id="intro">There are <i>dozens</i> of different
            <b>potato</b> varieties.</p>
        <p>They are usually described as early, second early
            and maincrop potatoes.</p>
    </body>
</html>
```

```css
* {
    font-family: Arial, Verdana, sans-serif;
}

h1 {
    font-family: "Courier New", monospace;
}

i {
    color: green;
}

i {
    color: red;
}

b {
    color: pink;
}

p b {
    color: blue !important;
}

p b {
    color: violet;
}

p#intro {
    font-size: 100%;
}

p {
    font-size: 75%;
}
```

Result
![Result](../../images/Part%20II/image_1_5.PNG)

<br />

## 1.7 Inheritance
- If you specify the font-family or color properties on the \<body> element, they will apply to most child elements.
- This is because the value of the font-family property is inherited by child elements.
- It saves you from having to apply these properties to as many elements.
- You can force a lot of properties to inherit values from their parent elements by using inherit for the value of the properties. In this example, the \<div> element with a class called page inherits the padding size from the CSS rule that applies to the \<body> element.

```html
<!DOCTYPE html>
<html>
    <head>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <div class="page">
            <h1>Potatoes</h1>
            <p>There are dozens of different potato varieties.</p>
            <p>They are usually described as early, second early and maincrop potatoes.</p>
        </div>
    </body>
</html>
```

```css
body {
    font-family: Arial, Verdana, sans-serif;
    color: #665544;
    padding: 10px;
}

.page {
    border: 1px solid #665544;
    background-color: #efefef;
    padding: inherit;
}
```

Result
![Result](../../images/Part%20II/image_1_6.PNG)

<br />

## 1.8 Comments
```css
/* heading color */
h1 {
    color: darkcyan;
}
```

<br />
