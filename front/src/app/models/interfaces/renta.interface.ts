import { Movie } from "../movie.model";
import { User } from "../user.model";


export interface IRental {
  id: string;
  user: User;
  movie: Movie;
  rentalDate: Date;
  returnDate?: Date;
  available: boolean;
}
