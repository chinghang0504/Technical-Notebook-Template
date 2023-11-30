# [Angular Note](../README.md) - Chapter 17 HTTP (Firebase)

## Video 259

### Using POST Method

File: app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <form #postForm="ngForm" (ngSubmit)="onCreatePost(postForm.value)">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            required
            ngModel
            name="title"
          />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            class="form-control"
            id="content"
            required
            ngModel
            name="content"
          ></textarea>
        </div>
        <button
          class="btn btn-primary"
          type="submit"
          [disabled]="!postForm.valid"
        >
          Send Post
        </button>
      </form>
    </div>
  </div>
  <hr />
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <button class="btn btn-primary" (click)="onFetchPosts()">
        Fetch Posts
      </button>
      |
      <button
        class="btn btn-danger"
        [disabled]="loadedPosts.length < 1"
        (click)="onClearPosts()"
      >
        Clear Posts
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <p>No posts available!</p>
    </div>
  </div>
</div>
```

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {}

  onCreatePost(postData: { title: string; content: string }) {
    // Send Http request
    this.http
      .post(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  onFetchPosts() {
    // Send Http request
  }

  onClearPosts() {
    // Send Http request
  }
}
```

<br>

## Video 260

### Using GET Method

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchPosts();
  }

  onCreatePost(postData: { title: string; content: string }) {
    this.http
      .post(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  onFetchPosts() {
    this.fetchPosts();
  }

  onClearPosts() {}

  private fetchPosts() {
    this.http
      .get(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .subscribe((posts) => {
        console.log(posts);
      });
  }
}
```

<br>

## Video 261

### Transforming GET Data Using map

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchPosts();
  }

  onCreatePost(postData: { title: string; content: string }) {
    this.http
      .post(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  onFetchPosts() {
    this.fetchPosts();
  }

  onClearPosts() {}

  private fetchPosts() {
    this.http
      .get(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData) => {
          const postsArray = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        })
      )
      .subscribe((posts) => {
        console.log(posts);
      });
  }
}
```

<br>

## Video 262

### Adding the Type to Response Data

File: post.model.ts

```ts
export interface Post {
  title: string;
  content: string;
  id?: string;
}
```

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Post } from "./post.model";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchPosts();
  }

  onCreatePost(postData: Post) {
    this.http
      .post(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  onFetchPosts() {
    this.fetchPosts();
  }

  onClearPosts() {}

  private fetchPosts() {
    this.http
      .get(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData: { [key: string]: Post }) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        })
      )
      .subscribe((posts) => {
        console.log(posts);
      });
  }
}
```

<br>

## Video 262

### Using the Generic Type in GET and POST Methods

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Post } from "./post.model";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchPosts();
  }

  onCreatePost(postData: Post) {
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  onFetchPosts() {
    this.fetchPosts();
  }

  onClearPosts() {}

  private fetchPosts() {
    this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        })
      )
      .subscribe((posts) => {
        console.log(posts);
      });
  }
}
```

<br>

## Video 263

### Showing the GET Data

File: app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <form #postForm="ngForm" (ngSubmit)="onCreatePost(postForm.value)">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            required
            ngModel
            name="title"
          />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            class="form-control"
            id="content"
            required
            ngModel
            name="content"
          ></textarea>
        </div>
        <button
          class="btn btn-primary"
          type="submit"
          [disabled]="!postForm.valid"
        >
          Send Post
        </button>
      </form>
    </div>
  </div>
  <hr />
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <button class="btn btn-primary" (click)="onFetchPosts()">
        Fetch Posts
      </button>
      |
      <button
        class="btn btn-danger"
        [disabled]="loadedPosts.length < 1"
        (click)="onClearPosts()"
      >
        Clear Posts
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <p *ngIf="loadedPosts.length < 1">No posts available!</p>
      <ul class="list-group" *ngIf="loadedPosts.length >= 1">
        <li class="list-group-item" *ngFor="let post of loadedPosts">
          <h3>{{ post.title }}</h3>
          <p>{{ post.content }}</p>
        </li>
      </ul>
    </div>
  </div>
