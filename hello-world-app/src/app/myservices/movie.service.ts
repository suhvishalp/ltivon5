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

  public save(movie:Movie){
    if(movie._id){
      //make put request to update the given movie
      const tobeUpdated = { title : movie.title, numberInStock : movie.numberInStock, genreId: movie.genre._id, dailyRentalRate : movie.dailyRentalRate}
      return this.http.put<Movie>(this.apiUrl + '/' + movie._id, tobeUpdated);
    }
    //make a post request 
    return this.http.post<Movie>(this.apiUrl, movie);
  }

  public getMovie(id:string){
    return this.http.get<Movie>(this.apiUrl + '/' + id)
  }

  public deleteMovie(id:string){
    return this.http.delete<Movie>(this.apiUrl + '/' + id);
  }

}
