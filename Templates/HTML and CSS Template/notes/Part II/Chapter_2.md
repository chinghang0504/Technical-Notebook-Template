# [HTML and CSS Note](../../README.md) - Chapter 2 Color
| Chapter | Title |
| :-: | :- |
| 2.1 | [Foreground Color](#21-foreground-color) |
|  | [Property: color](#property-color) |
| 2.2 | [Background Color](#22-background-color) |
|  | [Property: background-color](#property-background-color) |
| 2.3 | [Color Values](#23-color-values) |
|  | [RGB Values](#rgb-values) |
|  | [Hex Codes](#hex-codes) |
|  | [Color Names](#color-names) |
|  | [Hue](#hue) |
|  | [Saturation](#saturation) |
|  | [Brightness](#brightness) |
| 2.4 | [Contrast](#24-contrast) |
|  | [Low Contrast](#low-contrast) |
|  | [Medium Contrast](#medium-contrast) |
|  | [High Contrast](#high-contrast) |
| 2.5 | [CSS3: Opacity](#25-css3-opacity) |
|  | [Property: opacity](#property-opacity) |
|  | [Value: rgba](#value-rgba) |
| 2.6 | [CSS3: HSL Colors](#26-css3-hsl-colors) |
|  | [Hue](#hue-1) |
|  | [Saturation](#saturation-1) |
|  | [Lightness](#lightness) |
|  | [Value: hsl](#value-hsl) |
|  | [Value: hsla](#value-hsla) |

<br />

## 2.1 Foreground Color
### Property: color
- The color property allows you to specify the color of text inside an element. You can specify any color in CSS in one of three ways:
    1. RGB Values
        - These express colors in terms of how much red, green and blue are used to make it up. For example: rgb(100,100,90)
    2. Hex Codes
        - These are six-digit codes that represent the amount of red, green and blue in a color, preceded by a pound or hash # sign. For example: #ee3e80
    3. Color Names
        - There are 147 predefined color names that are recognized by browsers. For example: DarkCyan

```html
<!DOCTYPE html>
<html>
    <head>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <h1>Marine Biology</h1>
        <h2>The Composition of Seawater</h2>
        <p>Almost anything can be found in seawater. This includes dissolved materials from Earth's crust as well as materials released from organisms. The most important components of seawater that influence life forms are salinity, temperature, dissolved gases (mostly oxygen and carbon dioxide), nutrients, and pH. These elements vary in their composition as well as in their influence on marine life.</p>
    </body>
</html>
```

```css
h1 {
    color: darkcyan;
}

h2 {
    color: #ee3e80;
}

p {
    color: rgb(100, 100, 90);
}
```

Result
![Result](../../images/Part%20II/image_2_1.PNG)

<br />

## 2.2 Background Color
### Property: background-color
- CSS treats each HTML element as if it appears in a box, and the background-color property sets the color of the background for that box.
- If you do not specify a background color, then the background is transparent.
- By default, most browser windows have a white background, but browser users can set a background color for their windows, so if you want to be sure that the background is white you can use the background-color property on the \<body> element.

```html
<!DOCTYPE html>
<html>
    <head>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <h1>Marine Biology</h1>
        <h2>The Composition of Seawater</h2>
        <p>Almost anything can be found in seawater. This includes dissolved materials from Earth's crust as well as materials released from organisms. The most important components of seawater that influence life forms are salinity, temperature, dissolved gases (mostly oxygen and carbon dioxide), nutrients, and pH. These elements vary in their composition as well as in their influence on marine life.</p>
    </body>
</html>
```

```css
body {
    background-color: rgb(200, 200, 200);
}

h1 {
    background-color: darkcyan;
}

h2 {
    background-color: #ee3e80;
}

p {
    background-color: white;
}
```

Result
![Result](../../images/Part%20II/image_2_2.PNG)

<br />

## 2.3 Color Values
### RGB Values
- Values for red, green, and blue are expressed as numbers between 0 and 255.

![RGB Values](../../images/Part%20II/image_2_3.PNG)

### Hex Codes
- Hex values represent values for red, green, and blue in hexadecimal code.

![Hex Codes](../../images/Part%20II/image_2_4.PNG)

### Color Names
- Colors are represented by predefined names. However, they are very limited in number.

![Color Names](../../images/Part%20II/image_2_5.PNG)

### Hue
- Hue is near to the colloquial idea of color.
- Technically speaking however, a color can also have saturation and brightness as well as hue.

![Hue](../../images/Part%20II/image_2_6.PNG)

### Saturation
- Saturation refers to the amount of gray in a color.
- At maximum saturation, there would be no gray in the color.
- At minimum saturation, the color would be mostly gray.

![Saturation](../../images/Part%20II/image_2_7.PNG)

### Brightness
- Brightness (or "value") refers to how much black is in a color.
- At maximum brightness, there would be no black in the color.
- At minimum brightness, the color would be very dark.

![Brightness](../../images/Part%20II/image_2_8.PNG)

<br />

## 2.4 Contrast
- When picking foreground and background colors, it is important to ensure that there is enough contrast for the text to be legible.

### Low Contrast
![Low Contrast](../../images/Part%20II/image_2_9.PNG)
- Text is harder to read when there is low contrast between background and foreground colors.

### Medium Contrast
![Medium Contrast](../../images/Part%20II/image_2_10.PNG)
- For long spans of text, reducing the contrast a little bit improves readability.

### High Contrast
![High Contrast](../../images/Part%20II/image_2_11.PNG)
- Text is easier to read when there is higher contrast between background and foreground colors.

<br />

## 2.5 CSS3: Opacity
### Property: opacity
- CSS3 introduces the opacity property which allows you to specify the opacity of an element and any of its child elements. The value is a number between 0.0 and 1.0 (so a value of 0.5 is 50% opacity and 0.15 is 15% opacity).

```html
<!DOCTYPE html>
<html>
    <head>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <h1 id="first">Marine Biology</h1>
        <h1 id="second">Marine Biology</h1>
    </body>
</html>
```

```css
h1#first {
    background-color: rgb(255, 0, 0);
}

h1#second {
    background-color: rgb(255, 0, 0);
    opacity: 0.5;
}
```

Result
![Result](../../images/Part%20II/image_2_12.PNG)

### Value: rgba
- The CSS3 rgba property allows you to specify a color, just like you would with an RGB value, but adds a fourth value to indicate opacity.
- This value is known as an alpha value and is a number between 0.0 and 1.0 (so a value of 0.5 is 50% opacity and 0.15 is 15% opacity).
- The rgba value will only affect the element on which it is applied (not child elements).

```html
<!DOCTYPE html>
<html>
    <head>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <h1 id="first">Marine Biology</h1>
        <h1 id="second">Marine Biology</h1>
    </body>
</html>
```

```css
h1#first {
    background-color: rgb(255, 0, 0);
}

h1#second {
    background-color: rgba(255, 0, 0, 0.5);
}
```

Result
![Result](../../images/Part%20II/image_2_13.PNG)

<br />

## 2.6 CSS3: HSL Colors
- CSS3 introduces an entirely new and intuitive way to specify colors using hue, saturation, and lightness values.

### Hue
![Hue](../../images/Part%20II/image_2_14.PNG)

- Hue is the colloquial idea of color.
- In HSL colors, hue is often represented as a color circle where the angle represents the color, although it may also be shown as a slider with values from 0 to 360.

### Saturation
![Saturation](../../images/Part%20II/image_2_15.PNG)

- Saturation is the amount of gray in a color. Saturation is represented as a percentage.
- 100% is full saturation and 0% is a shade of gray.

### Lightness
![Lightness](../../images/Part%20II/image_2_16.PNG)

- Lightness is the amount of white (lightness) or black (darkness) in a color.
- Lightness is represented as a percentage.
- 0% lightness is black, 100% lightness is white, and 50% lightness is normal.
- Lightness is sometimes referred to as luminosity.

### Value: hsl
- hue
    - This is expressed as an angle (between 0 and 360 degrees).
- saturation
    - This is expressed as a percentage.
- lightness
    - This is expressed as a percentage with 0% being white, 50% being normal, and 100% being black.

```html
<!DOCTYPE html>
<html>
    <head>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <h1 id="first">Marine Biology</h1>
        <h1 id="second">Marine Biology</h1>
    </body>
</html>
```

```css
h1#first {
    background-color: rgb(255, 0, 0);
}

h1#second {
    background-color: hsl(0, 100%, 50%);
}
```

Result
![Result](../../images/Part%20II/image_2_17.PNG)

### Value: hsla
- alpha
    - This is expressed as a number between 0 and 1.0.
    - For example, 0.5 represents 50% transparency, and 0.75 represents 75% transparency.

```html
<!DOCTYPE html>
<html>
    <head>
        <link href="../../images/Part%20II/index.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <h1 id="first">Marine Biology</h1>
        <h1 id="second">Marine Biology</h1>
    </body>
</html>
```

```css
h1#first {
    background-color: rgb(255, 0, 0);
}

h1#second {
    background-color: hsla(0, 100%, 50%, 0.5);
}
```

Result
![Result](../../images/Part%20II/image_2_18.PNG)

<br />
