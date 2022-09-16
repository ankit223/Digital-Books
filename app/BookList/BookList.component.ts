import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import Book from '../entity/Book';


@Component({
  selector: 'app-BookList',
  templateUrl: './BookList.component.html',
  styleUrls: ['./BookList.component.scss']
})
export class BookListComponent implements OnInit {

  book: Book = new Book('Ankit', 'abdc', 'COMIC', 20, 'xyx', 'ankit', 'abcde', true);
  books: any = [];
  constructor(public bookService: BookService) { }


  ngOnInit(): void {

  }


  save() {
    console.log('clicked');
    const observable = this.bookService.addBook(this.book);
    observable.subscribe((response) => {
      console.log(response);
    },
      (error) => {
        alert('something went wrong');
      })
  }



}

