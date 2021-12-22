import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  handleSubmit(loginForm:NgForm){
    console.log('submit button is clicked')
    console.log(loginForm.form)
  }

}
