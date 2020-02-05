import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/userservice/user.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  constructor(private userService: UserService) { }

  
  username: string;
  password: string;


  isValid: any; // behaviour subject

  user: any;

  ngOnInit() {
  }

  onSubmit() {
    const data = {
      username: this.username,
      password: this.password,
    }
    this.userService.validateUser(this.username, this.password).subscribe(
      (data) => {
        this.isValid = data;
      }
    );
    // this.navigateToUserLogin();
  }

}