</div>
```

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Post } from "./post.model";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts: Post[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchPosts();
  }

  onCreatePost(postData: Post) {
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  onFetchPosts() {
    this.fetchPosts();
  }

  onClearPosts() {}

  private fetchPosts() {
    this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        })
      )
      .subscribe((posts) => {
        this.loadedPosts = posts;
      });
  }
}
```

<br>

## Video 264

### Showing a Loading Indicator

File: app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <form #postForm="ngForm" (ngSubmit)="onCreatePost(postForm.value)">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            required
            ngModel
            name="title"
          />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            class="form-control"
            id="content"
            required
            ngModel
            name="content"
          ></textarea>
        </div>
        <button
          class="btn btn-primary"
          type="submit"
          [disabled]="!postForm.valid"
        >
          Send Post
        </button>
      </form>
    </div>
  </div>
  <hr />
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <button class="btn btn-primary" (click)="onFetchPosts()">
        Fetch Posts
      </button>
      |
      <button
        class="btn btn-danger"
        [disabled]="loadedPosts.length < 1"
        (click)="onClearPosts()"
      >
        Clear Posts
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <p *ngIf="loadedPosts.length < 1 && !isFetching">No posts available!</p>
      <ul class="list-group" *ngIf="loadedPosts.length >= 1 && !isFetching">
        <li class="list-group-item" *ngFor="let post of loadedPosts">
          <h3>{{ post.title }}</h3>
          <p>{{ post.content }}</p>
        </li>
      </ul>
      <p *ngIf="isFetching">Loading...</p>
    </div>
  </div>
</div>
```

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Post } from "./post.model";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts: Post[] = [];
  isFetching = false;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchPosts();
  }

  onCreatePost(postData: Post) {
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  onFetchPosts() {
    this.fetchPosts();
  }

  onClearPosts() {}

  private fetchPosts() {
    this.isFetching = true;

    this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        })
      )
      .subscribe((posts) => {
        this.isFetching = false;
        this.loadedPosts = posts;
      });
  }
}
```

<br>

## Video 265 - 266

### Creating a HTTP Service

File: posts.service.ts

```ts
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Post } from "./post.model";
import { map } from "rxjs";

@Injectable({ providedIn: "root" })
export class PostsService {
  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        })
      );
  }
}
```

File: app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <form #postForm="ngForm" (ngSubmit)="onCreatePost(postForm.value)">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            required
            ngModel
            name="title"
          />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            class="form-control"
            id="content"
            required
            ngModel
            name="content"
          ></textarea>
        </div>
        <button
          class="btn btn-primary"
          type="submit"
          [disabled]="!postForm.valid"
        >
          Send Post
        </button>
      </form>
    </div>
  </div>
  <hr />
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <button class="btn btn-primary" (click)="onFetchPosts()">
        Fetch Posts
      </button>
      |
      <button
        class="btn btn-danger"
        [disabled]="loadedPosts.length < 1"
        (click)="onClearPosts()"
      >
        Clear Posts
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <p *ngIf="loadedPosts.length < 1 && !isFetching">No posts available!</p>
      <ul class="list-group" *ngIf="loadedPosts.length >= 1 && !isFetching">
        <li class="list-group-item" *ngFor="let post of loadedPosts">
          <h3>{{ post.title }}</h3>
          <p>{{ post.content }}</p>
        </li>
      </ul>
      <p *ngIf="isFetching">Loading...</p>
    </div>
  </div>
</div>
```

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Post } from "./post.model";
import { PostsService } from "./posts.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts: Post[] = [];
  isFetching = false;

  constructor(private http: HttpClient, private postsService: PostsService) {}

  ngOnInit() {
    this.isFetching = true;
    this.postsService.fetchPosts().subscribe((posts) => {
      this.isFetching = false;
      this.loadedPosts = posts;
    });
  }

  onCreatePost(postData: Post) {
    this.postsService.createAndStorePost(postData.title, postData.content);
  }

  onFetchPosts() {
    this.isFetching = true;
    this.postsService.fetchPosts().subscribe((posts) => {
      this.isFetching = false;
      this.loadedPosts = posts;
    });
  }

  onClearPosts() {}
}
```

