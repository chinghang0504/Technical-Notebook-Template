# [Angular Note](../README.md) - Chapter 4 Directives

## Video 37

### ngIf

File: src/app/servers/servers.component.html

```html
<label>Server Name</label>
<input type="text" class="form-control" [(ngModel)]="serverName" />
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
<p *ngIf="serverCreated">Server was created, server name is {{ serverName }}</p>
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
  serverName = "";
  serverCreated = false;

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
  }

  onCreateServer() {
    this.serverCreated = true;
  }
}
```

<br>

## Video 38

### ngIf and else

File: src/app/servers/servers.component.html

```html
<label>Server Name</label>
<input type="text" class="form-control" [(ngModel)]="serverName" />
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
<p *ngIf="serverCreated; else noServer">
  Server was created, server name is {{ serverName }}
</p>
<ng-template #noServer>
  <p>No server was created!</p>
</ng-template>
<app-server></app-server>
<app-server></app-server>
```

<br>

## Video 39

### @if and @else

```html
<label>Server Name</label>
<input type="text" class="form-control" [(ngModel)]="serverName" />
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
@if (serverCreated) {
<p>Server was created, server name is {{ serverName }}</p>
} @else {
<p>No server was created!</p>
}
<app-server></app-server>
<app-server></app-server>
```

<br>

## Video 40

### ngStyle

File: src/app/server/server.component.html

```html
<p [ngStyle]="{ backgroundColor: getColor() }">
  Server with ID {{ serverId }} is {{ serverStatus }}
</p>
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

  constructor() {
    this.serverStatus = Math.random() > 0.5 ? "online" : "offline";
  }

  getColor() {
    return this.serverStatus === "online" ? "green" : "red";
  }
}
```

<br>

## Video 41

### ngClass

File: src/app/server/server.component.html

```html
<p
  [ngStyle]="{ backgroundColor: getColor() }"
  [ngClass]="{ online: serverStatus === 'online' }"
>
  Server with ID {{ serverId }} is {{ serverStatus }}
</p>
```

File: src/app/server/server.component.css

```css
.online {
  color: white;
}
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

  constructor() {
    this.serverStatus = Math.random() > 0.5 ? "online" : "offline";
  }

  getColor() {
    return this.serverStatus === "online" ? "green" : "red";
  }
}
```

<br>

## Video 42

### ngFor

File: src/app/server/servers.component.html

```html
<label>Server Name</label>
<input type="text" class="form-control" [(ngModel)]="serverName" />
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
@if (serverCreated) {
<p>Server was created, server name is {{ serverName }}</p>
} @else {
<p>No server was created!</p>
}
<app-server *ngFor="let server of servers"></app-server>
```

File: src/app/server/servers.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-servers",
  templateUrl: "./servers.component.html",
  styleUrl: "./servers.component.css",
})
export class ServersComponent {
  allowNewServer = false;
  serverName = "";
  serverCreated = false;
  servers = ["Testserver 1", "Testserver 2"];

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
  }

  onCreateServer() {
    this.serverCreated = true;
    this.servers.push(this.serverName);
  }
}
```

<br>

## Video 43

### @for

File: src/app/server/servers.component.html

```html
<label>Server Name</label>
<input type="text" class="form-control" [(ngModel)]="serverName" />
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
@if (serverCreated) {
<p>Server was created, server name is {{ serverName }}</p>
} @else {
<p>No server was created!</p>
} @for (server of servers; track $index) {
<app-server></app-server>
}
```

<br>

## Video 45

### ngFor and Index

File: src/app/server/servers.component.html

```html
<label>Server Name</label>
<input type="text" class="form-control" [(ngModel)]="serverName" />
<button
  class="btn btn-primary"
  [disabled]="!allowNewServer"
  (click)="onCreateServer()"
>
  Add Server
</button>
@if (serverCreated) {
<p>Server was created, server name is {{ serverName }}</p>
} @else {
<p>No server was created!</p>
}
<app-server
  *ngFor="let server of servers; let i = index"
  [ngStyle]="{ fontSize: i > 1 ? '30px' : '10px'}"
></app-server>
```

<br>

## Video 104

### ngSwitch

File: src/app/app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <div [ngSwitch]="value">
        <p *ngSwitchCase="5">Value is 5</p>
        <p *ngSwitchCase="10">Value is 10</p>
        <p *ngSwitchCase="100">Value is 100</p>
        <p *ngSwitchDefault="">Value is Default</p>
      </div>
    </div>
  </div>
</div>
```

File: src/app/app.component.ts

```ts
import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrl: "./app.component.css",
})
export class AppComponent {
  value = 100;
}
```

<br>
