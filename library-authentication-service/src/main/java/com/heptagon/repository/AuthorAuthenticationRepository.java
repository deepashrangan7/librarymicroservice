package com.heptagon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heptagon.model.Author;

@Repository
public interface AuthorAuthenticationRepository extends JpaRepository<Author, Long> {

	public Author findByEmailAndPassword(String email, String password);

	public Author findByEmail(String email);

	public Author findByName(String name);

}
