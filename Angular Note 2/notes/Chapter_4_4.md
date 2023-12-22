# [Angular Note 2](../README.md) - Chapter 4.4 Components: Interaction

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 4.4.1 | [Passing Data to Child (@Input)]() |
| 4.4.2 | [Listening Child Events (@Output)]() |
| 4.4.3 | [Interacting with Child though Local Variables]() |
| 4.4.4 | [Interacting with Child though Local Variables (@ViewChild)]() |

<br>
<hr>

### 4.4.1 Passing Data to Child (@Input)
File: first-component.component.html
```html
<app-second-component [message]="'Hello World!'"></app-second-component>
```
File: second-component.component.html
```html
<p>{{ message }}</p>
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

#### Adding Specific Name in @Input
File: first-component.component.html
```html
<app-second-component [message]="'Hello World!'"></app-second-component>
```
File: second-component.component.html
```html
<p>{{ parentMessage }}</p>
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
  
  @Input('message') parentMessage: string;
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
import { Component, EventEmitter, Output } from '@angular/core';

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

#### Adding Specific Name in @Output
File: second-component.component.html
```html
<button (click)="onClick()">Click Me</button>
```
File: second-component.component.ts
```ts
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-second-component',
  templateUrl: './second-component.component.html',
  styleUrl: './second-component.component.css'
})
export class SecondComponentComponent {
  
  @Output('messageSent') message: EventEmitter<string> = new EventEmitter<string>();

  onClick() {
    this.message.emit('Hello World!');
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

<br>
<hr>

### 4.4.3 Interacting with Child though Local Variables
File: first-component.compontent.html
```html
<button (click)="second.sayHello()">Click Me</button>
<app-second-component #second></app-second-component>
```
File: second-component.component.ts
```ts
export class SecondComponentComponent {
  
  sayHello() {
    console.log('Hello');
  }
}
```

<br>
<hr>

### 4.4.4 Interacting with Child though Local Variables (@ViewChild)
File: first-component.compontent.html
```html
<button (click)="onClick()">Click Me</button>
<app-second-component #second></app-second-component>
```
File: first-component.compontent.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { SecondComponentComponent } from '../second-component/second-component.component';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent {

  @ViewChild('second') second: SecondComponentComponent;

  onClick() {
    this.second.sayHello();
  }
}
```
File: second-component.component.ts
```ts
export class SecondComponentComponent {
  
  sayHello() {
    console.log('Hello');
  }
}
```
