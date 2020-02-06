import { Component, OnInit, Input } from '@angular/core';
import { PostService } from '../services/postservice/post.service';
import { DataService } from '../services/data.service';
import { UserService } from '../services/userservice/user.service';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private postService: PostService, private dataService: DataService, private userService: UserService, private authService: AuthService) { }


  @Input('poster')
  post: any;

  user: any;
  username: string;


  ngOnInit() {
    this.userService.findUserByUsername(this.authService.getUserName()).subscribe(
      (data) => {
        this.user = data;
        this.username = this.user.username;
      }
    )
  }

}
