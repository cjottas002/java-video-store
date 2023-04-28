import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './components/user/user.component';
import { MovieComponent } from './components/movie/movie.component';
import { RentalComponent } from './components/rental/rental.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'users', component: UserComponent },
  { path: 'movies', component: MovieComponent },
  { path: 'rentals', component: RentalComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
