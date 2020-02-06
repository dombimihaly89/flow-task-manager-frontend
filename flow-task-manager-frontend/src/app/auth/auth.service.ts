import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { BehaviorSubject, throwError } from 'rxjs';
import { AuthToken } from './authtoken.model';
import { Router } from '@angular/router';
import { UserService } from '../services/userservice/user.service';

export interface AuthResponseData {
  access_token: string;
  token_type: string;
  refresh_token: string;
  expires_in: number;
  scope: string;
  jti: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  token = new BehaviorSubject<AuthToken>(null);
  username: string;

  getUserName() {
    return this.username;
  }

  constructor(private http: HttpClient, private router: Router, private userService: UserService) {}

  login(username: string, password: string) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + btoa('fooClientIdPassword:secret')
    });   
    this.username = username;
    const body = new HttpParams()
      .set('grant_type', 'password')
      .set('username', username)
      .set('password', password);

    return this.http.post<AuthResponseData>(
      'http://localhost:8080/oauth/token', body, { headers: headers}
    ).pipe(
      catchError(this.handleError),
      tap(resData => this.getToken(resData))
    );
  }

  register(firstName: string, lastName: string, username: string, password: string, dateOfBirth: Date, role: string) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const body = {
      'firstName': firstName,
      'lastName': lastName,
      'username': username,
      'password': password,
      'dateOfBirth': dateOfBirth,
      'role': role
    }
    return this.http.post(
      'http://localhost:8080/api/users/register', body, {headers: headers}
    );
  }

  logout() {
    this.token.next(null);
    this.router.navigate(['']);
    localStorage.removeItem('tokenData');
  }

  private getToken(authRes: AuthResponseData) {
    const token = new AuthToken(
      authRes.access_token, authRes.token_type,
      authRes.refresh_token, authRes.expires_in,
      authRes.scope, authRes.jti);
      console.log(token);
    this.token.next(token);
  }

  private handleError(errorResponse: HttpErrorResponse) {
    let errorMessage = 'An error occured';
    console.log(errorResponse);
    return throwError(errorMessage);
  }
}