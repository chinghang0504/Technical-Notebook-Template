# [Angular Note 2](../README.md) - Chapter 4.6 Components: Dynamic Components

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 4.6.1 | [Dynamically Creating a Component](#461-dynamically-creating-a-component) |

<br>
<hr>

### 4.6.1 Dynamically Creating a Component
File: first-component.component.html
```html
<button (click)="onClick()">Click Me</button>
<ng-template #container></ng-template>
```
File: first-component.component.ts
```ts
import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { SecondComponentComponent } from '../second-component/second-component.component';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent {

  @ViewChild('container', {read: ViewContainerRef}) viewContainerRef: ViewContainerRef

  onClick() {
    this.viewContainerRef.clear();
    this.viewContainerRef.createComponent(SecondComponentComponent);
  }
}
```
