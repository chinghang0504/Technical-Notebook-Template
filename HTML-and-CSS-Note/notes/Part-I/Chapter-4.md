# [Kotlin Note](../../README.md) - Chapter 4 Organization
| Chapter | Title |
| :-: | :- |
| 4.1 | [Main Content \<main>](#41-main-content-main) |
| 4.2 | [Headers \<header>](#42-headers-header) |
| 4.3 | [Footers \<footer>](#43-footers-footer) |
| 4.4 | [Sections \<section>](#44-sections-section) |
| 4.5 | [Articles \<article>](#45-articles-article) |
| 4.6 | [Aside \<aside>](#46-aside-aside) |
| 4.7 | [Navigation \<nav>](#47-navigation-nav) |
| 4.8 | [Generic Block-Level Element \<div>](#48-generic-block-level-element-div) |
| 4.9 | [Generic Inline Element \<span>](#49-generic-inline-element-span) |

<br>

## 4.1 Main Content \<main>
- Primary content area of page or app
```html
<body>
<header>…</header>
<main>
    <h1>Humanist Sans Serif</h1>
    <!-- code continues -->
</main>
</body>
```

<br>

## 4.2 Headers \<header>
- Introductory material for page, section, or article
```html
<body>
<header>
    <img src="/images/logo.png" alt="logo">
    <h1>Nuts about Web Fonts</h1>
    <nav>
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/">Blog</a></li>
            <li><a href="/">Shop</a></li>
        </ul>
    </nav>
</header>
<!--page content-->
</body>
```

<br>

## 4.3 Footers \<footer>
- Footer for page, section, or article
```html
<article>
    <header>
        <h1>More about WOFF</h1>
        <p>by Jennifer Robbins, <time datetime="2017-11-11">November 11,
        2017</time></p>
    </header>
    <!-- article content here -->
    <footer>
        <p><small>Copyright &copy;2017 Jennifer Robbins.</small></p>
        <nav>
            <ul>
                <li><a href="/">Previous</a></li>
                <li><a href="/">Next</a></li>
            </ul>
        </nav>
    </footer>
</article>
```

<br>

## 4.4 Sections \<section>
- Thematic group of content
```html
<section>
    <h2>Typography Books</h2>
    <ul>
        <li>…</li>
    </ul>
</section>
<section>
    <h2>Online Tutorials</h2>
    <p>These are the best tutorials on the web.</p>
    <ul>
        <li>…</li>
    </ul>
</section>
```

<br>

## 4.5 Articles \<article>
- Self-contained, reusable composition
```html
<article>
    <h1>Get to Know Helvetica</h1>
    <section>
        <h2>History of Helvetica</h2>
        <p>…</p>
    </section>
    <section>
        <h2>Helvetica Today</h2>
        <p>…</p>
    </section>
</article>
```

<br>

## 4.6 Aside \<aside>
- Tangentially related material
```html
<h1>Web Typography</h1>
<p>Back in 1997, there were competing font formats and tools for
making them…</p>
<p>We now have a number of methods for using beautiful fonts on web
pages…</p>
<aside>
    <h2>Web Font Resources</h2>
    <ul>
        <li><a href="http://typekit.com/">Typekit</a></li>
        <li><a href="http://fonts.google.com">Google Fonts</a></li>
    </ul>
</aside>
```

<br>

## 4.7 Navigation \<nav>
- Primary navigation links
```html
<nav>
    <ul>
        <li><a href="/">Serif</a></li>
        <li><a href="/">Sans-serif</a></li>
        <li><a href="/">Script</a></li>
        <li><a href="/">Display</a></li>
        <li><a href="/">Dingbats</a></li>
    </ul>
</nav>
```

<br>

## 4.8 Generic Block-Level Element \<div>
```html
<div id="news">
    <h1>New This Week</h1>
    <p>We've been working on...</p>
    <p>And last but not least,... </p>
</div>
```

<br>

## 4.9 Generic Inline Element \<span>
```html
<ul>
    <li>John: <span class="tel">999.8282</span></li>
    <li>Paul: <span class="tel">888.4889</span></li>
    <li>George: <span class="tel">888.1628</span></li>
    <li>Ringo: <span class="tel">999.3220</span></li>
</ul>
```

<br>
