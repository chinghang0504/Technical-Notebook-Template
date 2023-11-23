# [Angular Note](../README.md) - Chapter 5 Binding to Custom Properties and Events

## Video 69
### Binding to Custom Properties
File: src/app/app.component.html
```html
<div class="container">
  <app-cockpit></app-cockpit>
  <hr>
  <div class="row">
    <div class="col-xs-12">
      <app-server-element *ngFor="let serverElement of severElements" [element]="serverElement"></app-server-element>
    </div>
  </div>
</div>
```

File: src/app/app.component.ts
```ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  severElements = [
    {type: 'server', name:'Testserver', content: 'Just a test!'}
  ];
}
```

File: src/app/server-element/server-element.component.html
```html
<div class="panel panel-default">
    <div class="panel-heading">{{ element.name }}</div>
    <div class="panel-body">
      <p>
        <strong *ngIf="element.type === 'server'" style="color: red">{{ element.content }}</strong>
        <em *ngIf="element.type === 'blueprint'">{{ element.content }}</em>
      </p>
    </div>
</div>
```

File: src/app/server-element/server-element.component.ts
```ts
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-server-element',
  templateUrl: './server-element.component.html',
  styleUrl: './server-element.component.css'
})
export class ServerElementComponent {
  @Input() element: { type: string, name: string, content: String };
}
```

<br>

## Video 70
### Changing Custom Property Name
File: src/app/app.component.html
```html
<div class="container">
  <app-cockpit></app-cockpit>
  <hr>
  <div class="row">
    <div class="col-xs-12">
      <app-server-element *ngFor="let serverElement of severElements" [srvElement]="serverElement"></app-server-element>
    </div>
  </div>
</div>
```

File: src/app/server-element/server-element.component.ts
```ts
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-server-element',
  templateUrl: './server-element.component.html',
  styleUrl: './server-element.component.css'
})
export class ServerElementComponent {
  @Input('srvElement') element: { type: string, name: string, content: String };
}
```

<br>

## Video 71
### Binding to Custom Events
File: src/app/cockpit/cockpit.component.html
```html
<div class="row">
    <div class="col-xs-12">
      <p>Add new Servers or blueprint</p>
      <label>Server Name</label>
      <input type="text" class="form-control" [(ngModel)]="newServerName">
      <label>Server Content</label>
      <input type="text" class="form-control" [(ngModel)]="newServerContent">
      <br>
      <button class="btn btn-primary" (click)="onAddServer()">Add Server</button>
      <button class="btn btn-primary" (click)="onAddBlueprint()">Add Server Blueprint</button>
    </div>
</div>
```

File: src/app/cockpit/cockpit.component.ts
```ts
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrl: './cockpit.component.css'
})
export class CockpitComponent {
  newServerName = '';
  newServerContent = '';
  @Output() serverCreated = new EventEmitter<{serverName: string, serverContent: string}>();
  @Output() blueprintCreated = new EventEmitter<{serverName: string, serverContent: string}>();

  onAddServer() {
    this.serverCreated.emit({
      serverName: this.newServerName,
      serverContent: this.newServerContent
    });
  }

  onAddBlueprint() {
    this.blueprintCreated.emit({
      serverName: this.newServerName,
      serverContent: this.newServerContent
    });
  }
}
```

File: src/app/app.component.html
```html
<div class="container">
  <app-cockpit (serverCreated)="onServerAdded($event)" (blueprintCreated)="onBlueprintAdded($event)"></app-cockpit>
  <hr>
  <div class="row">
    <div class="col-xs-12">
      <app-server-element *ngFor="let serverElement of severElements" [srvElement]="serverElement"></app-server-element>
    </div>
  </div>
</div>
```

File: src/app/app.component.ts
```ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  severElements = [
    {type: 'server', name:'Testserver', content: 'Just a test!'}
  ];

  onServerAdded(serverData: {serverName: string, serverContent: string}) {
    this.severElements.push(
      {
        type: 'server',
        name: serverData.serverName,
        content: serverData.serverContent
      }
    );
  }

  onBlueprintAdded(blueprintData: {serverName: string, serverContent: string}) {
    this.severElements.push(
      {
        type: 'blueprint',
        name: blueprintData.serverName,
        content: blueprintData.serverContent
      }
    );
  }
}
```

<br>

## Video 72
### Changing Custom Event Name
File: src/app/cockpit/cockpit.component.ts
```ts
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrl: './cockpit.component.css'
})
export class CockpitComponent {
  newServerName = '';
  newServerContent = '';
  @Output() serverCreated = new EventEmitter<{serverName: string, serverContent: string}>();
  @Output('bpCreated') blueprintCreated = new EventEmitter<{serverName: string, serverContent: string}>();

  onAddServer() {
    this.serverCreated.emit({
      serverName: this.newServerName,
      serverContent: this.newServerContent
    });
  }

  onAddBlueprint() {
    this.blueprintCreated.emit({
      serverName: this.newServerName,
      serverContent: this.newServerContent
    });
  }
}
```

File: src/app/app.component.html
```html
<div class="container">
  <app-cockpit (serverCreated)="onServerAdded($event)" (bpCreated)="onBlueprintAdded($event)"></app-cockpit>
  <hr>
  <div class="row">
    <div class="col-xs-12">
      <app-server-element *ngFor="let serverElement of severElements" [srvElement]="serverElement"></app-server-element>
    </div>
  </div>
</div>
```

<br>
