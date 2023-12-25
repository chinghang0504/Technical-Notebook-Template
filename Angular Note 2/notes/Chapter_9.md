# [Angular Note 2](../README.md) - Chapter 9 Observables

### Table of Contents
| Chapter | Title |
| :-: | :- |
| 9.1 | [Subscribing and Unsubscribing an Observable](#91-subscribing-and-unsubscribing-an-observable) |
| 9.2 | [Creating an Observable](#92-creating-an-observable) |
| 9.3 | [Observable Error and Complete Handling](#93-observable-error-and-complete-handling) |
| 9.4 | [Observable with Pipes (filter and map)](#94-observable-with-pipes-filter-and-map) |
| 9.5 | [Subjects](#95-subjects) |

<br>
<hr>

### 9.1 Subscribing and Unsubscribing an Observable
```ts
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription, interval } from 'rxjs';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent implements OnInit, OnDestroy {

  private subscription: Subscription;

  ngOnInit(): void {
    this.subscription = interval(1000).subscribe((value) => {
      console.log(value);
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
```

<br>
<hr>

### 9.2 Creating an Observable
```ts
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent implements OnInit, OnDestroy {

  private subscription: Subscription;

  ngOnInit(): void {
    const observable = new Observable((subscribe) => {
      let count = 0;
      setInterval(() => {
        subscribe.next(count++);
      }, 1000);
    });

    this.subscription = observable.subscribe((value) => {
      console.log(value);
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
```

<br>

```ts
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent implements OnInit, OnDestroy {

  private subscription: Subscription;

  ngOnInit(): void {
    const observable = new Observable((subscribe) => {
      let count = 0;
      setInterval(() => {
        subscribe.next(count++);

        if (count === 9) {
          subscribe.error('Reached 9');
        } else if (count === 10) {
          subscribe.complete();
        }
      }, 1000);
    });

    this.subscription = observable.subscribe({
      next(value) {
        console.log(value);
      }
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
```

<br>
<hr>

### 9.3 Observable Error and Complete Handling
```ts
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent implements OnInit, OnDestroy {

  private subscription: Subscription;

  ngOnInit(): void {
    const observable = new Observable((subscribe) => {
      let count = 0;
      setInterval(() => {
        subscribe.next(count++);

        if (count === 9) {
          subscribe.error('Reached 9');
        } else if (count === 10) {
          subscribe.complete();
        }
      }, 1000);
    });

    this.subscription = observable.subscribe({
      next(value) {
        console.log(value);
      },
      error(err) {
        console.log(`Error: ${err}`);
      },
      complete() {
        console.log('System: Completed!');
      }
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
```

<br>
<hr>

### 9.4 Observable with Pipes (filter and map)
```ts
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription, filter, map } from 'rxjs';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent implements OnInit, OnDestroy {

  private subscription: Subscription;

  ngOnInit(): void {
    const observable = new Observable((subscribe) => {
      let count = 0;
      setInterval(() => {
        subscribe.next(count++);

        if (count === 9) {
          subscribe.error('Reached 9');
        } else if (count === 10) {
          subscribe.complete();
        }
      }, 1000);
    });

    this.subscription = observable
      .pipe(
        filter((value: number) => {
          return value % 2 == 0;
        }),
        map((value: number) => {
          return `Data: ${value}`;
        })
      ).subscribe({
      next(value) {
        console.log(value);
      },
      error(err) {
        console.log(`Error: ${err}`);
      },
      complete() {
        console.log('System: Completed!');
      }
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
```

<br>
<hr>

### 9.5 Subjects
```ts
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrl: './first-component.component.css'
})
export class FirstComponentComponent implements OnInit, OnDestroy {

  private count = 0;
  private subject: Subject<number>;

  ngOnInit(): void {
    this.subject = new Subject<number>();
    this.subject.subscribe({
      next(value) {
        console.log(value);
      },
      error(err) {
        console.log(`Error: ${err}`);
      },
      complete() {
        console.log('System: Completed!');
      }
    });
  }

  ngOnDestroy(): void {
    this.subject.unsubscribe();
  }

  onClick() {
    if (this.count === 9) {
      this.subject.error('Reached 9');
    } else if (this.count === 10) {
      this.subject.complete();
    } else {
      this.subject.next(this.count++);
    }
  }
}
```
