import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CourseListComponent } from './course-list/course-list.component';
import { HighlightDirective } from './mydirectives/highlight.directive';
import { LoginformComponent } from './loginform/loginform.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterformComponent } from './registerform/registerform.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { RouterModule, Routes } from '@angular/router';

const appRoutes:Routes = [
  { path : '', component : HomeComponent }, 
  { path : 'movies', component : MovieListComponent }, 
  { path : 'login', component : LoginformComponent  }, 
  { path : 'register', component : RegisterformComponent},
  { path : 'courses', component : CourseListComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    CourseListComponent,
    HighlightDirective,
    LoginformComponent,
    RegisterformComponent,
    MovieListComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule, 
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule, 
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
