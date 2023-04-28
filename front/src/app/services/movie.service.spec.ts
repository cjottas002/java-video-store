import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { MovieService } from './movie.service';
import { environment } from 'src/environments/environment';

describe('MovieService', () => {
  let service: MovieService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [MovieService]
    });
    service = TestBed.inject(MovieService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch movies as an Observable', () => {
    const dummyMovies = [
      { id: '1', title: 'Movie 1', director: 'Director 1', releaseYear: 2001 },
      { id: '2', title: 'Movie 2', director: 'Director 2', releaseYear: 2002 }
    ];

    service.getMovies().subscribe(movies => {
      expect(movies.length).toBe(2);
      expect(movies).toEqual(dummyMovies);
    });

    const request = httpMock.expectOne(`${environment.apiURL}/movies`);

    expect(request.request.method).toBe('GET');

    request.flush(dummyMovies);
  });
});
