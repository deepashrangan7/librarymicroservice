package com.heptagon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.heptagon.model.Author;
import com.heptagon.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> getAllAuthors() {

		return authorRepository.findAll();

	}

	public Author addAuthor(Author author) {
		try {
			return authorRepository.save(author);
		} catch (Exception e) {

			return null;
		}
	}

	public Author getAuthor(Long authorId) {

		Optional<Author> author = authorRepository.findById(authorId);
		if (author.isPresent())
			return author.get();
		return null;
	}

	public boolean deleteAuthor(Long authorId) {

		try {
			authorRepository.deleteById(authorId);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Author editauthor(Long authorId, Author author) {

		Optional<Author> optionalAuthor = authorRepository.findById(authorId);
		if (optionalAuthor.isPresent()) {
			Author oldAuthor = optionalAuthor.get();
			oldAuthor.setAge(author.getAge());
			oldAuthor.setName(author.getName());
			oldAuthor.setPassword(author.getPassword());
			oldAuthor.setMyBooks(oldAuthor.getMyBooks());
			try {
				return authorRepository.save(oldAuthor);
			} catch (Exception e) {

			}
		}

		return null;
	}

}
