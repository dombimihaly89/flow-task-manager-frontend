import { Component, OnInit, Input } from '@angular/core';
import { TaskService } from 'src/app/services/taskservice/task.service';
import { Task } from 'src/app/models/task';
import { getMatInputUnsupportedTypeError } from '@angular/material';
import { PostService } from '../services/postservice/post.service';
import { Router } from '@angular/router';
import { UserService } from '../services/userservice/user.service';
import { User } from '../models/user';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  @Input()
  task : any;
  mentor: any;
  mentorName: string = "";
  date: string = "";

  posts : any;

  ratingAverage: number;

  rating: number;
  ratingButton: boolean = false;

  constructor(private taskService: TaskService, private postService: PostService, private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.userService.findUserById(this.task.mentorId).subscribe(
      (data) => {
        this.mentor = data;
        this.mentorName = data.username;
      }
    )
    this.dateFormatter();
  }

  getRating(task) {
    let list = task.ratings;
    let sum : number = 0;
    for (let i = 0; i < list.length; i++) {
      sum += list[i];
    }
    this.ratingAverage = sum / list.length;
    return this.ratingAverage;
  }

  public navigate(url: string, taskId: number) {
    this.router.navigate([url], {queryParams: {taskId: taskId}});
  }

  public rate() {
    this.ratingButton = true;
    console.log('UserId: ', this.task.userId);
    this.taskService.addRating({
      id: this.task.id,
      rating: this.rating,
      userId: this.task.userId
    })
  }

  dateFormatter() {
    this.date = this.task.createdAt.toString()
    console.log('Createddddddddddddddd ', this.date);
    this.date = this.task.createdAt[0] + "." + this.task.createdAt[1] + "." + this.task.createdAt[2] + " " +
    this.task.createdAt[3] + ":" + this.task.createdAt[4] + ":" + this.task.createdAt[5];
    console.log(this.date);
  }

  setCharAt(str,index,chr) {
    if(index > str.length-1) return str;
    return str.substr(0,index) + chr + str.substr(index+1);
}

  deleteTask(taskId: number) {
    this.taskService.deleteTask(taskId).subscribe( data => {
      this.taskService.fetchTasks();
    });
  }

}
