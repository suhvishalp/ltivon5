import { Component, OnInit } from '@angular/core';
import { MovieService } from '../myservices/movie.service';
import { Movie } from '../model/movie.model';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  public movieList:Movie[] = [];

  constructor(private movieService:MovieService) {
    
    movieService.getMovies()
                  .subscribe(
                    (response: Movie[])=> {
                      console.log('response recd. successfully')
                      console.log(response)
                      this.movieList = response;
                    },
                    (error) => {
                      alert('something went wrong')
                    }
                  )

  }

  ngOnInit(): void {
  }

}
