# [Angular Note](../README.md) - Chapter 7 Local and Element References

## Video 76
### Local Refernece
File: src/app/cockpit/cockpit.component.html
```html
<div class="row">
    <div class="col-xs-12">
      <p>Add new Servers or blueprint</p>
      <label>Server Name</label>
      <input type="text" class="form-control" #serverNameInput>
      <label>Server Content</label>
      <input type="text" class="form-control" [(ngModel)]="newServerContent">
      <br>
      <button class="btn btn-primary" (click)="onAddServer(serverNameInput)">Add Server</button>
      <button class="btn btn-primary" (click)="onAddBlueprint(serverNameInput)">Add Server Blueprint</button>
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
  newServerContent = '';
  @Output() serverCreated = new EventEmitter<{serverName: string, serverContent: string}>();
  @Output('bpCreated') blueprintCreated = new EventEmitter<{serverName: string, serverContent: string}>();

  onAddServer(nameInput: HTMLInputElement) {
    this.serverCreated.emit({
      serverName: nameInput.value,
      serverContent: this.newServerContent
    });
  }

  onAddBlueprint(nameInput: HTMLInputElement) {
    this.blueprintCreated.emit({
      serverName: nameInput.value,
      serverContent: this.newServerContent
    });
  }
}
```

<br>

## Video 78
### Element Reference (View Child)
File: src/app/cockpit/cockpit.component.html
```html
<div class="row">
    <div class="col-xs-12">
      <p>Add new Servers or blueprint</p>
      <label>Server Name</label>
      <input type="text" class="form-control" #serverNameInput>
      <label>Server Content</label>
      <input type="text" class="form-control" #serverContentInput>
      <br>
      <button class="btn btn-primary" (click)="onAddServer(serverNameInput)">Add Server</button>
      <button class="btn btn-primary" (click)="onAddBlueprint(serverNameInput)">Add Server Blueprint</button>
    </div>
</div>
```

File: src/app/cockpit/cockpit.component.ts
```ts
import { Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrl: './cockpit.component.css'
})
export class CockpitComponent {
  @Output() serverCreated = new EventEmitter<{serverName: string, serverContent: string}>();
  @Output('bpCreated') blueprintCreated = new EventEmitter<{serverName: string, serverContent: string}>();
  @ViewChild('serverContentInput', {static: true}) serverContentInput: ElementRef;

  onAddServer(nameInput: HTMLInputElement) {
    this.serverCreated.emit({
      serverName: nameInput.value,
      serverContent: this.serverContentInput.nativeElement.value
    });
  }

  onAddBlueprint(nameInput: HTMLInputElement) {
    this.blueprintCreated.emit({
      serverName: nameInput.value,
      serverContent: this.serverContentInput.nativeElement.value
    });
  }
}
```

<br>

## Video 84
### Element Reference (Content Child)
File: src/app/app.component.html
```html
<div class="container">
  <app-cockpit (serverCreated)="onServerAdded($event)" (bpCreated)="onBlueprintAdded($event)"></app-cockpit>
  <hr>
  <div class="row">
    <div class="col-xs-12">
      <app-server-element *ngFor="let serverElement of severElements" [srvElement]="serverElement">
        <p #contentParagraph>
          <strong *ngIf="serverElement.type === 'server'" style="color: red">{{ serverElement.content }}</strong>
          <em *ngIf="serverElement.type === 'blueprint'">{{ serverElement.content }}</em>
        </p>
      </app-server-element>
    </div>
  </div>
</div>
```

File: src/app/server-element/server-element.component.ts
```ts
import { Component, ContentChild, ElementRef, Input } from '@angular/core';

@Component({
  selector: 'app-server-element',
  templateUrl: './server-element.component.html',
  styleUrl: './server-element.component.css'
})
export class ServerElementComponent {
  @Input('srvElement') element: { type: string, name: string, content: String };

  @ContentChild('contentParagraph', {static: true}) paragraph: ElementRef;
}
```

<br>
