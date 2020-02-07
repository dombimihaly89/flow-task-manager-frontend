import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { of, BehaviorSubject } from 'rxjs';
import { Task } from 'src/app/models/task';


@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasksSub = new BehaviorSubject<any>(null);

  constructor(private httpClient: HttpClient) { }

  fetchTasks() {
    this.httpClient.get('http://localhost:8080/api/tasks/findall').subscribe(data => {
      this.tasksSub.next(data);
    })
  }

  getTasks() {
    return this.httpClient.get('http://localhost:8080/api/tasks/findall');
  }

  postTask(data: any) {
    return this.httpClient.post('http://localhost:8080/api/tasks', data);
  }

  addRating(data: any) {
    console.log('data: ', data)
    this.httpClient.post(`http://localhost:8080/api/tasks/rate?id=${data.id}&rating=${data.rating}&userId=${data.userId}`, null).subscribe(
      responseData => {
        console.log(responseData);
      }
    );
  }

  deleteTask(id: number) {
    return this.httpClient.delete(`http://localhost:8080/api/tasks/${id}`);
  }

}
