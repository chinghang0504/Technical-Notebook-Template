# [Angular Note](../README.md) - Chapter 10 Custom Directives

## Video 96

### Create a Custom Attribute Directive

```shell
ng g d basic-highlight
```

File: src/app/basic-highlight.directive.ts

```ts
import { Directive, ElementRef } from "@angular/core";

@Directive({
  selector: "[appBasicHighlight]",
})
export class BasicHighlightDirective {
  constructor(private elementRef: ElementRef) {}

  ngOnInit() {
    this.elementRef.nativeElement.style.backgroundColor = "green";
  }
}
```

File: src/app/app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <p appBasicHighlight>Style me with basic directive!</p>
    </div>
  </div>
</div>
```

<br>

## Video 97

### Using Render

File: src/app/better-highlight.directive.ts

```ts
import { Directive, ElementRef, Renderer2 } from "@angular/core";

@Directive({
  selector: "[appBetterHighlight]",
})
export class BetterHighlightDirective {
  constructor(private elementRef: ElementRef, private renderer: Renderer2) {}

  ngOnInit() {
    this.renderer.setStyle(
      this.elementRef.nativeElement,
      "background-color",
      "blue"
    );
  }
}
```

File: src/app/app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <p appBasicHighlight>Style me with basic directive!</p>
      <p appBetterHighlight>Style me with basic directive!</p>
    </div>
  </div>
</div>
```

<br>

## Video 99

### Hosting Listener

File: src/app/better-highlight.directive.ts

```ts
import { Directive, ElementRef, Renderer2, HostListener } from "@angular/core";

@Directive({
  selector: "[appBetterHighlight]",
})
export class BetterHighlightDirective {
  constructor(private elementRef: ElementRef, private renderer: Renderer2) {}

  @HostListener("mouseenter") mouseover(event: Event) {
    this.renderer.setStyle(
      this.elementRef.nativeElement,
      "background-color",
      "blue"
    );
  }

  @HostListener("mouseleave") mouseleave(event: Event) {
    this.renderer.setStyle(
      this.elementRef.nativeElement,
      "background-color",
      "transparent"
    );
  }
}
```

File: src/app/app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <p appBasicHighlight>Style me with basic directive!</p>
      <p appBetterHighlight>Style me with basic directive!</p>
    </div>
  </div>
</div>
```

<br>

## Video 100

### Hosting Binding

File: src/app/better-highlight.directive.ts

```ts
import {
  Directive,
  ElementRef,
  Renderer2,
  HostListener,
  HostBinding,
} from "@angular/core";

@Directive({
  selector: "[appBetterHighlight]",
})
export class BetterHighlightDirective {
  @HostBinding("style.backgroundColor") backgroundColor: string = "transparent";

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {}

  @HostListener("mouseenter") mouseover(event: Event) {
    this.backgroundColor = "blue";
  }

  @HostListener("mouseleave") mouseleave(event: Event) {
    this.backgroundColor = "transparent";
  }
}
```

File: src/app/app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <p appBasicHighlight>Style me with basic directive!</p>
      <p appBetterHighlight>Style me with basic directive!</p>
    </div>
  </div>
</div>
```

<br>

## Video 101

### Custom Attribute Directive Values

File: src/app/better-highlight.directive.ts

```ts
import {
  Directive,
  ElementRef,
  Renderer2,
  HostListener,
  HostBinding,
  Input,
} from "@angular/core";

@Directive({
  selector: "[appBetterHighlight]",
})
export class BetterHighlightDirective {
  @Input() defaultColor: string = "transparent";
  @Input() highlightColor: string = "blue";
  @HostBinding("style.backgroundColor") backgroundColor: string;

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {}

  ngOnInit() {
    this.backgroundColor = this.defaultColor;
  }

  @HostListener("mouseenter") mouseover(event: Event) {
    this.backgroundColor = this.highlightColor;
  }

  @HostListener("mouseleave") mouseleave(event: Event) {
    this.backgroundColor = this.defaultColor;
  }
}
```

File: src/app/app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <p appBasicHighlight>Style me with basic directive!</p>
      <p appBetterHighlight [defaultColor]="'yellow'" [highlightColor]="'red'">
        Style me with basic directive!
      </p>
    </div>
  </div>
</div>
```

### Improvment

File: src/app/better-highlight.directive.ts

```ts
import {
  Directive,
  ElementRef,
  Renderer2,
  HostListener,
  HostBinding,
  Input,
} from "@angular/core";

@Directive({
  selector: "[appBetterHighlight]",
})
export class BetterHighlightDirective {
  @Input() defaultColor: string = "transparent";
  @Input("appBetterHighlight") highlightColor: string = "blue";
  @HostBinding("style.backgroundColor") backgroundColor: string;

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {}

  ngOnInit() {
    this.backgroundColor = this.defaultColor;
  }

  @HostListener("mouseenter") mouseover(event: Event) {
    this.backgroundColor = this.highlightColor;
  }

  @HostListener("mouseleave") mouseleave(event: Event) {
    this.backgroundColor = this.defaultColor;
  }
}
```

File: src/app/app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <p appBasicHighlight>Style me with basic directive!</p>
      <p appBetterHighlight="red" defaultColor="yellow">
        Style me with basic directive!
      </p>
    </div>
  </div>
</div>
```

<br>

## Video 103

### Custom Structural Directive

File: src/app/better-highlight.directive.ts

```ts
import { Directive, Input, TemplateRef, ViewContainerRef } from "@angular/core";

@Directive({
  selector: "[appUnless]",
})
export class UnlessDirective {
  @Input() set appUnless(condition: boolean) {
    if (!condition) {
      this.viewContainerRef.createEmbeddedView(this.templateRef);
    } else {
      this.viewContainerRef.clear();
    }
  }

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainerRef: ViewContainerRef
  ) {}
}
```

File: src/app/app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <button class="btn btn-primary" (click)="onlyOdd = !onlyOdd">
        Only show odd numbers
      </button>
      <br /><br />
      <ul class="list-group">
        <div *appUnless="onlyOdd">
          <li class="list-group-item" *ngFor="let odd of oddNumbers">
            {{ odd }}
          </li>
        </div>
      </ul>
      <p appBasicHighlight>Style me with basic directive!</p>
      <p appBetterHighlight="red" defaultColor="yellow">
        Style me with basic directive!
      </p>
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
  oddNumbers = [1, 3, 5];
  evenNumbers = [2, 4];
  onlyOdd = false;
}
```

<br>
