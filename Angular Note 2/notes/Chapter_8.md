# [Angular Note 2](../README.md) - Chapter 8 Routing

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 8.1 | [Setting Paths and Router Outlets](#81-setting-paths-and-router-outlets) |
| 8.2 | [Navigation](#82-navigation) |
|  | [Naviagting though Router Links](#naviagting-though-router-links) |
|  | [Naviagting though Router Service](#naviagting-though-router-service) |

<br>
<hr>

### 8.1 Setting Paths and Router Outlets
File: app-routing.module.ts
```ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponentComponent } from './first-component/first-component.component';
import { SecondComponentComponent } from './second-component/second-component.component';

const routes: Routes = [
  {path: 'first', component: FirstComponentComponent },
  {path: 'second', component: SecondComponentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```
File: app.component.html
```html
<router-outlet></router-outlet>
```

<br>
<hr>

### 8.2 Navigation
#### Naviagting though Router Links
File: app.component.html
```html
<button routerLink="/first">First Page</button><button routerLink="/second">Second Page</button>
<router-outlet></router-outlet>
```

#### Naviagting though Router Service
File: app.component.html
```html
<button (click)="onClick(1)">First Page</button><button (click)="onClick(2)">Second Page</button>
<router-outlet></router-outlet>
```
File: app.component.ts
```ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  constructor(private router: Router) {}

  onClick(num: number) {
    switch (num) {
      case 1:
        this.router.navigate(["/first"])
        break;
      case 2:
        this.router.navigate(["/second"])
        break;
    }
  }
}
```
