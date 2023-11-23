# [Angular Note](../README.md) - Chapter 3 String Interpolation and Data Binding

## Video 26

### String Interpolation

File: src/app/server/server.component.html

```html
<p>Server with ID {{ serverId }} is {{ serverStatus }}</p>
```

File: src/app/server/server.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-server",
  templateUrl: "./server.component.html",
  styleUrl: "./server.component.css",
})
export class ServerComponent {
  serverId: number = 10;
  serverStatus: string = "offline";
}
```

<br>

## Video 27

### Property Binding

File: src/app/servers/servers.component.html

```html
<button class="btn btn-primary" [disabled]="!allowNewServer">Add Server</button>
<app-server></app-server>
<app-server></app-server>
```

File: src/app/servers/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-servers",
  templateUrl: "./servers.component.html",
  styleUrl: "./servers.component.css",
})
export class ServersComponent {
  allowNewServer = false;

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
  }
}
```

<br>

## Video 29

### Event Binding

File: src/app/servers/servers.component.html

```html
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
<p>{{ serverCreationStatus }}</p>
<app-server></app-server>
<app-server></app-server>
```

File: src/app/servers/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-servers",
  templateUrl: "./servers.component.html",
  styleUrl: "./servers.component.css",
})
export class ServersComponent {
  allowNewServer = false;
  serverCreationStatus = "No server was created!";

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
  }

  onCreateServer() {
    this.serverCreationStatus = "Server was created!";
  }
}
```

<br>

## Video 31

### Event Binding with Event Parameter

File: src/app/servers/servers.component.html

```html
<label>Server Name</label>
<input type="text" class="form-control" (input)="onUpdateServerName($event)" />
<p>{{ serverName }}</p>
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
<p>{{ serverCreationStatus }}</p>
<app-server></app-server>
<app-server></app-server>
```

File: src/app/servers/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-servers",
  templateUrl: "./servers.component.html",
  styleUrl: "./servers.component.css",
})
export class ServersComponent {
  allowNewServer = false;
  serverCreationStatus = "No server was created!";
  serverName = "";

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
  }

  onCreateServer() {
    this.serverCreationStatus = "Server was created!";
  }

  onUpdateServerName(event: Event) {
    this.serverName = (<HTMLInputElement>event.target).value;
  }
}
```

<br>

## Video 33

### Two-Way-Binding

File: src/app/servers/servers.component.html

```html
<label>Server Name</label>
<input type="text" class="form-control" [(ngModel)]="serverName" />
<p>{{ serverName }}</p>
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
<p>{{ serverCreationStatus }}</p>
<app-server></app-server>
<app-server></app-server>
```

File: src/app/servers/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-servers",
  templateUrl: "./servers.component.html",
  styleUrl: "./servers.component.css",
})
export class ServersComponent {
  allowNewServer = false;
  serverCreationStatus = "No server was created!";
  serverName = "";

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
  }

  onCreateServer() {
    this.serverCreationStatus = "Server was created!";
  }
}
```

File: src/app/app.module.ts

```ts
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppComponent } from "./app.component";
import { FormsModule } from "@angular/forms";
import { ServersComponent } from "./servers/servers.component";
import { ServerComponent } from "./server/server.component";

@NgModule({
  declarations: [AppComponent, ServersComponent, ServerComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
```

<br>
