import { Component, OnInit, OnChanges } from '@angular/core';
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
    this.taskService.tasksSub.subscribe(data => {
      this.tasks = data;
      console.log('tasks changed-----------------------------------------', data)
    })
    this.taskService.getTasks().subscribe(
      (data) => {
        this.tasks = data;
      }
    )
    this.taskService.fetchTasks();
    /* console.log(this.tasks); */
  }

}
