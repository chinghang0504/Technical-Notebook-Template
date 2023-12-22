# [Angular Note 2](../README.md) - Chapter 5.1 Templates: Binding

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 5.1.1 | [Types of Data Binding](#511-types-of-data-binding) |
| 5.1.2 | [Interpolation](#512-interpolation) |
| 5.1.3 | [Property Binding](#513-property-binding) |
| 5.1.4 | [Class Binding (NgClass)](#514-class-binding-ngclass) |
| 5.1.5 | [Style Binding (NgStyle)](#515-style-binding-ngstyle) |
| 5.1.6 | [Event Binding](#516-event-binding) |
| | [Passing Event as Argument](#passing-event-as-argument) |
| 5.1.7 | [Two-Way Binding (NgModel)](#517-two-way-binding-ngmodel) |

<br>
<hr>

### 5.1.1 Types of Data Binding
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

### 5.1.2 Interpolation
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

### 5.1.3 Property Binding
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

### 5.1.4 Class Binding (NgClass)
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

### 5.1.5 Style Binding (NgStyle)
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

### 5.1.6 Event Binding
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

### 5.1.7 Two-Way Binding (NgModel)
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
