package com.book.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Book addBooks(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public List<Book> searchBooks(String category, String author, BigDecimal price, String publisher) {
		List<Book> list = new ArrayList<>();
		Iterator<Book> itr = bookRepository.findAll().iterator();
		while (itr.hasNext()) {
			Book book = itr.next();
			if (book.getCategory().equalsIgnoreCase(category) || book.getAuthor().equalsIgnoreCase(author)
					|| (book.getPrice() == price) || book.getPublisher().equalsIgnoreCase(publisher)) {
				list.add(book);
			}
		}
		return list;
	}

	public Book getBook(Integer bookId) {
		return bookRepository.findById(bookId).get();
	}

}
