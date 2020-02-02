import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient: HttpClient) { }

  getPostById(id : number) {
    return this.httpClient.get('http://localhost:8080/api/posts/findPostsByTaskId/' + id);
  }

  postSolution(data: any) {
    this.httpClient.post('http://localhost:8080/api/posts', data).subscribe(
      responseData => {
        console.log(responseData);
      }
    );
  }
}
