import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { RentalService } from './rental.service';
import { environment } from 'src/environments/environment';
import { User } from '../models/user.model';
import { Movie } from '../models/movie.model';
import { Rental } from '../models/rental.model';

describe('RentalService', () => {
  let service: RentalService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [RentalService]
    });
    service = TestBed.inject(RentalService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch rentals as an Observable', () => {
    const dummyUser = new User('1', 'user1', 'password', 'role');
    const dummyMovie = new Movie('1', 'title', 'director', 2023);
  
    const dummyRentals = [
      new Rental('1', dummyUser, dummyMovie, new Date('2023-01-01'), new Date('2023-01-10'), true),
      new Rental('2', dummyUser, dummyMovie, new Date('2023-01-02'), new Date('2023-01-11'), false)
    ];

    service.getRentals().subscribe(rentals => {
      expect(rentals.length).toBe(2);
      expect(rentals).toEqual(dummyRentals);
    });

    const request = httpMock.expectOne(`${environment.apiURL}/rentals`);

    expect(request.request.method).toBe('GET');

    request.flush(dummyRentals);
  });
});
