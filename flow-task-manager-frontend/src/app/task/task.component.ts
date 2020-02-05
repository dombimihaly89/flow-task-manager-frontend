import { Component, OnInit, Input } from '@angular/core';
import { TaskService } from 'src/app/services/taskservice/task.service';
import { Task } from 'src/app/models/task';
import { getMatInputUnsupportedTypeError } from '@angular/material';
import { PostService } from '../services/postservice/post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  @Input()
  task : any;

  posts : any;

  ratingAverage: number;

  rating: number;
  ratingButton: boolean = false;

  constructor(private taskService: TaskService, private postService: PostService, private router: Router) { }

  ngOnInit() {
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

}
