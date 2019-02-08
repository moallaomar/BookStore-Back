package com.Bookstore.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookstore.demo.model.Book;

@Service
public class BookServiceImpl implements BookService { 
	
	@Autowired
	private BookRepository bookRepository;
	
	 public List<Book> getAll() {
		  List<Book> employees = bookRepository.findAll();
		  return employees;
		 }
		  
		 public Book getBook(Long bookId) {
		  Optional<Book> optEmp = bookRepository.findById(bookId);
		  return optEmp.get();
		 }
		  
		 public void saveBook(Book book){
		  bookRepository.save(book);
		 }
		  
		 public void deleteBook(Long bookId){
		  bookRepository.deleteById(bookId);
		 }
		  
		 public void updateBook(Book book) {
		  bookRepository.save(book);
		 }
		 public Long countBook() {
			 return bookRepository.count();
		 }

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

}
