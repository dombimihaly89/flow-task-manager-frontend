import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/services/taskservice/task.service';
import { Task } from 'src/app/models/task';

@Component({
  selector: 'app-tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.css']
})
export class TasklistComponent implements OnInit {

  constructor(private taskService: TaskService) { }

  tasks : any;

  ngOnInit() {
    this.taskService.getTasks().subscribe(
      (data) => {
        this.tasks = data;
      }
    )
    console.log(this.tasks);
  }

}
