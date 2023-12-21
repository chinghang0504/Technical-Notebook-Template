# [Angular Note 2](../README.md) - Chapter 1 Installation

### Table of Contents

| Chapter | Title                                                        |
| :-----: | :----------------------------------------------------------- |
|   1.1   | [Installing Node.js](#11-installing-nodejs)                  |
|   1.2   | [Installing Angular](#12-installing-angular)                 |
|   1.3   | [Installing Bootstrap](#13-installing-bootstrap)             |
|   1.4   | [Installing Bootstrap Icons](#14-installing-bootstrap-icons) |

<br>
<hr>

### 1.1 Installing Node.js

- [Node.js Download Link](https://nodejs.org/en/download)

<br>
<hr>

### 1.2 Installing Angular

```shell
npm install -g @angular/cli
```

<br>
<hr>

### 1.3 Installing Bootstrap (Each Project)

```shell
npm install bootstrap
```

File: angular.json

```typescript
"styles": [
    "node_modules/bootstrap/dist/css/bootstrap.min.css"
],
"scripts": [
    "node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
]
```

<br>
<hr>

### 1.4 Installing Bootstrap Icons (Each Project)

```shell
npm install bootstrap-icons
```

File: angular.json

```typescript
"styles": [
    "node_modules/bootstrap-icons/font/bootstrap-icons.min.css"
],
```
