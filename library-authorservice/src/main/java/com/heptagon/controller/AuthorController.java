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
import com.heptagon.model.Author;
import com.heptagon.service.AuthorService;

@RestController
@RequestMapping("/author")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/all")
	public List<Author> getAllAuthors() {

		return authorService.getAllAuthors();
	}

	@GetMapping("/view/{authorid}")
	public Author getAuthor(@PathVariable("authorid") Long authorId) {

		return authorService.getAuthor(authorId);
	}

	@PostMapping("/add")
	public ResponseEntity<Author> addAuthor(@RequestBody Author newAuthor) {

		Author author = authorService.addAuthor(newAuthor);

		if (author == null) {

			return new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{authorid}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable("authorid") Long authorId) {
		if (authorService.deleteAuthor(authorId))
			return ResponseEntity.ok().build();
		return ResponseEntity.badRequest().build();

	}

	@PutMapping("/{authorid}")
	public ResponseEntity<Author> editAuthor(@RequestBody Author author, @PathVariable("authorid") Long authorId) {
		Author editedAuthor = authorService.editauthor(authorId, author);

		if (editedAuthor == null) {

			return new ResponseEntity<Author>(editedAuthor, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Author>(editedAuthor, HttpStatus.OK);

	}
}
