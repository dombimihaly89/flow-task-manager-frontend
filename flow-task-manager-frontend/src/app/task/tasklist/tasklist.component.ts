import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/services/taskservice/task.service';
import { Task } from 'src/app/models/task';

@Component({
  selector: 'app-tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.css']
})
export class TasklistComponent implements OnInit {

  tasks : any;
  ratingAverage: number;

  constructor(private taskService: TaskService) { }

  ngOnInit() {
    this.taskService.getTasks().subscribe(
      (data) => {
        this.tasks = data;
      }
    )
    console.log(this.tasks);
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

}
