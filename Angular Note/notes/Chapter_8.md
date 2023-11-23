# [Angular Note](../README.md) - Chapter 8

## Video 79
### Ng Content
File: src/app/app.component.html
```html
<div class="container">
  <app-cockpit (serverCreated)="onServerAdded($event)" (bpCreated)="onBlueprintAdded($event)"></app-cockpit>
  <hr>
  <div class="row">
    <div class="col-xs-12">
      <app-server-element *ngFor="let serverElement of severElements" [srvElement]="serverElement">
        <p>
          <strong *ngIf="serverElement.type === 'server'" style="color: red">{{ serverElement.content }}</strong>
          <em *ngIf="serverElement.type === 'blueprint'">{{ serverElement.content }}</em>
        </p>
      </app-server-element>
    </div>
  </div>
</div>
```

File: src/app/server-element/server-element.component.html
```html
<div class="panel panel-default">
    <div class="panel-heading">{{ element.name }}</div>
    <div class="panel-body">
      <ng-content></ng-content>
    </div>
</div>
```

<br>
