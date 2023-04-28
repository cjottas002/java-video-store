import { IMovie } from "./interfaces/movie.interface";

export class Movie implements IMovie{
    id: string;
    title: string;
    director: string;
    releaseYear: number;
    
    constructor(id: string, title: string, director: string, releaseYear: number) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }
 }
  