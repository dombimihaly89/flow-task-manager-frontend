import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth/auth.service';
import { UserService } from '../services/userservice/user.service';
import { User } from '../models/user';

/* @Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  role : any;

  ngOnInit() {
  }

} */

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  constructor(private authService: AuthService, private router: Router, private userService: UserService) {}

  user: any;

  onSubmit(form: NgForm) {
    const username = form.value.username;
    const password = form.value.password;
    console.log(username, password);

    let authObservable: Observable<any>;

    authObservable = this.authService.login(username, password);

    authObservable.subscribe(resData => {
      console.log(resData);
      this.router.navigate(['/taskpost']);
    }, error => {
      console.log(error);
    });
  }

  backHome() {
    this.router.navigate(['']);
  }

  ngOnInit() {
  }

}
