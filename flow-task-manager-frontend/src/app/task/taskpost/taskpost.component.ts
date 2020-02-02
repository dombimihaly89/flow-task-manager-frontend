import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Task } from 'src/app/models/task';
import { TaskService } from 'src/app/services/taskservice/task.service';

@Component({
  selector: 'app-taskpost',
  templateUrl: './taskpost.component.html',
  styleUrls: ['./taskpost.component.css']
})
export class TaskpostComponent implements OnInit {

  @ViewChild('taskpost', {static: false}) 
  taskPostForm: NgForm;

  title: string;
  type: string;
  content: string;
  difficulty: string;

  constructor(private taskService: TaskService) { }

  ngOnInit() {
  }

  onSubmit() {
    const data = {
      type: this.type,
      title: this.title,
      content: this.content,
      difficulty: this.difficulty,
      mentorId: 1,
      userIds: [1]
    }
    this.taskService.postTask(data);
  } 

}
