# [Angular Note 2](../README.md) - Chapter 4.6 Components: Content Projection

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 4.6.1 | [NgContent](#461-ngcontent) |

<br>
<hr>

### 4.6.1 NgContent
File: first-compontent.component.html
```html
<p>First Component - Start </p>
<app-second-component>
    <p>Inserted Content</p>
</app-second-component>
<p>First Component - End </p>
```

File: second-compontent.component.html
```html
<p>Second Component - Start </p>
<ng-content></ng-content>
<p>Second Component - End </p>
```
