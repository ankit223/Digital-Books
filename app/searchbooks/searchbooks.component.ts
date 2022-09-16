import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import Book from '../entity/Book';

@Component({
  selector: 'app-searchbooks',
  templateUrl: './searchbooks.component.html',
  styleUrls: ['./searchbooks.component.scss']
})
export class SearchbooksComponent implements OnInit {
  book: Book = new Book('Ankit', 'abdc', 'COMIC', 20, 'xyx', 'ankit', 'abcde', true);
  books: any = [];
  category: String = 'MYSTERY';
  author: String = 'David';
  price: number = 1;
  publisher: String = 'Nano';
  constructor(public bookService: BookService) { }

  ngOnInit(): void {
  }
 
  searchBooks(){
    console.log("clicked");
    const observable = this.bookService.searchBooks(this.category, this.author, this.price, this.publisher);
    observable.subscribe((books)=>{
      console.log(books);
      this.books = books;
    })
      
    }
}
