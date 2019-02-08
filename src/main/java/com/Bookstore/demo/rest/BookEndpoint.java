package com.Bookstore.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bookstore.demo.model.Book;
import com.Bookstore.demo.repository.BookService;
import com.Bookstore.demo.util.NumberGenerator;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookEndpoint {

	// ======================================
	// = Injection Points =
	// ======================================
	@Autowired
	private BookService bookService;
	@Autowired
	 private NumberGenerator generator;
	

	// ======================================
	// = Business methods =
	// ======================================
	@PostMapping("/book")
	public void createBook(@RequestBody Book book) {
		book.setIsbn(generator.generateNumber());
		book.setTitle(generator.sanitize(book.getTitle()));
		bookService.saveBook(book);

		System.out.println("Book Saved Successfully");

	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") long id) {
		return bookService.getBook(id);

	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Book> getBooks() {
		List<Book> books = bookService.getAll();

		if (books.size() == 0)
			System.out.println("null bro !");

		System.out.println("all books bro");
		return books;
	}

	@GetMapping("/count")
	public Long countBooks() {
		Long nbOfBooks = bookService.countBook();

		if (nbOfBooks == 0)
			System.out.println("zéro !");

		return nbOfBooks;

	}

	public NumberGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(NumberGenerator generator) {
		this.generator = generator;
	}

}
