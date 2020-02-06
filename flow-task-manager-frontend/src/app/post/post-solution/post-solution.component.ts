import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PostService } from 'src/app/services/postservice/post.service';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/userservice/user.service';
import { AuthService } from 'src/app/auth/auth.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-post-solution',
  templateUrl: './post-solution.component.html',
  styleUrls: ['./post-solution.component.css']
})
export class PostSolutionComponent implements OnInit {

  @ViewChild('postSolution', {static: false}) 
  taskPostForm: NgForm;

  content: string;
  user: any;

  constructor(private postService: PostService, private activatedRoute: ActivatedRoute, private userService: UserService, private authService: AuthService) { }

  taskId: number = 0;

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(params => {
      console.log('param1', params.taskId);
      console.log('param2', params);
      this.taskId = params.taskId;
    });

    this.userService.findUserByUsername(this.authService.getUserName()).subscribe(
      (data) => {
        this.user = data;
      }
    )

  }

  onSubmit() {
    const data = {
      content: this.content,
      type: "SOLUTION",
      taskId: this.taskId,
      userId: this.user.id
    }
    console.log(data);
    this.postService.postSolution(data);
  } 
}
