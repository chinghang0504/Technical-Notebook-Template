# [Kotlin Note](../../README.md) - Chapter 1 Basics
| Chapter | Title |
| :-: | :- |
| 1.1 | [Naming Conventions](#11-naming-conventions) |
| 1.2 | [HTML Elements](#12-html-elements) |
|  | [Nonempty Elements](#nonempty-elements) |
|  | [Empty Elements](#empty-elements) |
|  | [Block Elements](#block-elements) |
|  | [Inline Elements](#inline-elements) |
| 1.3 | [HTML Element Attributes and Values](#13-html-element-attributes-and-values) |
| 1.4 | [HTML Document Structure](#14-html-document-structure) |
| 1.5 | [HTML Basic Elements](#15-html-basic-elements) |
|  | [\<!DOCTYPE html>](#doctype-html) |
|  | [\<html>](#html) |
|  | [\<head>](#head) |
|  | [\<meta>](#meta) |
|  | [\<title>](#title) |
|  | [\<body>](#body) |
|  | [Comments \<!-- -->](#comments) |

<br>

## 1.1 Naming Conventions
1. Use proper suffixes for your files.
    - HTML files must end with .html or .htm. Web graphics must be labeled according to their file format: .gif, .png, .jpg (.jpeg is also acceptable, although less common), or .svg.

2. Never use character spaces within filenames.
    - It is common to use an underline character or hyphen to visually separate words within filenames, such as robbins_bio.html or robbinsbio.html.

3. Avoid special characters such as ?, %, #, /, :, ;, •, etc.
    - Limit filenames to letters, numbers, underscores, hyphens, and periods. It is also best to avoid international characters, such as the Swedish å.

4. Filenames may be case-sensitive, depending on your server configuration.
    - Consistently using all lowercase letters in filenames, although not required, is one way to make your filenames easier to manage.

5. Keep filenames short.
    - Long names are more likely to be misspelled, and short names shave a few extra bytes off the file size. If you really must give the file a long, multiword name, you can separate words with hyphens, such as a-long-document-title.html, to improve readability.

6. Self-imposed conventions.
    - It is helpful to develop a consistent naming scheme for huge sites—for instance, always using lowercase with hyphens between words. This takes some of the guesswork out of remembering what you named a file when you go to link to it later.

<br>

## 1.2 HTML Elements
### Nonempty Elements
- An element consists of both the content and its markup
```html
<h1>Black Goose Bistro</h1>
```

### Empty Elements
- An element consists of its markup only.
```html
<hr>
```

### Block Elements
- Each block element begins on a new line, and some space is also usually added above and below the entire element by default.

### Inline Elements
- Inline elements do not start new lines; they just go with the flow.

<br>

## 1.3 HTML Element Attributes and Values
```html
<img src="bird.jpg" alt="photo of bird">
```

<br>

## 1.4 HTML Document Structure
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>

</body>
</html>
```

<br>

## 1.5 HTML Basic Elements
### \<!DOCTYPE html>
- Identifies the document as written in HTML5.

### \<html>
- Is the root element that contains all the other elements.

### \<head>
- Identifies the head of the document that contains information about the document itself.

### \<meta>
- Provides information about the document.

### \<title>
- Gives the page a title.

### \<body>
- Identifies the body of the document that holds the content.

### Comments \<!-- -->
- Anything you put between comment tags (\<!-- -->) will not display in the browser and will not have any effect on the rest of the source.
```html
<!-- Comment -->
```

<br>
