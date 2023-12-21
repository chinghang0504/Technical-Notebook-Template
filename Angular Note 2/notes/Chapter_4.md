# [Angular Note 2](../README.md) - Chapter 4 Components

### Table of Contents

| Chapter | Title                                                            |
| :-----: | :--------------------------------------------------------------- |
|   4.1   | [Component Template](#41-component-template)                     |
|   4.2   | [Inline HTML](#42-inline-html)                                   |
|   4.3   | [Inline CSS](#43-inline-css)                                     |
|   4.4   | [Showing Components](#44-showing-components)                     |
|   4.5   | [Disabling View Encapsulation](#45-disabling-view-encapsulation) |

<br>
<hr>

### 4.1 Component Template

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-first-component",
  templateUrl: "./first-component.component.html",
  styleUrl: "./first-component.component.css",
})
export class FirstComponentComponent {}
```

<br>
<hr>

### 4.2 Inline HTML

```ts
@Component({
  selector: 'app-first-component',
  template: '<p>first-component works!</p>',
  styleUrl: "./first-component.component.css",
})
```

<br>
<hr>

### 4.3 Inline CSS

```ts
@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styles: [
    `
    p {
      background-color: red;
    }
    `
  ]
})
```

<br>
<hr>

### 4.4 Showing Components

```html
<app-first-component></app-first-component>
```

<br>
<hr>

### 4.5 Disabling View Encapsulation

```ts
@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: "./first-component.component.css",
  encapsulation: ViewEncapsulation.None
})
```
