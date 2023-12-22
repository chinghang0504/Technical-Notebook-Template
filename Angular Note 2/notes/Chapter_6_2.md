# [Angular Note 2](../README.md) - Chapter 6.1 Directives: Attribute Directives

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 6.2.1 | [NgClass](#621-ngclass) |
| 6.2.2 | [NgStyle](#622-ngstyle) |
| 6.2.3 | [NgModel](#623-ngmodel) |

<br>
<hr>

### 6.2.1 NgClass
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

### 6.2.2 NgStyle
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

### 6.2.3 NgModel
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
