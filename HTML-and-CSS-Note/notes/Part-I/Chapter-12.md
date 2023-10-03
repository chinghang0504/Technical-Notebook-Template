# [Kotlin Note](../../README.md) - Chapter 12 Global Attributes
| Chapter | Title |
| :-: | :- |
| 12.1 | [Global Attribute: id](#121-global-attribute-id) |
| 12.2 | [Global Attribute: class](#122-global-attribute-class) |

<br>

## 12.1 Global Attribute: id
- The id attribute is used to assign a unique identifier to an element in the document.
- In other words, the value of id must be used only once in the document.
- This makes it useful for assigning a name to a particular element, as though it were a piece of data.
```html
<div id="ISBN0321127307">
    <img src="felici-cover.gif" alt="">
    <p><cite>The Complete Manual of Typography</cite>, James Felici</p>
    <p>A combination of type history and examples of good and bad type.
    </p>
</div>
<div id="ISBN0881792063">
    <img src="bringhurst-cover.gif" alt="">
    <p><cite>The Elements of Typographic Style</cite>, Robert Bringhurst
    </p>
    <p>This lovely, well-written book is concerned foremost with creating
    beautiful typography.</p>
</div>
```

<br>

## 12.2 Global Attribute: class
- The class attribute classifies elements into conceptual groups; therefore, unlike the id attribute, a class name may be shared by multiple elements.
- By making elements part of the same class, you can apply styles to all of the labeled elements at once with a single style rule or manipulate them all with a script.
```html
<div id="ISBN0321127307" class="listing">
    <header>
        <img src="felici-cover.gif" alt="">
        <p><cite>The Complete Manual of Typography</cite>, James Felici</p>
    </header>
    <p class="description">A combination of type history and examples of
    good and bad type.</p>
</div>
<div id="ISBN0881792063" class="listing">
    <header>
        <img src="bringhurst-cover.gif" alt="">
        <p><cite>The Elements of Typographic Style</cite>, Robert Bringhurst
        </p>
    </header>
    <p class="description">This lovely, well-written book is concerned
    foremost with creating beautiful typography.</p>
</div>
```

<br>
