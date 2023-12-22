# [Angular Note 2](../README.md) - Chapter 7 Services

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 7.1 | [Service Template](#71-service-template) |
| 7.2 | [Injecting a Service](#72-injecting-a-service) |
| | [Injecting a Service though Constructor](#injecting-a-service-though-constructor) |
| | [Injecting a Service though inject()](#injecting-a-service-though-inject) |
| 7.3 | [Interacting between Components thorugh a Service](#73-interacting-between-components-thorugh-a-service) |

<br>
<hr>

### 7.1 Service Template
File: account.service.ts
```ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor() { }
}
```

<br>
<hr>

### 7.2 Injecting a Service
#### Injecting a Service though Constructor
```ts
import { Component } from '@angular/core';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent {

  constructor(private accountService: AccountService) {}
}
```

#### Injecting a Service though inject()
```ts
import { Component, inject } from '@angular/core';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent {

  private accountService: AccountService = inject(AccountService);
}
```

<br>
<hr>

### 7.3 Interacting between Components thorugh a Service
File: first-component.component.html
```html
<button (click)="onClick()">Click Me</button>
<app-second-component></app-second-component>
```
File: first-component.component.ts
```ts
import { Component, inject } from '@angular/core';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent {

  private accountService: AccountService = inject(AccountService);

  onClick() {
    this.accountService.messageSent.emit("Hello World!");
  }
}
```
File: account.service.ts
```ts
import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  messageSent = new EventEmitter<string>();
}
```
File: second-component.component.ts
```ts
import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-second-component',
  templateUrl: './second-component.component.html',
  styleUrl: './second-component.component.css'
})
export class SecondComponentComponent implements OnInit {

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.accountService.messageSent.subscribe((message) => {
      console.log(message);
    });
  }
}
```
