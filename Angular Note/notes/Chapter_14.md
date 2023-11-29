# [Angular Note](../README.md) - Chapter 14 Forms (Template-Driven)

## Video 191
### ngSubmit with ElementRef
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit(f)" #f>
        <div id="user-data">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username">
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email">
          </div>
        </div>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select id="secret" class="form-control" ngModel name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <button class="btn btn-primary" type="submit">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  suggestUserName() {
    const suggestedName = 'Superuser';
  }

  onSubmit(form: ElementRef) {
    console.log(form);
  }
}
```

<br>

## Video 191
### ngSubmit with ngForm
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit(f)" #f="ngForm">
        <div id="user-data">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username">
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email">
          </div>
        </div>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select id="secret" class="form-control" ngModel name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <button class="btn btn-primary" type="submit">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  suggestUserName() {
    const suggestedName = 'Superuser';
  }

  onSubmit(form: NgForm) {
    console.log(form);
  }
}
```

<br>

## Video 193
### ngSubmit with ViewChild
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div id="user-data">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username">
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email">
          </div>
        </div>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select id="secret" class="form-control" ngModel name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <button class="btn btn-primary" type="submit">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;

  suggestUserName() {
    const suggestedName = 'Superuser';
  }

  onSubmit() {
    console.log(this.signupForm);
  }
}
```

<br>

## Video 194
### Input Validation (required and email)
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div id="user-data">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username" required>
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email>
          </div>
        </div>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select id="secret" class="form-control" ngModel name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <button class="btn btn-primary" type="submit">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;

  suggestUserName() {
    const suggestedName = 'Superuser';
  }

  onSubmit() {
    console.log(this.signupForm);
  }
}
```

<br>

## Video 196
### Disabling Submit Button if the Form is invalid
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div id="user-data">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username" required>
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email>
          </div>
        </div>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select id="secret" class="form-control" ngModel name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <button 
          class="btn btn-primary"
          type="submit"
          [disabled]="!f.valid">Submit</button>
      </form>
    </div>
  </div>
</div>
```

<br>

## Video 196 - 197
### Input Helping Message
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div id="user-data">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username" required>
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email #email="ngModel">
            <span class="help-block" *ngIf="!email.valid && email.touched">Please enter a valid email!</span>
          </div>
        </div>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select id="secret" class="form-control" ngModel name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <button 
          class="btn btn-primary"
          type="submit"
          [disabled]="!f.valid">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.css
```css
.container {
  margin-top: 30px;
}

input.ng-invalid.ng-touched {
  border: 1px solid red;
}
```

<br>

## Video 198
### Select Default Value
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div id="user-data">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username" required>
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email #email="ngModel">
            <span class="help-block" *ngIf="!email.valid && email.touched">Please enter a valid email!</span>
          </div>
        </div>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select 
            id="secret" 
            class="form-control" 
            [ngModel]="defaultQuestion"
            name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <button 
          class="btn btn-primary"
          type="submit"
          [disabled]="!f.valid">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;
  defaultQuestion = 'pet';

  suggestUserName() {
    const suggestedName = 'Superuser';
  }

  onSubmit() {
    console.log(this.signupForm);
  }
}
```

<br>

