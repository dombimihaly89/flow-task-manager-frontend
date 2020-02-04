import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/userservice/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-userregistration',
  templateUrl: './userregistration.component.html',
  styleUrls: ['./userregistration.component.css']
})
export class UserregistrationComponent implements OnInit {

  constructor(private userService: UserService, private router : Router, private route: ActivatedRoute) { }

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
  }

  navigateToUserLogin() {
      this.router.navigate(['userlogin']);
  }

}
