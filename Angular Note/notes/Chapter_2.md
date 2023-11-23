# [Angular Note](../README.md) - Chapter 2 Components

## Video 20

### Create a New Component

```shell
ng g c servers
```

File: src/app/servers/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-servers",
  templateUrl: "./servers.component.html",
  styleUrl: "./servers.component.css",
})
export class ServersComponent {}
```

<br>

## Video 21

### Using Inline HTML

File: src/app/servers/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-servers",
  template: ` <p>servers works!</p> `,
  styleUrl: "./servers.component.css",
})
export class ServersComponent {}
```

<br>

## Video 22

### Using Inline CSS

File: src/app/servers/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-servers",
  templateUrl: "./servers.component.html",
  styles: [
    `
      p {
        background-color: red;
      }
    `,
  ],
})
export class ServersComponent {}
```

### Changing Selector

File: src/app/servers/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: ".app-servers",
  templateUrl: "./servers.component.html",
  styleUrl: "./servers.component.css",
})
export class ServersComponent {}
```

File: src/app/app.component.html

```html
<h3>I'm in the App Component!</h3>
<hr />
<!-- <app-servers></app-servers> -->
<div class="app-servers"></div>
```

<br>
