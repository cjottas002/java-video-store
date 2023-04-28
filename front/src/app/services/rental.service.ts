import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rental } from '../models/rental.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RentalService {

  private apiUrl = `${environment.apiURL}rentals`;

  constructor(private http: HttpClient) { }

  getRentals(): Observable<Rental[]> {
    return this.http.get<Rental[]>(this.apiUrl);
  }

  // Add more methods for other operations as needed
}
