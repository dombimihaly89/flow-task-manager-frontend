import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  constructor(private httpClient: HttpClient) { }
  
  createUser(data: { role: string; username: string; password: string; firstName: string; lastName: string; dateOfBirth: string; }) {
    this.httpClient.post('http://localhost:8080/api/users/register', data).subscribe(
      responseData => {
        console.log(responseData);
      }
    )
  }

  validateUser(username: string, password: string) {
    return this.httpClient.get(`http://localhost:8080/api/users/validate/${username}/${password}`)
  }

  
  
}
