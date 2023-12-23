# [Angular Note 2](../README.md) - Chapter 8 Routing

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 8.1 | [Setting Paths and Router Outlets](#81-setting-paths-and-router-outlets) |
| 8.2 | [Navigation](#82-navigation) |
|  | [Naviagting though Router Links](#naviagting-though-router-links) |
|  | [Naviagting though Router Service](#naviagting-though-router-service) |
| 8.3 | [Adding Classes when Navigating Specific Paths](#83-adding-classes-when-navigating-specific-paths) |
| 8.4 | [Router Parameters](#84-router-parameters) |
| 8.5 | [Router Parameter Subscription](#85-router-parameter-subscription) |
| 8.6 | [Query Parameters](#86-query-parameters) |
|  | [Query Parameters in HTML](#query-parameters-in-html) |
|  | [Query Parameters in TypeScript](#query-parameters-in-typescript) |
| 8.7 | [Navigating with the Same Query Parameters](#87-navigating-with-the-same-query-parameters) |
| 8.8 | [Child Route](#88-child-routes) |
| 8.9 | [Wildcard Route](#89-wildcard-routes) |

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

<br>
<hr>

### 8.3 Adding Classes when Navigating Specific Paths
File: app.component.html
```html
<button routerLink="/first" routerLinkActive="active">First Page</button><button routerLink="/second" routerLinkActive="active">Second Page</button>
<router-outlet></router-outlet>
```
File: app.component.css
```css
button.active {
    background-color: red;
}
```

<br>
<hr>

### 8.4 Router Parameters
File: app-routing-module.ts
```ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponentComponent } from './first-component/first-component.component';
import { SecondComponentComponent } from './second-component/second-component.component';
import { ItemComponent } from './item/item.component';

const routes: Routes = [
  {path: 'first', component: FirstComponentComponent },
  {path: 'first/:id', component: ItemComponent },
  {path: 'second', component: SecondComponentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```
File: item.component.ts
```ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrl: './item.component.css'
})
export class ItemComponent implements OnInit {
  id: string;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
  }
}
```

<br>
<hr>

### 8.5 Router Parameter Subscription
File: item.component.ts
```ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrl: './item.component.css'
})
export class ItemComponent implements OnInit {
  id: string;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];

    this.activatedRoute.params.subscribe((params) => {
      this.id = params['id'];
    })
  }
}
```

<br>
<hr>

### 8.6 Query Parameters
File: app-routing.module.ts
```ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponentComponent } from './first-component/first-component.component';
import { SecondComponentComponent } from './second-component/second-component.component';
import { ItemComponent } from './item/item.component';

const routes: Routes = [
  {path: 'first', component: FirstComponentComponent },
  {path: 'first/item', component: ItemComponent },
  {path: 'second', component: SecondComponentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```
File: item.component.ts
```ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrl: './item.component.css'
})
export class ItemComponent implements OnInit {
  id: string;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
  this.id = this.activatedRoute.snapshot.queryParams['id'];

    this.activatedRoute.queryParams.subscribe((queryParams) => {
      this.id = queryParams['id'];
    })
  }
}
```

#### Query Parameters in HTML
File: app.component.html
```html
<button routerLink="/first">First Page</button><button routerLink="/second">Second Page</button><br>
<button routerLink="/first/item" [queryParams]="{ id: 1 }">1</button><button routerLink="/first/item" [queryParams]="{ id: 2 }">2</button><button routerLink="/first/item" [queryParams]="{ id: 3 }">3</button>
<router-outlet></router-outlet>
```

#### Query Parameters in TypeScript
File: app.component.html
```html
<button routerLink="/first">First Page</button><button routerLink="/second">Second Page</button><br>
<button (click)="onClick(1)">1</button><button (click)="onClick(2)">2</button><button (click)="onClick(3)">3</button>
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
    this.router.navigate(['/first', 'item'], {queryParams: { id: num }});
  }
}
```

<br>
<hr>

### 8.7 Navigating with the Same Query Parameters
```ts
this.router.navigate([], { relativeTo: this.activatedRoute, queryParamsHandling: 'preserve' });
```

<br>
<hr>

### 8.8 Child Routes
File: app-routing.module.ts
```ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponentComponent } from './first-component/first-component.component';
import { SecondComponentComponent } from './second-component/second-component.component';
import { ItemComponent } from './item/item.component';

const routes: Routes = [
  {path: 'first', component: FirstComponentComponent, children: [
    { path: 'item', component: ItemComponent },
  ]},
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
<button routerLink="/first">First Page</button><button routerLink="/second">Second Page</button><br>
<button routerLink="/first/item" [queryParams]="{ id: 1 }">1</button><button routerLink="/first/item" [queryParams]="{ id: 2 }">2</button><button routerLink="/first/item" [queryParams]="{ id: 3 }">3</button>
<router-outlet></router-outlet>
```
File: first-component.component.html
```html
<p>First Component Works</p>
<router-outlet></router-outlet>
```

<br>
<hr>

### 8.9 Wildcard Routes
File: app-routing.module.ts
```ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstComponentComponent } from './first-component/first-component.component';
import { SecondComponentComponent } from './second-component/second-component.component';
import { ItemComponent } from './item/item.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {path: 'first', component: FirstComponentComponent, children: [
    { path: 'item', component: ItemComponent },
  ]},
  {path: 'second', component: SecondComponentComponent },
  { path: 'page-not-found', component: PageNotFoundComponent },
  { path: '**', redirectTo: '/page-not-found' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```