<br>

## Video 267

### Using DELETE Method

File: posts.service.ts

```ts
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Post } from "./post.model";
import { map } from "rxjs";

@Injectable({ providedIn: "root" })
export class PostsService {
  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }

  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        })
      );
  }

  deletePosts() {
    return this.http.delete(
      "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
    );
  }
}
```

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Post } from "./post.model";
import { PostsService } from "./posts.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts: Post[] = [];
  isFetching = false;

  constructor(private http: HttpClient, private postsService: PostsService) {}

  ngOnInit() {
    this.isFetching = true;
    this.postsService.fetchPosts().subscribe((posts) => {
      this.isFetching = false;
      this.loadedPosts = posts;
    });
  }

  onCreatePost(postData: Post) {
    this.postsService.createAndStorePost(postData.title, postData.content);
  }

  onFetchPosts() {
    this.isFetching = true;
    this.postsService.fetchPosts().subscribe((posts) => {
      this.isFetching = false;
      this.loadedPosts = posts;
    });
  }

  onClearPosts() {
    this.postsService.deletePosts().subscribe(() => {
      this.loadedPosts = [];
    });
  }
}
```

<br>

## Video 268

### Error Handling

File: app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <form #postForm="ngForm" (ngSubmit)="onCreatePost(postForm.value)">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            required
            ngModel
            name="title"
          />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            class="form-control"
            id="content"
            required
            ngModel
            name="content"
          ></textarea>
        </div>
        <button
          class="btn btn-primary"
          type="submit"
          [disabled]="!postForm.valid"
        >
          Send Post
        </button>
      </form>
    </div>
  </div>
  <hr />
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <button class="btn btn-primary" (click)="onFetchPosts()">
        Fetch Posts
      </button>
      |
      <button
        class="btn btn-danger"
        [disabled]="loadedPosts.length < 1"
        (click)="onClearPosts()"
      >
        Clear Posts
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <p *ngIf="loadedPosts.length < 1 && !isFetching">No posts available!</p>
      <ul class="list-group" *ngIf="loadedPosts.length >= 1 && !isFetching">
        <li class="list-group-item" *ngFor="let post of loadedPosts">
          <h3>{{ post.title }}</h3>
          <p>{{ post.content }}</p>
        </li>
      </ul>
      <p *ngIf="isFetching && !error">Loading...</p>
      <div class="alert alert-danger" *ngIf="error">
        <h1>An Error Occurred!</h1>
        <p>{{ error }}</p>
      </div>
    </div>
  </div>
</div>
```

File: app.component.ts

```ts
import { Component, OnInit } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Post } from "./post.model";
import { PostsService } from "./posts.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  loadedPosts: Post[] = [];
  isFetching = false;
  error = null;

  constructor(private http: HttpClient, private postsService: PostsService) {}

  ngOnInit() {
    this.isFetching = true;
    this.postsService.fetchPosts().subscribe(
      (posts) => {
        this.isFetching = false;
        this.loadedPosts = posts;
      },
      (error) => {
        this.error = error.message;
      }
    );
  }

  onCreatePost(postData: Post) {
    this.postsService.createAndStorePost(postData.title, postData.content);
  }

  onFetchPosts() {
    this.isFetching = true;
    this.postsService.fetchPosts().subscribe(
      (posts) => {
        this.isFetching = false;
        this.loadedPosts = posts;
      },
      (error) => {
        this.error = error.message;
      }
    );
  }

  onClearPosts() {
    this.postsService.deletePosts().subscribe(() => {
      this.loadedPosts = [];
    });
  }
}
```

<br>

## Video 269

### Using Subject to Handle Error

File: posts.service.ts

```ts
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Post } from "./post.model";
import { Subject, map } from "rxjs";

@Injectable({ providedIn: "root" })
export class PostsService {
  error = new Subject<string>();

  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe(
        (responseData) => {
          console.log(responseData);
        },
        (error) => {
          this.error.next(error.message);
        }
      );
  }

  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        })
      );
  }

  deletePosts() {
    return this.http.delete(
      "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
    );
  }
}
```

