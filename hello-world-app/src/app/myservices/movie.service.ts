import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movie } from '../model/movie.model';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private apiUrl:string = 'http://localhost:3900/api/movies';

  constructor(private http:HttpClient) { }

  public getMovies(){
    return this.http.get<Movie[]>(this.apiUrl)
  }

}
