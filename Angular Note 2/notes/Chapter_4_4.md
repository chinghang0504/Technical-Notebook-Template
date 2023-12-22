# [Angular Note 2](../README.md) - Chapter 4.4 Components: Interaction

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 4.4.1 | [Passing Data from Parent to Child (@Input)](#441-passing-data-from-parent-to-child-input) |
| 4.4.2 | [Listening Child Events (@Output)](#442-listening-child-events-output) |

<br>
<hr>

### 4.4.1 Passing Data from Parent to Child (@Input)
File: first-component.component.html
```html
<app-second-component [message]="'Hello World'"></app-second-component>
```

File: second-component.component.ts
```ts
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-second-component',
  templateUrl: './second-component.component.html',
  styleUrl: './second-component.component.css'
})
export class SecondComponentComponent {
  
  @Input() message: string;
}
```

<br>

File: first-component.component.html
```html
<app-second-component [parentMessage]="'Hello World'"></app-second-component>
```

File: second-component.component.ts
```ts
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-second-component',
  templateUrl: './second-component.component.html',
  styleUrl: './second-component.component.css'
})
export class SecondComponentComponent {
  
  @Input('parentMessage') message: string;
}
```

<br>
<hr>

### 4.4.2 Listening Child Events (@Output)
File: second-component.component.html
```html
<button (click)="onClick()">Click Me</button>
```
File: second-component.component.ts
```ts
import { EventEmitter } from '@angular/core';
import { Component, Output } from '@angular/core';

@Component({
  selector: 'app-second-component',
  templateUrl: './second-component.component.html',
  styleUrl: './second-component.component.css'
})
export class SecondComponentComponent {
  
  @Output() messageSent: EventEmitter<string> = new EventEmitter<string>();

  onClick() {
    this.messageSent.emit('Hello World!');
  }
}
```

File: first-component.component.html
```html
<app-second-component (messageSent)="receivedMessage($event)"></app-second-component>
```
File: first-component.component.ts
```ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent {

  receivedMessage(message: string) {
    console.log(message);
  }
}
```
