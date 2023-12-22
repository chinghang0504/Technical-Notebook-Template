# [Angular Note 2](../README.md) - Chapter 6 Data Binding

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 6.1 | [Types of Data Binding](#61-types-of-data-binding) |
| 6.2 | [Interpolation](#62-interpolation) |
| 6.3 | [Property Binding](#63-property-binding) |
| 6.4 | [Class Binding](#64-class-binding) |
| 6.5 | [Style Binding](#65-style-binding) |
| 6.6 | [Event Binding](#66-event-binding) |
| 6.7 | [NgModel](#67-ngmodel) |

<br>
<hr>

### 6.1 Types of Data Binding
- One-Way Data Binding (From Data Source to View Target)
- One-Way Data Binding (From View Target to Data Source)
- Two-Way Data Binding

| Binding Type | Name | Syntax |
| :- | :- | :- |
| One-Way (From Data Source to View Target) | Interpolation | {{ expression }} |
| | Property | [target]="expression" |
| | Class | |
| | Style | |
| One-Way (From View Target to Data Source) | Event | (target)="statement" |
| Two-Way | NgModel | [(target)]="expression" |

<br>
<hr>

### 6.2 Interpolation
```html
<p>{{ message }}</p>
```
```ts
export class FirstComponentComponent {

  message: string = "Hello World!";
}
```

<br>
<hr>

### 6.3 Property Binding
```html
<button [disabled]="isDisabling">Click Me</button>
```
```ts
export class FirstComponentComponent {

  isDisabling: boolean = true;
}
```

<br>
<hr>

### 6.4 Class Binding
```html
<button [ngClass]="{ 'btn btn-primary': useBootstrap }">Click Me</button>
```
```ts
export class FirstComponentComponent {

  useBootstrap: boolean = true;
}
```

<br>
<hr>

### 6.5 Style Binding
```html
<button [ngStyle]="{ 'background-color': color }">Click Me</button>
```
```ts
export class FirstComponentComponent {

  color: string = 'red';
}
```

<br>
<hr>

### 6.6 Event Binding
```html
<button (click)="onClick()">Click Me</button>
```
```ts
export class FirstComponentComponent {
  
  onClick() {

  }
}
```

#### Passing Event as Argument
```html
<button (click)="onClick($event)">Click Me</button>
```
```ts
export class FirstComponentComponent {

  onClick(event: Event) {
    
  }
}
```

<br>
<hr>

### 6.7 NgModel
```html
<input type="text" [(ngModel)]="username">
```
```ts
export class FirstComponentComponent {

  username: string = 'username';
}
```

File: app.module.ts
```ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponentComponent } from './first-component/first-component.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
