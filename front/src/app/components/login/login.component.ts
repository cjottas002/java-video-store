import { Component } from '@angular/core';
import { loginRequest } from 'src/app/models/login-request.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string;
  password: string;

  constructor(private authService: AuthService) { }

  onSubmit(): void {
    let login: loginRequest = {
      username: this.username,
      password: this.password
    };

    this.authService.login(login);
  }
}
