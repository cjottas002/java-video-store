import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiURL = `${environment.apiURL}/users`; // Cambia esto por la URL de tu API

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiURL);
  }

  getUser(id: string): Observable<User> {
    return this.http.get<User>(`${this.apiURL}/${id}`);
  }

  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.apiURL, user);
  }

  updateUser(id: string, user: User): Observable<User> {
    return this.http.put<User>(`${this.apiURL}/${id}`, user);
  }

  deleteUser(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiURL}/${id}`);
  }
}