File: app.component.ts

```ts
import { Component, OnInit, OnDestroy } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Subscription } from "rxjs";
import { Post } from "./post.model";
import { PostsService } from "./posts.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit, OnDestroy {
  loadedPosts: Post[] = [];
  isFetching = false;
  error = null;
  private errorSub: Subscription;

  constructor(private http: HttpClient, private postsService: PostsService) {}

  ngOnInit() {
    this.errorSub = this.postsService.error.subscribe((errorMessage) => {
      this.error = errorMessage;
    });

    this.isFetching = true;
    this.postsService.fetchPosts().subscribe(
      (posts) => {
        this.isFetching = false;
        this.loadedPosts = posts;
      },
      (error) => {
        this.error = error.message;
      }
    );
  }

  onCreatePost(postData: Post) {
    this.postsService.createAndStorePost(postData.title, postData.content);
  }

  onFetchPosts() {
    this.isFetching = true;
    this.postsService.fetchPosts().subscribe(
      (posts) => {
        this.isFetching = false;
        this.loadedPosts = posts;
      },
      (error) => {
        this.error = error.message;
      }
    );
  }

  onClearPosts() {
    this.postsService.deletePosts().subscribe(() => {
      this.loadedPosts = [];
    });
  }

  ngOnDestroy() {
    this.errorSub.unsubscribe();
  }
}
```

<br>

## Video 270 - 271

### Using catchError Operator

File: posts.service.ts

```ts
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Post } from "./post.model";
import { Subject, catchError, map, throwError } from "rxjs";

@Injectable({ providedIn: "root" })
export class PostsService {
  error = new Subject<string>();

  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe(
        (responseData) => {
          console.log(responseData);
        },
        (error) => {
          this.error.next(error.message);
        }
      );
  }

  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        }),
        catchError((errorRes) => {
          return throwError(errorRes);
        })
      );
  }

  deletePosts() {
    return this.http.delete(
      "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
    );
  }
}
```

File: app.component.html

```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <form #postForm="ngForm" (ngSubmit)="onCreatePost(postForm.value)">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            required
            ngModel
            name="title"
          />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            class="form-control"
            id="content"
            required
            ngModel
            name="content"
          ></textarea>
        </div>
        <button
          class="btn btn-primary"
          type="submit"
          [disabled]="!postForm.valid"
        >
          Send Post
        </button>
      </form>
    </div>
  </div>
  <hr />
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <button class="btn btn-primary" (click)="onFetchPosts()">
        Fetch Posts
      </button>
      |
      <button
        class="btn btn-danger"
        [disabled]="loadedPosts.length < 1"
        (click)="onClearPosts()"
      >
        Clear Posts
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col-xs-12 col-md-6 col-md-offset-3">
      <p *ngIf="loadedPosts.length < 1 && !isFetching">No posts available!</p>
      <ul class="list-group" *ngIf="loadedPosts.length >= 1 && !isFetching">
        <li class="list-group-item" *ngFor="let post of loadedPosts">
          <h3>{{ post.title }}</h3>
          <p>{{ post.content }}</p>
        </li>
      </ul>
      <p *ngIf="isFetching && !error">Loading...</p>
      <div class="alert alert-danger" *ngIf="error">
        <h1>An Error Occurred!</h1>
        <p>{{ error }}</p>
        <button class="btn btn-danger" (click)="onHandleError()">Okay</button>
      </div>
    </div>
  </div>
</div>
```

File: app.component.ts

