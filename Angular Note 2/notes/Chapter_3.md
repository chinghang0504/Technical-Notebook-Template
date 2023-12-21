# [Angular Note 2](../README.md) - Chapter 3 App (Standalone Disable)

### Table of Contents

| Chapter | Title                              |
| :-----: | :--------------------------------- |
|   3.1   | [App Module](#31-app-module)       |
|   3.2   | [App Component](#32-app-component) |
|   3.3   | [App Routing](#33-app-routing)     |

<br>
<hr>

### 3.1 App Module

File: app.module.ts

```ts
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
```

<br>
<hr>

### 3.2 App Component

File: app.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrl: "./app.component.css",
})
export class AppComponent {
  title = "FirstProject";
}
```

<br>
<hr>

### 3.3 App Routing

File: app-routing.module.ts

```ts
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
```
