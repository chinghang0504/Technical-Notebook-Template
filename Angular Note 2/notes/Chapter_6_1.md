# [Angular Note 2](../README.md) - Chapter 6.1 Directives: Built-In

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 6.1 | [NgIf](#61-ngif) |
| 6.2 | [NgIf and NgTemplate](#62-ngif-and-ngtemplate) |
| 6.3 | [NgFor](#63-ngfor) |
| 6.4 | [NgSwitch, NgSwitchCase, and NgSwitchDefault](#64-ngswitch-ngswitchcase-and-ngswitchdefault) |
| 6.5 | [@if, @else if, and @else](#65-if-else-if-and-else) |
| 6.6 | [@for](#66-for) |
| 6.7 | [@switch, @case, and @default](#67-switch-case-and-default) |

<br>
<hr>

### 6.1 NgIf
```html
<p *ngIf="errorOccured">Error occurred!</p>
```
```ts
export class FirstComponentComponent {

  errorOccured: boolean = true;
}
```

<br>
<hr>

### 6.2 NgIf and NgTemplate
```html
<p *ngIf="errorOccured; else normal">Error occurred!</p>
<ng-template #normal>
    <p>System normal.</p>
</ng-template>
```
```ts
export class FirstComponentComponent {

  errorOccured: boolean = false;
}
```

<br>

```html
<div *ngIf="errorOccured; then error else normal"></div>
<ng-template #error>
    <p>Error occurred!</p>
</ng-template>
<ng-template #normal>
    <p>System normal.</p>
</ng-template>
```
```ts
export class FirstComponentComponent {

  errorOccured: boolean = false;
}
```

<br>
<hr>

### 6.3 NgFor
```html
<div *ngFor="let item of items">
    <p>{{ item }}</p>
</div>
```
```ts
export class FirstComponentComponent {

  items: string[] = ["Item A", "Item B", "Item C"];
}
```

#### NgFor and Index
```html
<div *ngFor="let item of items; index as i">
    <p>{{ i }}: {{ item }}</p>
</div>
```
```ts
export class FirstComponentComponent {

  items: string[] = ["Item A", "Item B", "Item C"];
}
```

<br>

```html
<div *ngFor="let item of items; let i = index">
    <p>{{ i }}: {{ item }}</p>
</div>
```
```ts
export class FirstComponentComponent {

  items: string[] = ["Item A", "Item B", "Item C"];
}
```

<br>
<hr>

### 6.4 NgSwitch, NgSwitchCase, and NgSwitchDefault
```html
<div [ngSwitch]="target">
    <p *ngSwitchCase="1">Item 1</p>
    <p *ngSwitchCase="2">Item 2</p>
    <p *ngSwitchCase="3">Item 3</p>
    <p *ngSwitchDefault>Empty Item</p>
</div>
```
```ts
export class FirstComponentComponent {

  target: number = -1;
}
```

<br>
<hr>

### 6.5 @if, @else if, and @else
```html
@if (errorOccured) {
    <p>Error occurred!</p>
}
```
```ts
export class FirstComponentComponent {

  errorOccured: boolean = true;
}
```

<br>

```html
@if (errorOccured) {
    <p>Error occurred!</p>
} @else {
    <p>System normal.</p>
}
```
```ts
export class FirstComponentComponent {

  errorOccured: boolean = false;
}
```

<br>

```html
@if (errorOccured) {
    <p>Error occurred!</p>
} @else if (warningOccured) {
    <p>System warning!</p>
} @else {
    <p>System normal.</p>
}
```
```ts
export class FirstComponentComponent {

  errorOccured: boolean = false;
  warningOccured: boolean = true;
}
```

<br>
<hr>

### 6.6 @for
```html
@for (item of items; track $index) {
    <p>{{ $index }}: {{ item }}</p>
}
```
```ts
export class FirstComponentComponent {

  items: string[] = ["Item A", "Item B", "Item C"];
}
```

<br>
<hr>

### 6.7 @switch, @case, and @default
```html
@switch (target) {
    @case (1) {
        <p>Item 1</p>
    }
    @case (2) {
        <p>Item 2</p>
    }
    @case (3) {
        <p>Item 3</p>
    }
    @default {
        <p>Empty Item</p>
    }
}
```
```ts
export class FirstComponentComponent {

  target: number = -1;
}
```
