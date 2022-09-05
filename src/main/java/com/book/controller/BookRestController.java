package com.book.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.BookService;

@RestController
@RequestMapping("/")
public class BookRestController extends BaseController {

	@Autowired
	BookService bookService; // dependency

	// GetMapping reader can read book

	@GetMapping("/readers/{emailId}/books/{bookId}")
	Book getUser(@PathVariable String emailId, @PathVariable Integer bookId) {
		return bookService.getBook(bookId);
	}

	// GetMapping reader can find all purchased books
	@GetMapping("/readers/{emailId}/books")
	List<Book> getAllBooks(@PathVariable String emailId) {
		return bookService.getAllBooks();
	}

	// GetMapping reader can search
	// books("books/search/category/author/price/publisher")

	@GetMapping("/books/search")
	List<Book> searchBooks(@RequestParam String category, @RequestParam String author, @RequestParam BigDecimal price,
			@RequestParam String publisher) {
		List<Book> list = bookService.searchBooks(category, author, price, publisher);
		return list;
	}

	// Post mapping author can create book

	@PostMapping("/author/{authorId}/books")
	Integer saveBook(@PathVariable String authorId, @Valid @RequestBody Book book) {
		book.setAuthor(authorId);
		bookService.addBooks(book);
		return book.getId();
	}

}
