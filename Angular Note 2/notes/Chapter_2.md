# [Angular Note 2](../README.md) - Chapter 2 CLI

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 2.1 | [Creating a New Project](#21-creating-a-new-project) |
| 2.2 | [Running in Development Mode](#22-running-in-development-mode) |
| 2.3 | [Building a Product](#23-building-a-product) |
| 2.4 | [Generating a Component](#24-generating-a-component) |
| 2.5 | [Generating a Directive](#25-generating-a-directive) |
| 2.6 | [Generating a Service](#26-generating-a-service) |

<br>
<hr>

### 2.1 Creating a New Project
```shell
ng new FirstProject
```
```shell
ng n FirstProject
```

[Common Arguments](https://angular.io/cli/new)
| Argument | Description | Value Type | Default Value |
| :- | :- | :- | :- |
| --standalone | Creates an application based upon the standalone API, without NgModules. | boolean | true |
| --skip-tests | Do not generate "spec.ts" test files for the new project. | boolean | false |
| --strict | Creates a workspace with stricter type checking and stricter bundle budgets settings. This setting helps improve maintainability and catch bugs ahead of time. | boolean | true |
| --routing | Enable routing in the initial project. | boolean | |

<br>
<hr>

### 2.2 Running in Development Mode
```shell
ng serve
```
```shell
ng s
```
- Local Link: [http://localhost:4200/](http://localhost:4200/)

[Common Arguments](https://angular.io/cli/serve)
| Argument | Description | Value Type | Default Value |
| :- | :- | :- | :- |
| --open | Opens the url in default browser. | boolean | false |
| --port | Port to listen on. | number | 4200 |

<br>
<hr>

### 2.3 Building a Product
```shell
ng build
```
```shell
ng b
```

<br>
<hr>

### 2.4 Generating a Component
```shell
ng generate component FirstComponent
```
```shell
ng g c FirstComponent
```

<br>
<hr>

### 2.5 Generating a Directive
```shell
ng generate directive FirstDirective
```
```shell
ng g d FirstDirective
```

<br>
<hr>

### 2.6 Generating a Service
```shell
ng generate service FirstService
```
```shell
ng g s FirstService
```
