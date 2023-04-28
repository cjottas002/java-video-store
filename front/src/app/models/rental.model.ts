import { Movie } from "./movie.model";
import { User } from "./user.model";
import { IRental } from "./interfaces/renta.interface";

export class Rental implements IRental{
  id: string;
  user: User;
  movie: Movie;
  rentalDate: Date;
  returnDate?: Date;
  available: boolean;

  constructor(id: string, user: User, movie: Movie, rentalDate: Date, returnDate: Date, available: boolean) {
    this.id = id;
    this.user = user;
    this.movie = movie;
    this.rentalDate = rentalDate;
    this.returnDate = returnDate;
    this.available = available;
  }    
}
