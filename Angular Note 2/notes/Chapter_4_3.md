# [Angular Note 2](../README.md) - Chapter 4.3 Components: View Encapsulation

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 4.3.1 | [Modes of View Encapsulation](#431-modes-of-view-encapsulation) |
| 4.3.2 | [Disabling View Encapsulation](#432-disabling-view-encapsulation) |

<br>
<hr>

### 4.3.1 Modes of View Encapsulation
| Mode | Details |
| :- | :- |
| ViewEncapsulation.ShadowDom | Angular uses the browser's built-in Shadow DOM API to enclose the component's view inside a ShadowRoot, used as the component's host element, and apply the provided styles in an isolated manner. |
| ViewEncapsulation.Emulated | Angular modifies the component's CSS selectors so that they are only applied to the component's view and do not affect other elements in the application, emulating Shadow DOM behavior. |
| ViewEncapsulation.None | Angular does not apply any sort of view encapsulation meaning that any styles specified for the component are actually globally applied and can affect any HTML element present within the application. This mode is essentially the same as including the styles into the HTML itself. |

<br>
<hr>

### 4.3.2 Disabling View Encapsulation
```ts
import { Component, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css',
  encapsulation: ViewEncapsulation.None
})
```