```ts
import { Component, OnInit, OnDestroy } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Subscription } from "rxjs";
import { Post } from "./post.model";
import { PostsService } from "./posts.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit, OnDestroy {
  loadedPosts: Post[] = [];
  isFetching = false;
  error = null;
  private errorSub: Subscription;

  constructor(private http: HttpClient, private postsService: PostsService) {}

  ngOnInit() {
    this.errorSub = this.postsService.error.subscribe((errorMessage) => {
      this.error = errorMessage;
    });

    this.isFetching = true;
    this.postsService.fetchPosts().subscribe(
      (posts) => {
        this.isFetching = false;
        this.loadedPosts = posts;
      },
      (error) => {
        this.isFetching = false;
        this.error = error.message;
      }
    );
  }

  onCreatePost(postData: Post) {
    this.postsService.createAndStorePost(postData.title, postData.content);
  }

  onFetchPosts() {
    this.isFetching = true;
    this.postsService.fetchPosts().subscribe(
      (posts) => {
        this.isFetching = false;
        this.loadedPosts = posts;
      },
      (error) => {
        this.isFetching = false;
        this.error = error.message;
      }
    );
  }

  onClearPosts() {
    this.postsService.deletePosts().subscribe(() => {
      this.loadedPosts = [];
    });
  }

  onHandleError() {
    this.error = null;
  }

  ngOnDestroy() {
    this.errorSub.unsubscribe();
  }
}
```

<br>

## Video 272

### Setting HTTP Headers

File: posts.service.ts

```ts
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Post } from "./post.model";
import { Subject, catchError, map, throwError } from "rxjs";

@Injectable({ providedIn: "root" })
export class PostsService {
  error = new Subject<string>();

  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe(
        (responseData) => {
          console.log(responseData);
        },
        (error) => {
          this.error.next(error.message);
        }
      );
  }

  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        {
          headers: new HttpHeaders({
            "Custom-Header": "Hello",
          }),
        }
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        }),
        catchError((errorRes) => {
          return throwError(errorRes);
        })
      );
  }

  deletePosts() {
    return this.http.delete(
      "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
    );
  }
}
```

<br>

## Video 273

### Setting HTTP Parameters

File: posts.service.ts

```ts
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Post } from "./post.model";
import { Subject, catchError, map, throwError } from "rxjs";

@Injectable({ providedIn: "root" })
export class PostsService {
  error = new Subject<string>();

  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData
      )
      .subscribe(
        (responseData) => {
          console.log(responseData);
        },
        (error) => {
          this.error.next(error.message);
        }
      );
  }

  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        {
          headers: new HttpHeaders({
            "Custom-Header": "Hello",
          }),
          params: new HttpParams().set("print", "pretty"),
        }
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        }),
        catchError((errorRes) => {
          return throwError(errorRes);
        })
      );
  }

  deletePosts() {
    return this.http.delete(
      "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json"
    );
  }
}
```

<br>

## Video 274 - 275

### Returning Specific Response Data

File: posts.service.ts

```ts
import {
  HttpClient,
  HttpEventType,
  HttpHeaders,
  HttpParams,
} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Post } from "./post.model";
import { Subject, catchError, map, tap, throwError } from "rxjs";

@Injectable({ providedIn: "root" })
export class PostsService {
  error = new Subject<string>();

  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    const postData: Post = { title: title, content: content };
    this.http
      .post<{ name: string }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        postData,
        {
          observe: "response",
        }
      )
      .subscribe(
        (responseData) => {
          console.log(responseData);
        },
        (error) => {
          this.error.next(error.message);
        }
      );
  }

  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        {
          headers: new HttpHeaders({
            "Custom-Header": "Hello",
          }),
          params: new HttpParams().set("print", "pretty"),
        }
      )
      .pipe(
        map((responseData) => {
          const postsArray: Post[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({
                ...responseData[key],
                id: key,
              });
            }
          }
          return postsArray;
        }),
        catchError((errorRes) => {
          return throwError(errorRes);
        })
      );
  }

  deletePosts() {
    return this.http
      .delete(
        "https://ng-complete-guide-63906-default-rtdb.firebaseio.com/posts.json",
        {
          observe: "events",
          responseType: "json",
        }
      )
      .pipe(
        tap((event) => {
          console.log(event);
          if (event.type === HttpEventType.Sent) {
            // ...
          }
          if (event.type === HttpEventType.Response) {
            console.log(event.body);
          }
        })
      );
  }
}
```

<br>

## Video 276 - 279

### HTTP Interceptors

<br>
