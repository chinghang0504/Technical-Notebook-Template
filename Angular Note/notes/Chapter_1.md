# [Angular Note](../README.md) - Chapter 1

## Video 6

### Install Angular

```shell
npm install -g @angular/cli
```

### Create a New Application

```shell
ng new my-first-app --no-strict --standalone false --routing false
CSS
n
```

### Run an Application

```shell
ng serve
```

### Webpage

- http://localhost:4200/

<br>

## Video 12

### Install bootstrap

```shell
npm install bootstrap --save
```

File: src/angular.json

```json
"styles": [
    "node_modules/bootstrap/dist/css/bootstrap.min.css",
    "src/styles.css"
]
```

### Index Page and App Root

File: src/index.html

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>MyFirstApp</title>
    <base href="/" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
  </head>
  <body>
    <app-root></app-root>
  </body>
</html>
```

File: src/app/app.component.ts

```ts
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrl: "./app.component.css",
})
export class AppComponent {
  title = "my-first-app";
}
```

<br>
