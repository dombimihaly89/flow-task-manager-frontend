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
  date: string = "";

  user: any;
  username: string;


  ngOnInit() {
    this.postService.findUserByPostId(this.post.id).subscribe(
      (data) => {
        this.user = data;
        this.username = this.user.username;
      }
    )
    this.dateFormatter();
  }

  dateFormatter() {
    this.date = this.post.createdAt.toString()
    console.log('Createddddddddddddddd ', this.date);
    this.date = this.post.createdAt[0] + "." + this.post.createdAt[1] + "." + this.post.createdAt[2] + " " +
    this.post.createdAt[3] + ":" + this.post.createdAt[4] + ":" + this.post.createdAt[5];
    console.log(this.date);
  }

  setCharAt(str,index,chr) {
    if(index > str.length-1) return str;
    return str.substr(0,index) + chr + str.substr(index+1);
}

}
