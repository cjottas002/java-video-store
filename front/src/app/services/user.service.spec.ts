import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { UserService } from './user.service';
import { environment } from 'src/environments/environment';

describe('UserService', () => {
  let service: UserService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [UserService]
    });
    service = TestBed.inject(UserService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch users as an Observable', () => {
    const dummyUsers = [
      { id: '1', username: 'John', password: 'john123', role: 'USER' },
      { id: '2', username: 'Jim', password: 'jim123', role: 'ADMIN' }
    ];

    service.getUsers().subscribe(users => {
      expect(users.length).toBe(2);
      expect(users).toEqual(dummyUsers);
    });

    const request = httpMock.expectOne(`${environment.apiURL}/users`);

    expect(request.request.method).toBe('GET');

    request.flush(dummyUsers);
  });
});