## Video 199
### Two-Way-Biding Input
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div id="user-data">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username" required>
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email #email="ngModel">
            <span class="help-block" *ngIf="!email.valid && email.touched">Please enter a valid email!</span>
          </div>
        </div>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select 
            id="secret" 
            class="form-control" 
            [ngModel]="defaultQuestion"
            name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <div class="form-group">
          <textarea
            class="form-control"
            name="questionAnswer"
            rows="3"
            [(ngModel)]="answer"></textarea>
        </div>
        <p>Your reply: {{ answer }}</p>
        <button 
          class="btn btn-primary"
          type="submit"
          [disabled]="!f.valid">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;
  defaultQuestion = 'pet';
  answer = '';
  
  suggestUserName() {
    const suggestedName = 'Superuser';
  }

  onSubmit() {
    console.log(this.signupForm);
  }
}
```

<br>

## Video 200
### ngModelGroup
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div 
          id="user-data" 
          ngModelGroup="userData"
          #userData="ngModelGroup">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username" required>
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email #email="ngModel">
            <span class="help-block" *ngIf="!email.valid && email.touched">Please enter a valid email!</span>
          </div>
        </div>
        <p *ngIf="!userData.valid && userData.touched">User Data is invalid!</p>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select 
            id="secret" 
            class="form-control" 
            [ngModel]="defaultQuestion"
            name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <div class="form-group">
          <textarea
            class="form-control"
            name="questionAnswer"
            rows="3"
            [(ngModel)]="answer"></textarea>
        </div>
        <p>Your reply: {{ answer }}</p>
        <button 
          class="btn btn-primary"
          type="submit"
          [disabled]="!f.valid">Submit</button>
      </form>
    </div>
  </div>
</div>
```

<br>

## Video 201
### Radio Buttons
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div 
          id="user-data" 
          ngModelGroup="userData"
          #userData="ngModelGroup">
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" ngModel name="username" required>
          </div>
          <button class="btn btn-default" type="button">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email #email="ngModel">
            <span class="help-block" *ngIf="!email.valid && email.touched">Please enter a valid email!</span>
          </div>
        </div>
        <p *ngIf="!userData.valid && userData.touched">User Data is invalid!</p>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select 
            id="secret" 
            class="form-control" 
            [ngModel]="defaultQuestion"
            name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <div class="form-group">
          <textarea
            class="form-control"
            name="questionAnswer"
            rows="3"
            [(ngModel)]="answer"></textarea>
        </div>
        <p>Your reply: {{ answer }}</p>
        <div class="radio" *ngFor="let gender of genders">
          <label><input type="radio" name="gender" ngModel [value]="gender">{{ gender }}</label>
        </div>
        <button 
          class="btn btn-primary"
          type="submit"
          [disabled]="!f.valid">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;
  defaultQuestion = 'pet';
  answer = '';
  genders = ['male', 'female'];

  suggestUserName() {
    const suggestedName = 'Superuser';
  }

  onSubmit() {
    console.log(this.signupForm);
  }
}
```

<br>

## Video 202
### Set Form Value
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div 
          id="user-data" 
          ngModelGroup="userData"
          #userData="ngModelGroup">
          <div class="form-group">
            <label for="username">Username</label>
            <input 
              type="text" 
              id="username" 
              class="form-control" 
              ngModel 
              name="username" 
              required>
          </div>
          <button class="btn btn-default" type="button" (click)="suggestUserName()">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email #email="ngModel">
            <span class="help-block" *ngIf="!email.valid && email.touched">Please enter a valid email!</span>
          </div>
        </div>
        <p *ngIf="!userData.valid && userData.touched">User Data is invalid!</p>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select 
            id="secret" 
            class="form-control" 
            [ngModel]="defaultQuestion"
            name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <div class="form-group">
          <textarea
            class="form-control"
            name="questionAnswer"
            rows="3"
            [(ngModel)]="answer"></textarea>
        </div>
        <p>Your reply: {{ answer }}</p>
        <div class="radio" *ngFor="let gender of genders">
          <label><input type="radio" name="gender" ngModel [value]="gender">{{ gender }}</label>
        </div>
        <button 
          class="btn btn-primary"
          type="submit"
          [disabled]="!f.valid">Submit</button>
      </form>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;
  defaultQuestion = 'pet';
  answer = '';
  genders = ['male', 'female'];

  suggestUserName() {
    const suggestedName = 'Superuser';
    this.signupForm.setValue({
      userData: {
        username: suggestedName,
        email: ''
      },
      secret: 'pet',
      questionAnswer: '',
      gender: 'male'
    });
  }

  onSubmit() {
    console.log(this.signupForm);
  }
}
```

<br>

