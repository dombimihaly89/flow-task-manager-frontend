import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';

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

  findUserByUsername(username: string) {
    return this.httpClient.get(`http://localhost:8080/api/users/${username}/names`);
  }

  findUserById(id: number): Observable<User> {
    return this.httpClient.get<User>(`http://localhost:8080/api/users/${id}/ids`);
  }
  
}
