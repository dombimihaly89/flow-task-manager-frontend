import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient: HttpClient) { }

  getPostById() {
    return this.httpClient.get('http://localhost:8080/api/tasks/findall');
  }

  postSolution(data: any) {
    this.httpClient.post('http://localhost:8080/api/posts', data).subscribe(
      responseData => {
        console.log(responseData);
      }
    );
  }
}
