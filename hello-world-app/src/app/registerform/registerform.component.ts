import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-registerform',
  templateUrl: './registerform.component.html',
  styleUrls: ['./registerform.component.css']
})
export class RegisterformComponent implements OnInit {

  public registerForm:FormGroup;

  public get emailControl(){
    return this.registerForm.get('email');
  }

  public get nameControl(){
    return this.registerForm.get('name')
  }

  public get passwordControl(){
    return this.registerForm.get('password')
  }

  constructor() { 
    this.registerForm = new FormGroup({
      name : new FormControl('', [Validators.required, this.myCustomValidator]), 
      email : new FormControl('', [Validators.required, Validators.minLength(5) ]), 
      password : new FormControl('', Validators.required)
    })
  }

  public myCustomValidator(control: AbstractControl): ValidationErrors | null{
      
    if( (control.value as string).indexOf(' ') >= 0 ){
        return { cannotContainSpace : true }
    }

    return null;
  }

  ngOnInit(): void {
  }

  handleRegister(){
    console.log('Submit button is clicked')
    console.log(this.registerForm)
  }
}
