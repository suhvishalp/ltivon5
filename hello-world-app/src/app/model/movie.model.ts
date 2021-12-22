import { Genre } from './genre.model';

export class Movie {

    constructor(public _id:string, 
        public title:string, 
        public genre:Genre,
        public numberInStock:number,
        public dailyRentalRate:number){}

}