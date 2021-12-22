import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public companyName :string;
  public isActive:boolean = false;

  constructor() {
    this.companyName = 'LnT'

    setTimeout(() => {
      this.companyName = 'Larsen & Turbo'
    }, 8000);

   }

  ngOnInit(): void {
  }

  handleClick () {
    console.log('This is handleclick method')
  }

  handleMouseOver(){
    this.isActive = true;
  }

  handleMouseOut(){
    this.isActive = false;
  }

}
