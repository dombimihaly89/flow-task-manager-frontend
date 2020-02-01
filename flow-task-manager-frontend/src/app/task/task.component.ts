import { Component, OnInit, Input } from '@angular/core';
import { TaskService } from 'src/app/services/taskservice/task.service';
import { Task } from 'src/app/models/task';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  @Input()
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
