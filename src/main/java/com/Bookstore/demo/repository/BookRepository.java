package com.Bookstore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Bookstore.demo.model.Book;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {

	  

}
