import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/userservice/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-userregistration',
  templateUrl: './userregistration.component.html',
  styleUrls: ['./userregistration.component.css']
})
export class UserregistrationComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  onSubmit(form: NgForm) {
    const firstName = form.value.firstName;
    const lastName = form.value.lastName;
    const username = form.value.username;
    const password = form.value.password;
    const email = form.value.email;
    const birthDate = form.value.birthDate;
    console.log(firstName, lastName, username, email, birthDate);

    let authObservable: Observable<any>;

    // tslint:disable-next-line: max-line-length
    authObservable = this.authService.register(firstName, lastName, username, password, email, birthDate);

    authObservable.subscribe(resData => {
      console.log(resData);
      this.router.navigate(['/login']);
    }, error => {
      console.log(error);
    });
  }

  backHome() {
    this.router.navigate(['']);
  }

  ngOnInit() {
  }







  /* constructor(private userService: UserService, private router : Router, private route: ActivatedRoute, private dataService: DataService) { }

  id: number
  role: string;
  userName: string;
  password: string;
  firstName: string;
  lastName: string;
  dateOfBirth: string;

  ngOnInit() {
  }

  onSubmit() {
    const data = {
      role: this.role,
      username: this.userName,
      password: this.password,
      firstName: this.firstName,
      lastName: this.lastName,
      dateOfBirth: this.dateOfBirth
    }
    this.userService.createUser(data);
    this.navigateToUserLogin();
    this.dataService.dataSource.next(
      {
        username: this.userName,
        password: this.password
      }
    )
    this.dataService.dataSource.subscribe(data => {
      console.log('next', data)

    })
  }

  navigateToUserLogin() {
      this.router.navigate(['userlogin']);
  } */

}
