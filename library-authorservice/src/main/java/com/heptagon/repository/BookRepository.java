package com.heptagon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heptagon.model.Author;
import com.heptagon.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//do CRUD operation with book table

	public List<Book> findByAuthor(Author author);// finding the books of that particular author

}
