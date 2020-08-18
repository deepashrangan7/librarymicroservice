package com.heptagon.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.heptagon.model.Book;
import com.heptagon.service.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/all") // get all books
	public List<Book> allBooks() {

		return bookService.getAllBooks();
	}

	@GetMapping("/all/author/{authorid}") // get all books of that particular Author
	public List<Book> authorsBooks(@PathVariable("authorid") Long authorId) {

		return bookService.findAllBooksByAuthor(authorId);

	}

	@GetMapping("/view/{bookid}") // view a book based on bookId
	public Book viewBook(@PathVariable("bookid") Long bookId) {

		return bookService.getBook(bookId);
	}

	@DeleteMapping("/{bookid}/author/{authorid}") // delete the book of the author based authorId passed
	public ResponseEntity<Void> deleteBook(@PathVariable("bookid") Long bookId,
			@PathVariable("authorid") Long authorId) {
		boolean flag = bookService.deleteBook(bookId, authorId);
		if (flag)
			return ResponseEntity.ok().build();
		return ResponseEntity.badRequest().build();

	}

	@PutMapping("/{bookid}/author/{authorid}") // editing book of the author based authorId passed
	public ResponseEntity<Book> editAuthor(@RequestBody Book book, @PathVariable("bookid") Long bookId,
			@PathVariable("authorid") Long authorId) {

		Book editedBook = bookService.editBook(bookId, book, authorId);
		if (editedBook == null) {
			return new ResponseEntity<Book>(editedBook, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Book>(editedBook, HttpStatus.OK);

	}

	@PostMapping("/add/author/{authorid}") // add book to that particular author
	public Book addBook(@RequestBody Book newBook, @PathVariable("authorid") Long authorId) {

		Book addedBook = bookService.addBook(authorId, newBook);

		return addedBook;
	}
}
