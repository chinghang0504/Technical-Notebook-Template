# [Angular Note 2](../README.md) - Chapter 10.1 Forms: Template-Driven Forms

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 10.1.1 | []() |

<br>
<hr>

### 10.1.1 Submitting a Template-Driven Form
File: app.module.ts
```ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponentComponent } from './first-component/first-component.component';
import { SecondComponentComponent } from './second-component/second-component.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponentComponent,
    SecondComponentComponent,
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
```html
<form (ngSubmit)="onSubmit(form)" #form="ngForm">
    <label for="username">Username</label>
    <input type="text" id="username" ngModel name="username"><br>
    <label for="password">Password</label>
    <input type="password" id="password" ngModel name="password"><br>
    <button type="submit">Login</button>
</form>
```
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent {

  @ViewChild('form') form: NgForm;

  onSubmit() {
    console.log(this.form);
  }
}
```

<br>
<hr>

### 10.1.2 Input Validation (required)
```html
<form (ngSubmit)="onSubmit()" #form="ngForm">
    <label for="username">Username</label>
    <input type="text" id="username" ngModel name="username" required><br>
    <label for="password">Password</label>
    <input type="password" id="password" ngModel name="password" required><br>
    <button type="submit" [disabled]="form.invalid">Login</button>
</form>
```

<br>
<hr>

### 10.1.3 Input Helping Messages
```html
<form (ngSubmit)="onSubmit()" #form="ngForm">
    <label for="username">Username</label>
    <input type="text" id="username" ngModel name="username" required #username="ngModel"><br>
    @if(username.invalid && username.touched) {
        <p>Please enter the username.</p>
    }
    <label for="password">Password</label>
    <input type="password" id="password" ngModel name="password" required #password="ngModel"><br>
    @if(password.invalid && password.touched) {
        <p>Please enter the password.</p>
    }
    <button type="submit" [disabled]="form.invalid">Login</button>
</form>
```
```css
input.ng-invalid.ng-touched {
    border: 1px solid red;
}
```

<br>
<hr>





