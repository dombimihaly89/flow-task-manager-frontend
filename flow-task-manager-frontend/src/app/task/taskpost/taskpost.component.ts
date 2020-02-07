import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Task } from 'src/app/models/task';
import { TaskService } from 'src/app/services/taskservice/task.service';
import { AuthService } from 'src/app/auth/auth.service';
import { UserService } from 'src/app/services/userservice/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-taskpost',
  templateUrl: './taskpost.component.html',
  styleUrls: ['./taskpost.component.css']
})
export class TaskpostComponent implements OnInit {

  @ViewChild('taskpost', {static: false}) 
  taskPostForm: NgForm;

  user : any;
  title: string;
  type: string;
  content: string;
  difficulty: string;

  constructor(private taskService: TaskService, private authService: AuthService, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.userService.findUserByUsername(this.authService.getUserName()).subscribe(
      (data) => {
        this.user = data;
        console.log('USERRRRR', this.user, 'USs');
      }
    )
  }

  onSubmit() {
    const data = {
      username: this.user.username,
      type: this.type,
      title: this.title,
      content: this.content,
      difficulty: this.difficulty,
      mentorId: this.user.id,
      // userIds: [1]
    }
    this.taskService.postTask(data).subscribe(() => 
    {
      this.backHome();
    });
  } 

  backHome() {
    this.router.navigate(['/tasklist']);
  }

}
