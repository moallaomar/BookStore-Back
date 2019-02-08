package com.Bookstore.demo.repository;

import java.util.List;

import com.Bookstore.demo.model.Book;

public interface BookService  {

	 public void updateBook(Book book) ;
	 public void deleteBook(Long bookId);
	 public void saveBook(Book book);
	 public Book getBook(Long bookId);
	 public List<Book> getAll();
	 public Long countBook();
}
