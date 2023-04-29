import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { loginRequest } from '../models/login-request.model';
import { loginResponse } from '../models/login-response.model';
import { Response } from '../models/responsedto/response.model';
import { Router } from '@angular/router';
import { Role } from '../enums/role.enum';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private securityChange = new Subject<boolean>();
  private token: string;
  private apiUrl = `${environment.apiURL}/auth/login`;

  constructor(private router: Router, private http: HttpClient) { }

  login(login: loginRequest): void {

    const headers = new HttpHeaders().set('X-Auth-VideoStore-Header', 'yes');

    this.http.post<Response<loginResponse>>(`${this.apiUrl}`, login, { headers, withCredentials: true })
    .subscribe((response) => {
      
      this.token = response.data.token;

      localStorage.setItem('token', response.data.token);
      
      response.data.role == Role.Admin ? this.router.navigate(['/users']) : this.router.navigate(['/shop'])
    });
  }

  register(user: loginRequest): void {
    
    this.http.post<Response<loginResponse>>(`${this.apiUrl}`, user)
    .subscribe((response) => {
      this.token = response.data.token;

      

      this.securityChange.next(true);
      localStorage.setItem('toke', response.data.token);
      this.router.navigate(['/'])
    });
  }

  getToken(): string {
    return this.token;
  }
}