## Video 202
### Set Specific Form Value
File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;
  defaultQuestion = 'pet';
  answer = '';
  genders = ['male', 'female'];

  suggestUserName() {
    const suggestedName = 'Superuser';
    this.signupForm.form.patchValue({
      userData: {
        username: suggestedName,
      }
    });
  }

  onSubmit() {
    console.log(this.signupForm);
  }
}
```

<br>

## Video 203
### Showing Form Data
File: app.component.html
```html
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2">
      <form (ngSubmit)="onSubmit()" #f="ngForm">
        <div 
          id="user-data" 
          ngModelGroup="userData"
          #userData="ngModelGroup">
          <div class="form-group">
            <label for="username">Username</label>
            <input 
              type="text" 
              id="username" 
              class="form-control" 
              ngModel 
              name="username" 
              required>
          </div>
          <button class="btn btn-default" type="button" (click)="suggestUserName()">Suggest an Username</button>
          <div class="form-group">
            <label for="email">Mail</label>
            <input type="email" id="email" class="form-control" ngModel name="email" required email #email="ngModel">
            <span class="help-block" *ngIf="!email.valid && email.touched">Please enter a valid email!</span>
          </div>
        </div>
        <p *ngIf="!userData.valid && userData.touched">User Data is invalid!</p>
        <div class="form-group">
          <label for="secret">Secret Questions</label>
          <select 
            id="secret" 
            class="form-control" 
            [ngModel]="defaultQuestion"
            name="secret">
            <option value="pet">Your first Pet?</option>
            <option value="teacher">Your first teacher?</option>
          </select>
        </div>
        <div class="form-group">
          <textarea
            class="form-control"
            name="questionAnswer"
            rows="3"
            [(ngModel)]="answer"></textarea>
        </div>
        <p>Your reply: {{ answer }}</p>
        <div class="radio" *ngFor="let gender of genders">
          <label><input type="radio" name="gender" ngModel [value]="gender">{{ gender }}</label>
        </div>
        <button 
          class="btn btn-primary"
          type="submit"
          [disabled]="!f.valid">Submit</button>
      </form>
    </div>
  </div>
  <hr>
  <div class="row" *ngIf="submitted">
    <div class="col-xs-12">
      <h3>Your Data</h3>
      <p>Username: {{ user.username }}</p>
      <p>Mail: {{ user.email }}</p>
      <p>Secret Question: {{ user.secretQuestion }}</p>
      <p>Answer: {{ user.answer }}</p>
      <p>Gender: {{ user.gender }}</p>
    </div>
  </div>
</div>
```

File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;
  defaultQuestion = 'pet';
  answer = '';
  genders = ['male', 'female'];
  user = {
    username: '',
    email: '',
    secretQuestion: '',
    answer: '',
    gender: ''
  };
  submitted = false;

  suggestUserName() {
    const suggestedName = 'Superuser';
    this.signupForm.form.patchValue({
      userData: {
        username: suggestedName,
      }
    });
  }

  onSubmit() {
    this.submitted = true;

    this.user.username = this.signupForm.form.value.userData.username;
    this.user.email = this.signupForm.form.value.userData.email;
    this.user.secretQuestion = this.signupForm.form.value.secret;
    this.user.answer = this.signupForm.form.value.questionAnswer;
    this.user.gender = this.signupForm.form.value.gender;
  }
}
```

<br>

## Video 204
### Reset the Form
File: app.component.ts
```ts
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;
  defaultQuestion = 'pet';
  answer = '';
  genders = ['male', 'female'];
  user = {
    username: '',
    email: '',
    secretQuestion: '',
    answer: '',
    gender: ''
  };
  submitted = false;

  suggestUserName() {
    const suggestedName = 'Superuser';
    this.signupForm.form.patchValue({
      userData: {
        username: suggestedName,
      }
    });
  }

  onSubmit() {
    this.submitted = true;

    this.user.username = this.signupForm.form.value.userData.username;
    this.user.email = this.signupForm.form.value.userData.email;
    this.user.secretQuestion = this.signupForm.form.value.secret;
    this.user.answer = this.signupForm.form.value.questionAnswer;
    this.user.gender = this.signupForm.form.value.gender;

    this.signupForm.reset();
  }
}
```

<br>
