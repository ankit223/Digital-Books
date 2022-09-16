import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './BookList/BookList.component';
import { GetAllBooksComponent } from './get-all-books/get-all-books.component';
import { SearchbooksComponent } from './searchbooks/searchbooks.component';


const routes: Routes = [
  { path: 'booklist', component: BookListComponent },
  { path: 'getallbooks', component: GetAllBooksComponent },
  { path: 'searchbooks', component: SearchbooksComponent }
  
]

@NgModule({
  declarations: [
    AppComponent, BookListComponent, GetAllBooksComponent, SearchbooksComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule, HttpClientModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
