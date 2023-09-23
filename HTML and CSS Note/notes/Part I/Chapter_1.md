# [HTML and CSS Note](../../README.md) - Chapter 1 Structure
| Chapter | Title |
| :-: | :- |
| 1.1 | [HTML Elements](#11-html-elements) |
|  | [Opening Tags](#opening-tags) |
|  | [Closing Tags](#closing-tags) |
| 1.2 | [Structure of Pages](#12-structure-of-pages) |
| 1.3 | [HTML Attributes](#13-html-attributes) |
| 1.4 | [Structure Elements](#14-structure-elements) |
|  | [HTML \<html>](#html-html) |
|  | [Body \<body>](#body-body) |
|  | [Head \<head>](#head-head) |
|  | [Title \<title>](#title-title) |

<br />

## 1.1 HTML Elements
- Elements are usually made up of two tags: an opening tag and a closing tag.
- Each HTML element tells the browser something about the information that sits between its opening and closing tags.

### Opening Tags
![Opening Tag](../../images/Part%20I/image_1_1.PNG)

### Closing Tags
![Closing Tag](../../images/Part%20I/image_1_2.PNG)

<br />

## 1.2 Structure of Pages
```html
<html>
    <head>

    </head>
    <body>
        
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_1_3.PNG)

<br />

## 1.3 HTML Attributes
- Attributes provide additional information about the contents of an element.
- They appear on the opening tag of the element and are made up of two parts: a name and a value, separated by an equals sign.

HTML Attribute
![HTML Attribute](../../images/Part%20I/image_1_4.PNG)

- HTML5 allows you to use uppercase attribute names and omit the quotemarks, but this is not recommended.

<br />

## 1.4 Structure Elements
### HTML \<html>
- The opening \<html> tag indicates that anything between it and a closing \</html> tag is HTML code.

### Body \<body>
- The \<body> tag indicates that anything between it and the closing \</body> tag should be shown inside the main browser window.

### Head \<head>
- Before the \<body> element you will often see a \<head> element.
- This contains information about the page (rather than information that is shown within the main part of the browser window that is highlighted in blue on the opposite page).
- You will usually find a \<title> element inside the \<head> element.

### Title \<title>
- The contents of the \<title> element are either shown in the top of the browser, above where
you usually type in the URL of the page you want to visit, or on the tab for that page (if your browser uses tabs to allow you to view multiple pages at the same time).

```html
<html>
    <head>
        <title>This is a title</title>
    </head>
    <body>
        <h1>This is a heading</h1>
        <p>
            This is a paragraph.
        </p>
    </body>
</html>
```

Result
![Result](../../images/Part%20I/image_1_5.PNG)

<br />
