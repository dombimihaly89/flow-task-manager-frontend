import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { of } from 'rxjs';
import { Task } from 'src/app/models/task';


@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpClient: HttpClient) { }

  getTasks() {
    return this.httpClient.get('http://localhost:8080/api/tasks/findall');
  }

}
