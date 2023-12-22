# [Angular Note 2](../README.md) - Chapter 4.1 Components: Basics

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 4.1.1 | [Component Template](#411-component-template) |
| 4.1.2 | [Inline HTML](#412-inline-html) |
| 4.1.3 | [Inline CSS](#413-inline-css) |
| 4.1.4 | [Using Components](#414-using-components) |

<br>
<hr>

### 4.1.1 Component Template
File: first-component.component.ts
```ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent {

}
```

File: app.module.ts
```ts
@NgModule({
  declarations: [
    AppComponent,
    FirstComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
```

<br>
<hr>

### 4.1.2 Inline HTML
```ts
@Component({
  selector: 'app-first-component',
  template: '<p>first-component works!</p>',
  styleUrl: './first-component.component.css'
})
```

<br>
<hr>

### 4.1.3 Inline CSS
```ts
@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styles: ['p { background-color: red; }']
})
```

<br>
<hr>

### 4.1.4 Using Components
```html
<app-first-component></app-first-component>
```
