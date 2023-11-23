# [Angular Note](../README.md) - Chapter 6 View Encapsulation

## Video 75
### View Encapsulation
File: src/app/app.component.ts
```ts
import { Component, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  encapsulation: ViewEncapsulation.None
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
